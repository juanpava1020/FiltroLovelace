package com.riwi.FiltroLovelace.infraestructure.helpers.mappers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;




import com.riwi.FiltroLovelace.api.dtos.request.ClassRequest;
import com.riwi.FiltroLovelace.api.dtos.response.ClassResponse;
import com.riwi.FiltroLovelace.domain.entities.ClassEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClassMapper {

  public ClassResponse toResponse(ClassEntity classEntity) {
  return ClassResponse.builder()
      .id(classEntity.getId())
      .name(classEntity.getName())
      .description(classEntity.getDescription())
      .createdAt(classEntity.getCreatedAt())
      .active(classEntity.isActive())
      .build();
  }

  public ClassEntity toEntity(ClassRequest request) {
    return ClassEntity.builder()
        .name(request.getName())
        .description(request.getDescription())
        .createdAt(LocalDateTime.now())
        .active(request.getActive())
        .build();
  }
}