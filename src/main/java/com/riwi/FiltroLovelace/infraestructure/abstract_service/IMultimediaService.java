package com.riwi.FiltroLovelace.infraestructure.abstract_service;

import java.util.List;

import com.riwi.FiltroLovelace.api.dtos.request.MultimediaRequest;



public interface IMultimediaService {
  public void createMultimediaFromLesson(Long lessonId, List<MultimediaRequest> requests);
  public void updateMultimediaFromLesson(Long lessonId, List<MultimediaRequest> requests);
}