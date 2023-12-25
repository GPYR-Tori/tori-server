package com.server.tori.controller;

import com.server.tori.dto.Landmark.LandmarkDetailGetResponseDto;
import com.server.tori.dto.Landmark.LandmarkGetResponseDto;
import com.server.tori.service.LandmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/landmarks")
@RestController
public class LandmarkController {

    @Autowired
    private LandmarkService landmarkService;

    // 상세 여행지 조회
    @GetMapping("/{id}")
    public ResponseEntity<LandmarkDetailGetResponseDto> getLandmarkDetail(@PathVariable("id") Long id, @RequestParam(name = "userId", required = false) Long userId) {
        return ResponseEntity.ok().body(landmarkService.getLandmarkDetail(id, userId));
    }

    // 전체 조회 (홈 화면), 지역 + 카테고리 필터링 후 조회 (QueryDsl 사용)
    @GetMapping
    public ResponseEntity<List<LandmarkGetResponseDto>> getLandmarkByCategory(@RequestParam(name = "userId", required = false) Long userId,
                                                           @RequestParam(name = "category", required = false) String category,
                                                           @RequestParam(name = "location", required = false) String location) {

        return ResponseEntity.ok().body(landmarkService.getLandmarkByCategory(userId, category, location));
    }
}