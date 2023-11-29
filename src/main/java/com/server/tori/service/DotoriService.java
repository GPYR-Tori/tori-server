package com.server.tori.service;

import com.server.tori.dto.Dotori.DotoriMyPageResponseDto;
import com.server.tori.dto.Dotori.DotoriRequestDto;
import com.server.tori.dto.Dotori.DotoriLocationResponseDto;
import com.server.tori.entity.Dotori;
import com.server.tori.entity.Landmark.Landmark;
import com.server.tori.entity.Landmark.Translation;
import com.server.tori.entity.User;
import com.server.tori.repository.DotoriRepository;
import com.server.tori.repository.LandmarkRepository;
import com.server.tori.repository.TranslationRepository;
import com.server.tori.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<DotoriLocationResponseDto> getLandmarksByUser(Long userId, double latitude, double longitude) {

        if (userId != null) {
            Optional<User> userOptional = userRepository.findById(userId);

            if (userOptional.isPresent()) {
                User selectedUser = userOptional.get();
                userLanguage = selectedUser.getLanguage();
            } else {
                return null;
            }
        }

        List<Landmark> landmarksList = landmarkRepository.findLandmarksByDistance(latitude, longitude);

        return landmarksList.stream()
                .map(selectedLandmark -> {
                    Translation selectedTranslation = translationRepository.findByLandmarkAndLanguage(selectedLandmark, userLanguage);
                    return new DotoriLocationResponseDto(selectedLandmark, selectedTranslation);
                })
                .collect(Collectors.toList());
    }

    public String postDotori(DotoriRequestDto dotoriRequestDto) {
        Optional<User> userOptional = userRepository.findById(dotoriRequestDto.getUserId());
        Optional<Landmark> landmarkOptional = landmarkRepository.findById(dotoriRequestDto.getLandmarkId());

        if (userOptional.isPresent() && landmarkOptional.isPresent()) {
            User selectedUser = userOptional.get();
            Landmark selectedLandmark = landmarkOptional.get();

            Dotori dotori = new Dotori(selectedUser);
            dotoriRepository.save(dotori);

            return "sucess";
        }
        return "false";
    }

    public DotoriMyPageResponseDto getDotoriInfo(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User selectedUser = userOptional.get();

            int total = dotoriRepository.countByUser(selectedUser);
            int num = total % 10;

            return new DotoriMyPageResponseDto(total, num);
        } else {
            return null;
        }
    }
}
