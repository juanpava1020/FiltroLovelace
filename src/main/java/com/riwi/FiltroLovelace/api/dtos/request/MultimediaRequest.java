package com.riwi.FiltroLovelace.api.dtos.request;


import com.riwi.FiltroLovelace.utils.enums.Estado;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaRequest {

  @NotNull(message = "El tipo de multimedia no puede ser nulo")
  @Pattern(regexp = "VIDEO|AUDIO|DOCUMENT", message = "The type must be one of the following: VIDEO, AUDIO, DOCUMENT")
  private Estado type;

  @NotBlank(message = "El url de la multimedia no puede estar vacío")
  private String url;

  @NotNull(message = "La actividad de la multimedia no puede ser nula")
  private Boolean active;   

  @NotNull(message = "El id de la actividad no puede ser nulo")
  private Long lessonId;
}