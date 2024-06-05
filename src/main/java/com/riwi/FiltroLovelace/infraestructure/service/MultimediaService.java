package com.riwi.FiltroLovelace.infraestructure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.FiltroLovelace.api.dtos.request.MultimediaRequest;
import com.riwi.FiltroLovelace.domain.entities.MultimediaEntity;
import com.riwi.FiltroLovelace.domain.repositories.LessonRepository;
import com.riwi.FiltroLovelace.domain.repositories.MultimediaRepository;
import com.riwi.FiltroLovelace.infraestructure.abstract_service.IMultimediaService;
import com.riwi.FiltroLovelace.infraestructure.helpers.mappers.MultimediaMapper;
import com.riwi.FiltroLovelace.utils.exceptions.IdNotFoundException;




@Service
public class MultimediaService implements IMultimediaService {
  @Autowired
  private MultimediaRepository multimediaRepository;
  @Autowired
  private MultimediaMapper multimediaMapper;

  @Autowired
  private LessonRepository lessonRepository;

@Override
  public void createMultimediaFromLesson(Long lessonId, List<MultimediaRequest> requests) {
    for (MultimediaRequest request : requests) {
      MultimediaEntity multimedia = multimediaMapper.toEntity(request);
      

      multimedia.setLessonId(
          lessonRepository.findById(lessonId).orElseThrow(() -> new IdNotFoundException("Lesson not found", lessonId)));

      multimediaRepository.save(multimedia);
    }
  }

@Override
 public void updateMultimediaFromLesson(Long lessonId, List<MultimediaRequest> requests) {
    for (MultimediaRequest request : requests) {
      MultimediaEntity multimedia = multimediaMapper.toEntity(request);
      multimedia.setLessonId(
          lessonRepository.findById(lessonId).orElseThrow(() -> new IdNotFoundException("Lesson not found", lessonId)));
      multimediaRepository.save(multimedia);
    }
  }
}