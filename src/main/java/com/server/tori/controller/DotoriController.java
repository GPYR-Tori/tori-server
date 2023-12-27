package com.server.tori.controller;

import com.server.tori.dto.Dotori.MyDotoriGetResponseDto;
import com.server.tori.dto.Dotori.DotoriPostRequestDto;
import com.server.tori.dto.Dotori.DotoriLocationGetResponseDto;
import com.server.tori.service.DotoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DotoriController {

    @Autowired
    private DotoriService dotoriService;

    // 사용자의 가까이에 있는 여행지 찾기 (클라이언트에게 사용자 위치 받아오기)
    @GetMapping("/dotori")
    public List<DotoriLocationGetResponseDto> getLandmarkByUser (@RequestParam(name = "userId", required = false) Long userId,
                                                                 @RequestParam(name = "latitude") double latitude,
                                                                 @RequestParam(name = "longitude") double longitude){
        return dotoriService.getLandmarkByUser(userId, latitude, longitude);
    }

    // 도토리 모으기 (여행지 전달)
    @PostMapping("/dotori")
    public String createDotori (@RequestBody DotoriPostRequestDto dotoriPostRequestDto) {
        return dotoriService.createDotori(dotoriPostRequestDto);
    }

    @GetMapping("/users/{userId}/mydotori")
    public MyDotoriGetResponseDto getDotoriInfo (@PathVariable(name = "userId") Long userId) {
        return dotoriService.getDotoriInfo(userId);
    }
}
