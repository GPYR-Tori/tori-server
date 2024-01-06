package com.server.tori.service;

import com.server.tori.dto.User.*;
import com.server.tori.entity.User;
import com.server.tori.exception.CustomException;
import com.server.tori.exception.ErrorCode;
import com.server.tori.exception.ErrorResponse;
import com.server.tori.repository.UserRepository;
import jakarta.transaction.Transactional;
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

  @Transactional
  public MyPageEditResponseDto myPageEdit(Long userId, MyPageEditRequestDto myPageEditRequestDto) {
    //1. 유저조회
    User user = userRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));
    //2. 해당 유저 엔티티에 requestdto로 받은 값을 set해서 수정(조건 사항이 안 맞으면 예외 발생)
    user.patch(myPageEditRequestDto);
    //3. 그 엔티티 저장
    return new MyPageEditResponseDto(user.getId(), user.getEmail(), user.getPassword(), user.getGender(), user.getNation(), user.getLanguage(), user.getNickname());
  }

  // 탈퇴회원 닉네임, 이메일 변경
  public void userOut(Long userId) {
    User user = userRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));
    user.setNickname("former member");
    user.setEmail("former member");
    userRepository.save(user);
  }

  // 마이페이지(프로필수정) 해당 user 정보 가져오기
  public MyPageProfileResponseDto myPageProfile(Long id){
    User saved = userRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));
    return new MyPageProfileResponseDto(saved.getId(), saved.getEmail(), saved.getPassword(), saved.getGender(), saved.getNation(), saved.getLanguage(), saved.getNickname());
  }

  // 마이페이지(프로필수정) 닉네임 중복확인
  public CheckNicknameResponseDto checkNickname(Long userId, CheckNicknameRequestDto checkNicknameRequestDto) {
    String nicknameToCheck = checkNicknameRequestDto.getNickname();
    // 해당 유저를 찾는다. 해당 유저의 닉네임을 찾는다 만약 같으면 넘어간다.
    User user = userRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));
    if (user.getNickname().equals(checkNicknameRequestDto.getNickname()))
      return new CheckNicknameResponseDto(nicknameToCheck);
    // 유저 레파토리에서 중복확인하려는 닉네임을 검색해본다. 닉네임이 없으면 통과 있으면 예외처리
    Optional<User> userOptional = userRepository.findByNickname(nicknameToCheck);
    // 닉네임이 존재할 경우 예외 발생
    if (userOptional.isPresent()) {
      throw new CustomException(ErrorCode.DUPLICATE_NICKNAME);
    }
    // 닉네임이 존재하지 않을 경우 바로 return
    return new CheckNicknameResponseDto(nicknameToCheck);
  }

}