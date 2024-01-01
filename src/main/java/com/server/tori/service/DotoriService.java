package com.server.tori.service;

import com.server.tori.dto.Dotori.MyDotoriGetResponseDto;
import com.server.tori.dto.Dotori.DotoriPostRequestDto;
import com.server.tori.dto.Dotori.DotoriLocationGetResponseDto;
import com.server.tori.entity.Dotori;
import com.server.tori.entity.Landmark.Landmark;
import com.server.tori.entity.Landmark.Translation;
import com.server.tori.entity.User;
import com.server.tori.exception.CustomException;
import com.server.tori.exception.ErrorCode;
import com.server.tori.repository.DotoriRepository;
import com.server.tori.repository.LandmarkRepository;
import com.server.tori.repository.TranslationRepository;
import com.server.tori.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DotoriService {

    @Autowired
    private DotoriRepository dotoriRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LandmarkRepository landmarkRepository;

    @Autowired
    private TranslationRepository translationRepository;

    // 언어 기본값 설정 (상수)
    private static final String DEFAULT_LANGUAGE = "영어";
    private String userLanguage = DEFAULT_LANGUAGE;

    public List<DotoriLocationGetResponseDto> getLandmarkByUser(Long userId, double latitude, double longitude) {

        if (userId != null) {
            userRepository.findById(userId)
                    .ifPresent(user -> userLanguage = user.getLanguage());
        }

        List<Landmark> landmarksList = landmarkRepository.findLandmarkByDistance(latitude, longitude);

        return landmarksList.stream()
                .map(landmark -> {
                    Translation translation = translationRepository.findByLandmarkIdAndLanguage(landmark.getId(), userLanguage)
                            .orElse(new Translation());
                    return new DotoriLocationGetResponseDto(landmark, translation);
                })
                .collect(Collectors.toList());
    }

    public String createDotori(DotoriPostRequestDto dotoriPostRequestDto) {

        User user = getUserById(dotoriPostRequestDto.getUserId());

        Landmark landmark = landmarkRepository.findById(dotoriPostRequestDto.getLandmarkId())
                .orElseThrow(() -> new CustomException(ErrorCode.LANDMARK_NOT_FOUND));

        Dotori dotori = new Dotori(user, LocalDateTime.now());
        dotoriRepository.save(dotori);

        // 해준 추가, 조회를 목적을 둔 양방향 맵핑
        user.insertDotori(dotori);

        return "도토리가 성공적으로 적립되었습니다.";

    }

    public MyDotoriGetResponseDto getDotoriInfo(Long userId) {

        User user = getUserById(userId);

        int total = dotoriRepository.countByUser(user);
        int num = total % 10;

        return new MyDotoriGetResponseDto(total, num);
        // todo: 도토리 랭킹, 도토리 내역 (10개) 추가

    }

    private User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));
    }
}
