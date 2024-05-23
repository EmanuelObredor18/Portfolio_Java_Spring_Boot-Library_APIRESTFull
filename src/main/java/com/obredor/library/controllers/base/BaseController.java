package com.obredor.library.controllers.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.obredor.library.services.base.BaseService;

import jakarta.validation.Valid;

@PreAuthorize("denyAll()")
public class BaseController<T, S extends BaseService<T, ?, ?, ?>> {
  
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
}
