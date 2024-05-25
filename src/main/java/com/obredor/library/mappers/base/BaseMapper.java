package com.obredor.library.mappers.base;

import com.obredor.library.models.entities.BaseEntity;

public interface BaseMapper<E extends BaseEntity<?>, D> {
  
  D toDto(E entity);

  E toEntity(D dto);

}
