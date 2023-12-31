package com.server.tori.controller;

import com.server.tori.dto.Guide.GuideResponseDto;
import com.server.tori.entity.User;
import com.server.tori.exception.CustomException;
import com.server.tori.exception.ErrorCode;
import com.server.tori.repository.UserRepository;
import com.server.tori.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuideController {

  @Autowired
  GuideService guideService;
  @Autowired
  UserRepository userRepository;

  @GetMapping("/guide/{userId}")
  public GuideResponseDto guide(@PathVariable Long userId) {
    // 1. 주어진 사용자 ID를 사용하여 사용자 정보를 가져옵니다.
    User user = userRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));

    // 2. 사용자의 언어 설정을 가져옵니다.
    // 2-1.사용자 정보가 없거나 사용자의 언어 설정이 없을 경우, 기본값으로 영어를 설정합니다.
    String userLanguage = (user != null && user.getLanguage() != null) ? user.getLanguage() : "english";

    // 3. 사용자 언어 설정에 따른 가이드 정보를 가져오기 위해 GuideService의 guide 메서드를 호출합니다.
    GuideResponseDto guideResponseDto = guideService.guide(userLanguage);

    // 4. 가이드 정보를 반환합니다.
    return guideResponseDto;
  }
}