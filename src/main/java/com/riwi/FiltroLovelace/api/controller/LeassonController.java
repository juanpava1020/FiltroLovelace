package com.riwi.FiltroLovelace.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.FiltroLovelace.api.dtos.request.LessonRequest;
import com.riwi.FiltroLovelace.api.dtos.response.LessonResponse;
import com.riwi.FiltroLovelace.infraestructure.abstract_service.ILessonService;




@RestController
@RequestMapping("/lesson")
public class LeassonController {
  @Autowired
  private ILessonService lessonService;

  @PostMapping
  public ResponseEntity<LessonResponse> createLesson(@Validated @RequestBody LessonRequest request) { 

    return ResponseEntity.ok(lessonService.saveLesson(request));
  }

  @PatchMapping("/{id}/disable")
  public ResponseEntity<LessonResponse> disableLesson(@PathVariable Long id) {
    return ResponseEntity.ok(lessonService.disableLesson(id));
  }

  @GetMapping("/{id}")
  public ResponseEntity<LessonResponse> getLesson(@PathVariable Long id) {
    return ResponseEntity.ok(lessonService.findById(id));
  }
}
