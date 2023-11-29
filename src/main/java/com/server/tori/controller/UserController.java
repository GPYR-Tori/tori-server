package com.server.tori.controller;

import com.server.tori.dto.User.MyPageEditResponseDto;
import com.server.tori.dto.User.MyPageEditViewResponseDto;
import com.server.tori.dto.User.MyPageResponseDto;
import com.server.tori.dto.User.MyPageEditRequestDto;
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
  @GetMapping("/users/{user_id}")
// 1. userService.getUser(long userId)
//   서비스에서 repository.findById(userId)로 조회한 후 user엔티티 dto로 만들어서 리턴
  public ResponseEntity<MyPageResponseDto> myPage(@PathVariable Long user_id) {
    MyPageResponseDto myPageDto = userService.myPage(user_id);
    return ResponseEntity.status(HttpStatus.OK).body(myPageDto);
  }

  // 회원정보 수정
  @PatchMapping("/users/{user_id}/edit")
// 2. 위와 동일하게 user 엔티티 조회해와서 user.set필드(변경할 값) 넣어서 변경한 후 repository.save(user)하고 결과값 dto로 리턴
  public ResponseEntity<MyPageEditResponseDto> myPageEdit(@PathVariable Long user_id, @RequestBody MyPageEditRequestDto mypageEditRequestDto) {
    MyPageEditResponseDto myPageEditDto = userService.myPageEdit(user_id, mypageEditRequestDto);
    return ResponseEntity.status(HttpStatus.OK).body(myPageEditDto);
  }

  // 마이페이지의 수정 페이지 이동
  @GetMapping("/users/{user_id}/edit")
// 3. 유저 단일 조회와 동일하게 유저 조회해와서 필요한 응답값 user.getXXX로 가져와서 dto로 생성
  public ResponseEntity<MyPageEditViewResponseDto> myPageEditView(@PathVariable Long user_id) {
    MyPageEditViewResponseDto myPageEditView= userService.myPageEditView(user_id);
    return ResponseEntity.status(HttpStatus.OK).body(myPageEditView);
  }


}
