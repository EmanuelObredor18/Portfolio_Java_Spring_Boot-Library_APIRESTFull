package com.obredor.library.controllers.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.obredor.library.models.entities.BaseEntity;
import com.obredor.library.services.base.BaseService;

import jakarta.validation.Valid;

@PreAuthorize("denyAll()")
public class BaseController<T extends BaseEntity<ID>, ID, S extends BaseService<T, ?, ID>> {
  
  @Autowired
  private S service;

  @GetMapping("find/all")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> getAllEntites() {
    return ResponseEntity.ok(service.getAllEntities());
  }

  @PostMapping("/new")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> getEntity(@Valid @RequestBody T entity) {
    System.out.println(entity);
    return ResponseEntity.ok(service.post(entity));
  }

  @PutMapping("/edit/{id}")
  public ResponseEntity<?> putEntity(@Valid @RequestBody T entity ) {
    return ResponseEntity.ok(service.updateEntity(entity));
  }
}
