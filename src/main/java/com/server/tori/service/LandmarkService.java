package com.server.tori.service;

import com.server.tori.dto.LandmarkDetailResponseDto;
import com.server.tori.dto.LandmarkResponseDto;
import com.server.tori.entity.Landmark;
import com.server.tori.repository.LandmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LandmarkService {

    @Autowired
    private LandmarkRepository landmarkRepository;

    public List<LandmarkResponseDto> getLandmarkAll() {
        List<Landmark> landmarkList = landmarkRepository.findAll();
        return getLandmarkResponseDtoList(landmarkList);
    }

    public LandmarkDetailResponseDto getLandmarkById(Long id) {
        Optional<Landmark> landmarkOptional = landmarkRepository.findById(id);
        if (landmarkOptional.isPresent()) {
            Landmark landmark = landmarkOptional.get();
            return getLandmarkDetailResponseDto(landmark);
        } else {
            return null;
        }
    }

    public List<LandmarkResponseDto> getLandmarkByCategory(String category) {
        List<Landmark> landmarkList = landmarkRepository.findByCategory(category);
        return getLandmarkResponseDtoList(landmarkList);
    }

    public List<LandmarkResponseDto> getLandmarkByLocation(String location) {
        List<Landmark> landmarkList = landmarkRepository.findByLocation(location);
        return getLandmarkResponseDtoList(landmarkList);
    }

    public List<LandmarkResponseDto> getLandmarkByCategoryAndLocation(String category, String location) {
        List<Landmark> landmarkList = landmarkRepository.findByCategoryAndLocation(category, location);
        return getLandmarkResponseDtoList(landmarkList);
    }

    // Dto 변환
    public List<LandmarkResponseDto> getLandmarkResponseDtoList(List<Landmark> landmarkList) {
        List<LandmarkResponseDto> dtos = new ArrayList<>();

        for (Landmark landmark : landmarkList) {
            LandmarkResponseDto dto = new LandmarkResponseDto(
                    landmark.getId(),
                    landmark.getName(),
                    new ArrayList<>(landmark.getCategory()),
                    new ArrayList<>(landmark.getLocation()),
                    new ArrayList<>(landmark.getImage())
            );

            dtos.add(dto);
        }
        return dtos;
    }

    public LandmarkDetailResponseDto getLandmarkDetailResponseDto(Landmark landmark) {
        LandmarkDetailResponseDto dto = new LandmarkDetailResponseDto(
                landmark.getId(),
                landmark.getName(),
                landmark.getAddress(),
                landmark.getDescription(),
                landmark.getPrice(),
                landmark.getPrice(),
                landmark.getTime(),
                new ArrayList<>(landmark.getCategory()),
                new ArrayList<>(landmark.getLocation()),
                new ArrayList<>(landmark.getImage())
        );

        return dto;
    }
}
