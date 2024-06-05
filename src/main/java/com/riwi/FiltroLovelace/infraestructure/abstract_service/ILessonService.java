package com.riwi.FiltroLovelace.infraestructure.abstract_service;

import com.riwi.FiltroLovelace.api.dtos.request.LessonRequest;
import com.riwi.FiltroLovelace.api.dtos.response.LessonResponse;

public interface ILessonService {
  public LessonResponse saveLesson(LessonRequest request) ;

  public LessonResponse disableLesson(Long id);
  public LessonResponse findById(Long id);

}
