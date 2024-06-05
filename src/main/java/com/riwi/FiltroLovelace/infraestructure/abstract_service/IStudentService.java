package com.riwi.FiltroLovelace.infraestructure.abstract_service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.riwi.FiltroLovelace.api.dtos.request.StudentRequest;
import com.riwi.FiltroLovelace.api.dtos.response.StudentResponse;



public interface IStudentService {
  public Page<StudentResponse> findByNameOrDescription(String name, String description, Pageable pageable);
  public StudentResponse findById(Long id);
  public StudentResponse create(StudentRequest student); 
  public StudentResponse disableStudent (Long id);
  public StudentResponse update(StudentRequest student, Long id);
}