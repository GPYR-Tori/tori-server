package com.server.tori.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.server.tori.dto.Landmark.LandmarkViewDetailResponseDto;
import com.server.tori.dto.Landmark.LandmarkViewResponseDto;
import com.server.tori.entity.Landmark.Landmark;
import com.server.tori.entity.Landmark.QLandmark;
import com.server.tori.entity.Landmark.Translation;
import com.server.tori.entity.User;
import com.server.tori.repository.LandmarkRepository;
import com.server.tori.repository.ReviewRepository;
import com.server.tori.repository.TranslationRepository;
import com.server.tori.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LandmarkService {

    @Autowired
    private LandmarkRepository landmarkRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private TranslationRepository translationRepository;

    // 언어 기본값 설정 (상수)
    private static final String DEFAULT_LANGUAGE = "영어";
    private String userLanguage = DEFAULT_LANGUAGE;

    public LandmarkViewDetailResponseDto getLandmarkDetail(Long id, Long userId) {

        if (userId != null) {
            Optional<User> userOptional = userRepository.findById(userId);

            if (userOptional.isPresent()) {
                User selectedUser = userOptional.get();
                userLanguage = selectedUser.getLanguage();
            } else {
                return null;
            }
        }

        Optional<Landmark> landmarkOptional = landmarkRepository.findById(id);
        Optional<Translation> translationOptional = translationRepository.findByLandmarkIdAndLanguage(id, userLanguage);
        if (landmarkOptional.isPresent()) {
            Landmark selectedLandmark = landmarkOptional.get();
            Translation selectedTranslation = translationOptional.get();

            int reviewCount = reviewRepository.countReviewsByLandmarkId(id);

            return new LandmarkViewDetailResponseDto(selectedLandmark, selectedTranslation);
        } else {
            return null;
        }
    }

    public List<LandmarkViewResponseDto> getLandmarksFilter(Long userId, String category, String location) {

        if (userId != null) {
            Optional<User> userOptional = userRepository.findById(userId);

            if (userOptional.isPresent()) {
                User selectedUser = userOptional.get();
                userLanguage = selectedUser.getLanguage();
            } else {
                return null;
            }
        }

        QLandmark landmark = QLandmark.landmark;
        BooleanExpression categoryPredicate = category != null ? landmark.categoryList.any().type.eq(category) : null;
        BooleanExpression locationPredicate = location != null ? landmark.locationList.any().type.eq(location) : null;

        BooleanExpression combinedPredicate = Expressions.allOf(categoryPredicate, locationPredicate);

        List<Landmark> landmarksList = combinedPredicate != null
                ? (List<Landmark>) landmarkRepository.findAll(combinedPredicate)
                : landmarkRepository.findAll();

        return landmarksList.stream()
                .map(selectedLandmark -> {
                    Translation selectedTranslation = translationRepository.findByLandmarkAndLanguage(selectedLandmark, userLanguage);
                    return new LandmarkViewResponseDto(selectedLandmark, selectedTranslation);
                })
                .collect(Collectors.toList());
    }
}