package com.riwi.FiltroLovelace.utils.mappers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi.FiltroLovelace.api.dtos.request.MultimediaRequest;
import com.riwi.FiltroLovelace.api.dtos.response.MultimediaResponse;
import com.riwi.FiltroLovelace.domain.entities.LessonEntity;
import com.riwi.FiltroLovelace.domain.entities.MultimediaEntity;
import com.riwi.FiltroLovelace.domain.repositories.LessonRepository;
import com.riwi.FiltroLovelace.utils.exceptions.IdNotFoundException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MultimediaMapper {
  @Autowired
  private final LessonRepository lessonRepository;
  public MultimediaResponse toResponse(MultimediaEntity entity) {
    return MultimediaResponse.builder()
        .id(entity.getId())
        .url(entity.getUrl())
        .type(entity.getType())
        .createdAt(entity.getCreatedAt())
        .active(entity.getActive())
        .build();
  }


  public MultimediaEntity toEntity(MultimediaRequest request) {
    LessonEntity lessonId = lessonRepository.findById(request.getLessonId()).orElseThrow(() -> new IdNotFoundException("Lesson not found", request.getLessonId()));
    return MultimediaEntity.builder()
        .url(request.getUrl())
        .type(request.getType())
        .createdAt(LocalDateTime.now())
        .active(request.getActive())
        .lessonId(lessonId)
        .build();
  }
}
