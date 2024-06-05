package com.riwi.FiltroLovelace.api.dtos.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

  private Long id;
  private String name;
  private String email;
  private LocalDateTime createdAt;
  private Boolean active;
  
}