package com.riwi.FiltroLovelace.domain.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.riwi.FiltroLovelace.domain.entities.LessonEntity;


public interface LessonRepository  extends JpaRepository<LessonEntity, Long> {

}