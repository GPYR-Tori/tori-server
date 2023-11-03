package com.server.tori.service;

import com.server.tori.dto.*;
import com.server.tori.entity.User;
import com.server.tori.repository.UserRepository;
import org.apache.tomcat.util.buf.UEncoder;
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
    return new JoinResponseDto(saved.getId(), saved.getEmail(), saved.getPassword(), saved.getBirthdate(), saved.getGender(), saved.getNation(), saved.getLanguage(), saved.getNickname()); // 전부 리털할 필요가있나?
  }

  public MyPageResponseDto myPage(Long uesr_id) {
    User userPage = userRepository.findById(uesr_id).orElseThrow();
    return new MyPageResponseDto(userPage.getNickname());
  }

  public MyPageEditResponseDto myPageEdit(Long user_id, MyPageEditRequestDto myPageEditRequestDto) {
    //1. 유저조회
    User user = userRepository.findById(user_id).orElseThrow(null);
    //2. 해당 유저 엔티티에 requestdto로 받은 값을 set해서 수정
    user.patch(myPageEditRequestDto);
    //3. 그 엔티티 저장
    User updated = userRepository.save(user);
    return new MyPageEditResponseDto(updated.getId(), updated.getEmail(), updated.getPassword(), updated.getBirthdate(), updated.getGender(), updated.getNation(), updated.getLanguage(), updated.getNickname());
  }

  public MyPageEditViewResponseDto myPageEditView (Long id){
    User saved = userRepository.findById(id).orElseThrow();
    return new MyPageEditViewResponseDto(saved.getId(), saved.getEmail(), saved.getPassword(), saved.getBirthdate(), saved.getGender(), saved.getNation(), saved.getLanguage(), saved.getNickname());
  }




}