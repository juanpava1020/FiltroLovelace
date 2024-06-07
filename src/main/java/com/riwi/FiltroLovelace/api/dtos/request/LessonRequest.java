package com.riwi.FiltroLovelace.api.dtos.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest {

  @NotBlank(message = "El titulo del curso no puede estar vacío")
  @Size(min = 1, max = 100, message = "El titulo del curso debe tener entre 1 y 100 caracteres")
  private String title;

  @NotBlank(message = "El contenido del curso no puede estar vacío")
  private String content;

  @NotNull(message = "El estado de la clase no puede ser nula")
  private Boolean active;
  
  @NotNull(message = "El id de la clase no puede estar vacío")
  private Long classId;

  private List<MultimediaRequest> multimedias;
}