package com.server.tori.controller;

import com.server.tori.dto.LandmarkDetailResponseDto;
import com.server.tori.dto.LandmarkResponseDto;
import com.server.tori.service.LandmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/landmarks")
@RestController
public class LandmarkController {

    @Autowired
    private LandmarkService landmarkService;
    
    // 홈 화면 (전체 여행지 조회)
    @GetMapping("/all")
    public List<LandmarkResponseDto> home() {
        return landmarkService.getLandmark();
    }

    // 상세 여행지 조회
    @GetMapping("/{id}")
    public LandmarkDetailResponseDto landmarkDetail(@PathVariable("id") Long id) {
        return landmarkService.getLandmarkById(id);
    }

    // 카테고리 조회
    @GetMapping(params = "category")
    public List<LandmarkResponseDto> landmarkCategory (@RequestParam("category") String category) {
        return landmarkService.findByCategory(category);
    }

    // 지역 조회
    @GetMapping(params = "location")
    public List<LandmarkResponseDto> landmarkLocation (@RequestParam("location") String location) {
        return landmarkService.findByLocation(location);
    }

    // 지역 + 카테고리 조회
    @GetMapping(params = {"category", "location"})
    public List<LandmarkResponseDto> landmarkCategoryAndLocation (Model model, @RequestParam("category") String category,
                                               @RequestParam("location") String location) {
        return landmarkService.findByCategoryAndLocation(category, location);
    }
}
