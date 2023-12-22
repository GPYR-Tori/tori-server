package com.server.tori.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.server.tori.dto.Landmark.LandmarkDetailGetResponseDto;
import com.server.tori.dto.Landmark.LandmarkGetResponseDto;
import com.server.tori.entity.Landmark.Landmark;
import com.server.tori.entity.Landmark.QLandmark;
import com.server.tori.entity.Landmark.Translation;
import com.server.tori.exception.CustomException;
import com.server.tori.exception.ErrorCode;
import com.server.tori.repository.LandmarkRepository;
import com.server.tori.repository.TranslationRepository;
import com.server.tori.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LandmarkService {

    @Autowired
    private LandmarkRepository landmarkRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TranslationRepository translationRepository;

    // 언어 기본값 설정 (상수)
    private static final String DEFAULT_LANGUAGE = "영어";
    private String userLanguage = DEFAULT_LANGUAGE;

    public LandmarkDetailGetResponseDto getLandmarkDetail(Long id, Long userId) {

        setUserLanguage(userId);

        Landmark landmark = landmarkRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.LANDMARK_NOT_FOUND));

        // 만약 회원 설정 언어에 따른 번역 정보가 저장되어 있지 않다면, 빈 객체를 보내줌
        Translation translation = translationRepository.findByLandmarkIdAndLanguage(id, userLanguage)
                .orElse(new Translation());

        return new LandmarkDetailGetResponseDto(landmark, translation);

    }

    public List<LandmarkGetResponseDto> getLandmarkByCategory(Long userId, String category, String location) {

        setUserLanguage(userId);

        QLandmark qLandmark = QLandmark.landmark;
        BooleanExpression categoryPredicate = category != null ? qLandmark.categoryList.any().type.eq(category) : null;
        BooleanExpression locationPredicate = location != null ? qLandmark.locationList.any().type.eq(location) : null;

        BooleanExpression combinedPredicate = Expressions.allOf(categoryPredicate, locationPredicate);

        List<Landmark> landmarkList = combinedPredicate != null
                ? (List<Landmark>) landmarkRepository.findAll(combinedPredicate)
                : landmarkRepository.findAll();

        return landmarkList.stream()
                .map(landmark -> {
                    Translation translation = translationRepository.findByLandmarkIdAndLanguage(landmark.getId(), userLanguage)
                            .orElse(new Translation());
                    return new LandmarkGetResponseDto(landmark, translation);
                })
                .collect(Collectors.toList());
    }

    // 사용자 언어 설정
    private void setUserLanguage(Long userId) {
        if (userId != null) {
            userRepository.findById(userId)
                    .ifPresent(user -> userLanguage = user.getLanguage());
        }
    }
}