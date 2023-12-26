package com.server.tori.dto.Dotori;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class MyDotoriRecordGetDto {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createDate;
}
