package com.riwi.FiltroLovelace.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.riwi.FiltroLovelace.domain.entities.StudentEntity;

public interface StudentRepository  extends JpaRepository<StudentEntity, Long> {

  Page<StudentEntity> findByNameContainingAndActiveTrue(String name, 
      Pageable pageable);
}