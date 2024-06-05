package com.riwi.FiltroLovelace.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





import com.riwi.FiltroLovelace.api.dtos.request.StudentRequest;
import com.riwi.FiltroLovelace.api.dtos.response.StudentResponse;
import com.riwi.FiltroLovelace.infraestructure.abstract_service.IStudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
  @Autowired
  private final IStudentService studentService;

  @PostMapping
  public StudentResponse createStudent(StudentRequest request) {
    return studentService.create(request);
  }

  @GetMapping
    public Page<StudentResponse> getStudents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page , size);
        return studentService.findByNameOrDescription(name, description, pageable);
    }

    @PatchMapping("/{id}/disable")
    public StudentResponse updateStudent(@PathVariable Long id) {
        return studentService.disableStudent(id);
    }

    @PutMapping("/{id}")
    public StudentResponse updateStudent(@PathVariable Long id, StudentRequest request) {
        return studentService.update(request, id);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudent(@PathVariable Long id) {
        return studentService.findById(id);
    }
}