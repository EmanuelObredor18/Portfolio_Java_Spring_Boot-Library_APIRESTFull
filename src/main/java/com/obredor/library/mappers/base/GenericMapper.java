package com.obredor.library.mappers.base;

import java.lang.reflect.ParameterizedType;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericMapper<E, D> implements BaseMapper<E, D> {

  @Autowired
  private ModelMapper modelMapper;

  private final Class<E> entityClass;
  private final Class<D> dtoClass;

  @SuppressWarnings("unchecked")
  public GenericMapper() {
    this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    this.dtoClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
  }

  @Override
  public D toDto(E entity) {
    return modelMapper.map(entity, dtoClass);
  }

  @Override
  public E toEntity(D dto) {
    return modelMapper.map(dto, entityClass);
  }
}
