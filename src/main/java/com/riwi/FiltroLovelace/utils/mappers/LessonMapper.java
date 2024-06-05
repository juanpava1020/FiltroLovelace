package com.riwi.FiltroLovelace.utils.mappers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi.FiltroLovelace.api.dtos.request.LessonRequest;
import com.riwi.FiltroLovelace.api.dtos.response.LessonResponse;
import com.riwi.FiltroLovelace.domain.entities.ClassEntity;
import com.riwi.FiltroLovelace.domain.entities.LessonEntity;
import com.riwi.FiltroLovelace.domain.repositories.ClassRepository;
import com.riwi.FiltroLovelace.utils.exceptions.IdNotFoundException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LessonMapper {
  @Autowired 
  private final ClassRepository classRepository;
  public LessonResponse toResponse(LessonEntity entity) {
    return LessonResponse.builder()
        .id(entity.getId())
        .title(entity.getTitle())
        .content(entity.getContent())
        .createdAt(entity.getCreatedAt())
        .active(entity.isActive())
        .build();
  }

  public LessonEntity toEntity(LessonRequest request) {
    ClassEntity classId = classRepository.findById(request.getClassId()).orElseThrow(() -> new IdNotFoundException("Class not found", request.getClassId()));

    return LessonEntity.builder()
        .title(request.getTitle())
        .content(request.getContent())
        .createdAt(LocalDateTime.now())
        .active(request.getActive())
        .classId(classId)
        .build();
  }
}
