package com.server.tori.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class LandmarkDetailResponseDto {
    private Long id;
    private String name;
    private String address;
    private String description;
    private String price;
    private String time;
    private String site;
    private List<String> category = new ArrayList<>();
    private List<String> location = new ArrayList<>();
    private List<String> image = new ArrayList<>();
}
