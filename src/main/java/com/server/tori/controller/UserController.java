package com.server.tori.controller;

import com.server.tori.dto.User.*;
import com.server.tori.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  // 마이페이지
  @GetMapping("/users/{userId}")
// 1. userService.getUser(long userId)
//   서비스에서 repository.findById(userId)로 조회한 후 user엔티티 dto로 만들어서 리턴
  public ResponseEntity<MyPageResponseDto> myPage(@PathVariable Long userId) {
    MyPageResponseDto myPageDto = userService.myPage(userId);
    return ResponseEntity.status(HttpStatus.OK).body(myPageDto);
  }

  // 마이페이지(프로필수정)
  @GetMapping("/users/{userId}/edit")
  public ResponseEntity<MyPageProfileResponseDto> myPageEditView(@PathVariable Long userId) {
    MyPageProfileResponseDto myPageEditView = userService.myPageProfile(userId);
    return ResponseEntity.status(HttpStatus.OK).body(myPageEditView);
  }

  // 회원정보 수정
  @PatchMapping("/users/{userId}/edit")
  // 2. 위와 동일하게 user 엔티티 조회해와서 user.set필드(변경할 값) 넣어서 변경한 후 repository.save(user)하고 결과값 dto로 리턴
  public ResponseEntity<MyPageEditResponseDto> myPageEdit(@PathVariable Long userId, @RequestBody MyPageEditRequestDto mypageEditRequestDto) {
    MyPageEditResponseDto myPageEditDto = userService.myPageEdit(userId, mypageEditRequestDto);
    return ResponseEntity.status(HttpStatus.OK).body(myPageEditDto);
  }

  // 회원 탈퇴
  @PostMapping("/users/{userId}/edit")
  public ResponseEntity<String> userOut(@PathVariable Long userId) {
    userService.userOut(userId);
    return ResponseEntity.status(HttpStatus.OK).body("회원탈퇴가 성공적으로 처리되었습니다.");
  }

}
