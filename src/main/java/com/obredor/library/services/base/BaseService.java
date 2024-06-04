package com.obredor.library.services.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.obredor.library.errors.exceptions.EmptyEntityListException;
import com.obredor.library.errors.exceptions.EntityNotFoundException;
import com.obredor.library.errors.exceptions.EntityWithExistingIdException;
import com.obredor.library.mappers.base.BaseMapper;
import com.obredor.library.models.entities.BaseEntity;

// TODO: Crear interfaces para solo lectura e inserción de datos

public class BaseService<T extends BaseEntity<ID>, D, ID> {

  private static final String ENTITY_SAVED_SUCCESSFULLY = "Entity saved successfully";
  private static final String ENTITY_DELETED_SUCCESSFULLY = "Entity deleted successfully";
  private static final String ENTITY_ID_NULL_ERROR = "The entity ID cannot be null";
  private static final String ENTITY_ID_NEGATIVE_ERROR = "The entity ID cannot be a negative number";

  @Autowired
  private JpaRepository<T, ID> repository;

  @Autowired
  private BaseMapper<T, D> mapper;

  public String post(T entity) {
    try {
      repository.save(entity);
      return ENTITY_SAVED_SUCCESSFULLY;
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(ENTITY_ID_NULL_ERROR);
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
      throw new IllegalArgumentException(ENTITY_ID_NULL_ERROR); 
    }

    if (id instanceof Integer && (Integer) id < 1) {
      throw new IllegalArgumentException(ENTITY_ID_NEGATIVE_ERROR);
    }

    T foundedEntity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    return mapper.toDto(foundedEntity);
  }

  public String deleteEntityById(ID id) {
    getEntityById(id);
    repository.deleteById(id);
    return ENTITY_DELETED_SUCCESSFULLY;
  }

  
  public D updateEntity(T entity) {

    if (entity == null) {
      throw new IllegalArgumentException(ENTITY_ID_NULL_ERROR); // This exception is used temporarily, for testing purposes only.
      // In the first stable release, this will be changed to a NullEntityIdException.
    }

    T foundEntity = mapper.toEntity(getEntityById(entity.getId()));

    foundEntity = entity;

    return mapper.toDto(repository.save(foundEntity));

  }
}
