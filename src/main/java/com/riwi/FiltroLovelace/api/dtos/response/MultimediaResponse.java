package com.riwi.FiltroLovelace.api.dtos.response;


import java.time.LocalDateTime;


import com.riwi.FiltroLovelace.utils.enums.Estado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor 
public class MultimediaResponse {
  private Long id;
  private Estado type;
  private String url;
    private LocalDateTime createdAt;

  private Boolean active;
}