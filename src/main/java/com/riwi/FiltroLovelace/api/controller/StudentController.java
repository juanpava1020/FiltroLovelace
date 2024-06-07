package com.riwi.FiltroLovelace.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public ResponseEntity<StudentResponse> createStudent(@Validated @RequestBody StudentRequest request) {
    return ResponseEntity.ok(studentService.create(request));}

  @GetMapping
  public ResponseEntity<Page<StudentResponse>> getStudents(
            @RequestParam(defaultValue = "string") String name,
            @RequestParam(defaultValue = "string") String description,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page , size);
        return ResponseEntity.ok(studentService.findByName(name,  pageable));
    }

    @PatchMapping("/{id}/disable")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.disableStudent(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable Long id,@Validated @RequestBody StudentRequest request) {
        return ResponseEntity.ok(studentService.update(request, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));

    }
}