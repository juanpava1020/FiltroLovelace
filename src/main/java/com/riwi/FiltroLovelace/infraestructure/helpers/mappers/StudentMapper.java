package com.riwi.FiltroLovelace.infraestructure.helpers.mappers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi.FiltroLovelace.api.dtos.request.StudentRequest;
import com.riwi.FiltroLovelace.api.dtos.response.StudentResponse;
import com.riwi.FiltroLovelace.domain.entities.ClassEntity;
import com.riwi.FiltroLovelace.domain.entities.StudentEntity;
import com.riwi.FiltroLovelace.domain.repositories.ClassRepository;
import com.riwi.FiltroLovelace.utils.exceptions.IdNotFoundException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StudentMapper {
  @Autowired
  private final ClassRepository classRepository;
  public StudentResponse toResponse(StudentEntity entity) {
    return StudentResponse.builder()
        .id(entity.getId())
        .name(entity.getName())
        .email(entity.getEmail())
        .createdAt(entity.getCreatedAt())
        .active(entity.isActive())
        .build();
  }

  public StudentEntity toEntity(StudentRequest request) {
    ClassEntity classId = classRepository.findById(request.getClassId()).orElseThrow(() -> new IdNotFoundException("Class not found", request.getClassId()));
    return StudentEntity.builder()
        .name(request.getName())
        .email(request.getEmail())
        .createdAt(LocalDateTime.now())
        .active(request.getActive())
        .classId(classId)
        .build();
  }
}