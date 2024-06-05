package com.riwi.FiltroLovelace.api.dtos.request;


import jakarta.validation.constraints.Email;


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
public class StudentRequest {
  @NotBlank(message = "El nombre del estudiante no puede estar vacío")
  @Size(min = 1, max = 100, message = "El nombre del estudiante debe tener entre 1 y 100 caracteres")
  private String name;

  @Email
  private String email;

  @NotNull(message = "El estado del estudiante no puede ser nula")
  private Boolean active;

  @NotNull(message = "El id de la clase no puede ser nulo")
  private Long classId;
}