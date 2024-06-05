package com.riwi.FiltroLovelace.domain.repositories;



import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.riwi.FiltroLovelace.domain.entities.ClassEntity;

public interface ClassRepository  extends JpaRepository<ClassEntity, Long> {
  Page<ClassEntity> findByNameContainingAndDescriptionContainingAndActiveTrue(String nombre, String descripcion, Pageable pageable);
  Page<ClassEntity> findAllByActiveTrue(Pageable pageable);

  Optional<ClassEntity> findByIdAndActiveTrue(Long id);
}