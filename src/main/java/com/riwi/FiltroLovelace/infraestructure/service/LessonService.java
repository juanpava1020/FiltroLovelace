package com.riwi.FiltroLovelace.infraestructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.FiltroLovelace.api.dtos.request.LessonRequest;
import com.riwi.FiltroLovelace.api.dtos.response.LessonResponse;
import com.riwi.FiltroLovelace.domain.entities.LessonEntity;
import com.riwi.FiltroLovelace.domain.repositories.LessonRepository;
import com.riwi.FiltroLovelace.infraestructure.abstract_service.ILessonService;
import com.riwi.FiltroLovelace.utils.exceptions.IdNotFoundException;

@Service
public class LessonService implements ILessonService {
  @Autowired
  private LessonRepository lessonRepository;
  @Autowired
  private MultimediaService multimediaService;
  @Autowired
  private com.riwi.FiltroLovelace.infraestructure.helpers.mappers.LessonMapper lessonMapper;


  @Override
  public com.riwi.FiltroLovelace.api.dtos.response.LessonResponse saveLesson(LessonRequest request) {
    LessonEntity lesson = lessonMapper.toEntity(request);
    this.multimediaService.createMultimediaFromLesson(lesson.getId(), request.getMultimedias());
    return lessonMapper.toResponse(lessonRepository.save(lesson));
  }


  @Override
  public LessonResponse disableLesson(Long id) {
    LessonEntity lesson = this.find(id);
    lesson.setActive(false);
    lesson.setId(id);
    return lessonMapper.toResponse(lessonRepository.save(lesson));
  }

  @Override
  public LessonResponse findById(Long id) {
    return lessonMapper.toResponse(this.find(id));
  }

  private LessonEntity find(Long id) {
    return lessonRepository.findById(id).orElseThrow(() -> new IdNotFoundException("id not found", id));
  }
}
