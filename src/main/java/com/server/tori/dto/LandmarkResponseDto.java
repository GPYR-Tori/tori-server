package com.server.tori.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class LandmarkResponseDto {
    private Long id;
    private String name;
    private List<String> category = new ArrayList<>();
    private List<String> location = new ArrayList<>();
    private List<String> image = new ArrayList<>();
}
