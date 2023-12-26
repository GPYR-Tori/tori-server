package com.server.tori.dto.Dotori;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MyDotoriGetResponseDto {
    private Integer total;
    private Integer num;
    private List<DotoriRankingGetDto> dotoriRankingList;
    private List<MyDotoriRecordGetDto> myDotoriRecordList;

    public MyDotoriGetResponseDto(int total, int num) {
        this.total = total;
        this.num = num;
    }
}
