package com.obredor.library.repositories.user_location;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obredor.library.models.embeddables.AdministrativeDivisionId;
import com.obredor.library.models.entities.AdministrativeDivision;

public interface AdministrativeDivisionRepository
    extends JpaRepository<AdministrativeDivision, AdministrativeDivisionId> {

}
