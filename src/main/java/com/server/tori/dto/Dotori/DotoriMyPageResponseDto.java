package com.server.tori.dto.Dotori;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.server.tori.entity.Dotori;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class DotoriMyPageResponseDto {
    private Integer total;
    private Integer num;

    public DotoriMyPageResponseDto(int total, int num) {
        this.total = total;
        this.num = num;
    }
}
