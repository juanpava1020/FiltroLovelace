package com.riwi.FiltroLovelace.infraestructure.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.multiclassR.domain.entities.ClassEntity;
import com.riwi.FiltroLovelace.api.dtos.request.ClassRequest;
import com.riwi.FiltroLovelace.api.dtos.response.ClassResponse;
import com.riwi.FiltroLovelace.domain.repositories.ClassRepository;
import com.riwi.FiltroLovelace.infraestructure.abstract_service.IClassService;
import com.riwi.FiltroLovelace.infraestructure.helpers.mappers.ClassMapper;

@Service
public class classService implements IClassService {
   @Autowired
   private ClassRepository classRepository;
   @Autowired
   private ClassMapper classMapper;
  @Override
  public Page<ClassResponse> findAll(String nombre, String descripcion, Pageable pageable) {
    if (nombre != null && descripcion != null) {
      return classRepository.findByNameContainingAndDescriptionContainingAndActiveTrue(nombre, descripcion, pageable).map(this.classMapper::toResponse);
    } else {
      return classRepository.findAllByActiveTrue(pageable).map(this.classMapper::toResponse);
    }
  }
  @Override
  public Optional<ClassResponse> findById(Long id, Pageable pageable) {

    return this.classRepository.findByIdAndActiveTrue(id).map(this.classMapper::toResponse);
  }
  @Override
  public ClassResponse create(ClassRequest request) {
    ClassEntity classId = this.classMapper.toEntity(request);
    return this.classMapper.toResponse(this.classRepository.save(classId));
  }

}