package com.riwi.FiltroLovelace.api.dtos.response;


import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonResponse {
  private Long id;
  private String title;
  private String content;
  private LocalDateTime createdAt;
  private Boolean active;
  private List<MultimediaResponse> multimedias;
}