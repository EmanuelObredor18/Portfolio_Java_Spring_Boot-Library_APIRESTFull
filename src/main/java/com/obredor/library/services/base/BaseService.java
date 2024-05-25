package com.obredor.library.services.base;

import java.util.List;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.obredor.library.errors.exceptions.EmptyEntityListException;
import com.obredor.library.errors.exceptions.EntityNotFoundException;
import com.obredor.library.errors.exceptions.EntityWithExistingIdException;
import com.obredor.library.mappers.base.GenericMapper;
import com.obredor.library.models.entities.BaseEntity;

public class BaseService<T extends BaseEntity<ID>, D, ID, R extends JpaRepository<T, ID>> {

  private final R repository;

  private final GenericMapper<T, D> mapper;

  public BaseService(final R repository, final GenericMapper<T, D> mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public String post(T entity) {
    try {
      repository.save(entity);
      return "Entity saved successfully";
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("The entity ID cannot be null");
    } catch (OptimisticLockingFailureException e) {
      throw new EntityWithExistingIdException();
    }
  }

  @Transactional(readOnly = true)
  public List<D> getAllEntities() {

    List<D> entities = repository.findAll().stream().map(mapper::toDto).toList();

    if (!entities.isEmpty()) {
      return entities;
    }

    throw new EmptyEntityListException();
  }

  public D getEntityById(ID id) throws IllegalArgumentException {

    if (id == null) {
      throw new IllegalArgumentException("The entity ID cannot be null"); 
    }

    if (id instanceof Integer && (Integer) id < 1) {
      throw new IllegalArgumentException("The entity ID cannot be a negative number");
    }

    T foundedEntity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    return mapper.toDto(foundedEntity);
  }

  public String deleteEntityById(ID id) {
    getEntityById(id);
    repository.deleteById(id);
    return "Entity deleted successfully";
  }

  
  public D updateEntity(T entity) {

    if (entity == null) {
      throw new IllegalArgumentException("The entity ID cannot be null"); // This exception is used temporarily, for testing purposes only.
      // In the first stable release, this will be changed to a NullEntityIdException.
    }

    T foundEntity = mapper.toEntity(getEntityById(entity.getId()));

    foundEntity = entity;

    return mapper.toDto(repository.save(foundEntity));

  }
}
