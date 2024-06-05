package com.riwi.FiltroLovelace.infraestructure.abstract_service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.riwi.FiltroLovelace.api.dtos.request.ClassRequest;
import com.riwi.FiltroLovelace.api.dtos.response.ClassResponse;



public interface IClassService {
  public Page<ClassResponse> findAll(String nombre, String descripcion, Pageable pageable);
  public Optional<ClassResponse> findById(Long id, Pageable pageable);
  public ClassResponse create(ClassRequest request);
}