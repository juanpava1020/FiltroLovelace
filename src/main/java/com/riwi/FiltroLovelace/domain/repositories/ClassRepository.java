package com.riwi.FiltroLovelace.domain.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.riwi.FiltroLovelace.domain.entities.ClassEntity;

public interface ClassRepository  extends JpaRepository<ClassEntity, Long> {

}