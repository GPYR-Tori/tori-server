package com.server.tori.service;

import com.server.tori.dto.User.*;
import com.server.tori.entity.User;
import com.server.tori.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public JoinResponseDto join(JoinRequestDto joinRequestDto) {
    User user = joinRequestDto.toEntity();
    User saved = userRepository.save(user);
    return new JoinResponseDto(saved);
  }

  public MyPageResponseDto myPage(Long uesrId) {
    User userPage = userRepository.findById(uesrId).orElseThrow();
    return new MyPageResponseDto(userPage.getNickname());
  }

  public MyPageEditResponseDto myPageEdit(Long userId, MyPageEditRequestDto myPageEditRequestDto) {
    //1. 유저조회
    User user = userRepository.findById(userId).orElseThrow(null);
    //2. 해당 유저 엔티티에 requestdto로 받은 값을 set해서 수정(조건 사항이 안맞으면 예외 발생)
    if (myPageEditRequestDto.getPassword() != null && myPageEditRequestDto.getPassword().length() < 8) {
      throw new IllegalArgumentException("Password should have at least 8 characters");
    }
    String newNickname = myPageEditRequestDto.getNickname();
    if (newNickname != null && userRepository.existsByNicknameAndIdNot(newNickname, userId)) {
      throw new IllegalArgumentException("Nickname is already in use by another user");
    }
    user.patch(myPageEditRequestDto);
    //3. 그 엔티티 저장
    User updated = userRepository.save(user);
    return new MyPageEditResponseDto(updated.getId(), updated.getEmail(), updated.getPassword(), updated.getGender(), updated.getNation(), updated.getLanguage(), updated.getNickname());
  }

  // 탈퇴회원 닉네임, 이메일 변경
  public void userOut(Long userId) {
    User user = userRepository.findById(userId).orElseThrow(null);
    user.setNickname("former member");
    user.setEmail("former member");
    userRepository.save(user);
  }

  // 마이페이지(프로필수정) 해당 user 정보 가져오기
  public MyPageProfileResponseDto myPageProfile(Long id){
    User saved = userRepository.findById(id).orElseThrow(null );
    return new MyPageProfileResponseDto(saved.getId(), saved.getEmail(), saved.getPassword(), saved.getGender(), saved.getNation(), saved.getLanguage(), saved.getNickname());
  }

  // 마이페이지(프로필수정) 닉네임 중복확인
  public CheckNicknameResponseDto checkNickname(Long userId, CheckNicknameRequestDto checkNicknameRequestDto) {
    String nicknameToCheck = checkNicknameRequestDto.getNickname();
    Optional<User> existingUser = userRepository.findByNickname(nicknameToCheck);
    if (existingUser.isPresent() && !existingUser.get().getId().equals(userId)) {
      throw new RuntimeException("Nickname is already taken");
    }
    return new CheckNicknameResponseDto(nicknameToCheck);
  }

}