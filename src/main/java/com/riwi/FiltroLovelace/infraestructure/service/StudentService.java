package com.riwi.FiltroLovelace.infraestructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.FiltroLovelace.api.dtos.request.StudentRequest;
import com.riwi.FiltroLovelace.api.dtos.response.StudentResponse;
import com.riwi.FiltroLovelace.domain.entities.StudentEntity;
import com.riwi.FiltroLovelace.domain.repositories.StudentRepository;
import com.riwi.FiltroLovelace.infraestructure.abstract_service.IStudentService;
import com.riwi.FiltroLovelace.infraestructure.helpers.mappers.StudentMapper;
import com.riwi.FiltroLovelace.utils.exceptions.IdNotFoundException;


@Service
public class StudentService implements IStudentService {
@Autowired
private StudentRepository studentRepository;
@Autowired
private StudentMapper studentMapper;
  @Override
  public StudentResponse create(StudentRequest request) {
    StudentEntity student =  this.studentMapper.toEntity(request);

    return this.studentMapper.toResponse(this.studentRepository.save(student));

  }

  @Override
  public StudentResponse disableStudent(Long id) {
    StudentEntity student = this.find(id);
    student.setActive(false);
    student.setId(id);
    return this.studentMapper.toResponse(this.studentRepository.save(student));
  }

  @Override
  public StudentResponse findById(Long id) {

    return this.studentMapper.toResponse(this.find(id));
  }

  @Override
  public Page<StudentResponse> findByName(String name, Pageable pageable) {

    return this.studentRepository.findByNameContainingAndActiveTrue(name, pageable).map(student -> this.studentMapper.toResponse(student));
  }

  @Override
  public StudentResponse update(StudentRequest request, Long id) {
    StudentEntity student = this.find(id);
    student = this.studentMapper.toEntity(request);
    student.setId(id);
    return this.studentMapper.toResponse(this.studentRepository.save(student));
  }

  private StudentEntity find(Long id) {

   return this.studentRepository.findById(id).orElseThrow(() -> new IdNotFoundException("id not found", id)) ;
  }

}
