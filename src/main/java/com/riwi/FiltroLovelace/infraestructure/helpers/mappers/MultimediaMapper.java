package com.riwi.FiltroLovelace.infraestructure.helpers.mappers;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi.FiltroLovelace.api.dtos.request.MultimediaRequest;
import com.riwi.FiltroLovelace.api.dtos.response.MultimediaResponse;
import com.riwi.FiltroLovelace.domain.entities.MultimediaEntity;


import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class MultimediaMapper {
  
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
    
    return MultimediaEntity.builder()
        .url(request.getUrl())
        .type(request.getType())
        .createdAt(LocalDateTime.now())
        .active(request.getActive())
        .build();
  }
}