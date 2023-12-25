package com.server.tori.service;

import com.server.tori.dto.Guide.GuideResponseDto;
import com.server.tori.dto.Guide.GuideValueDto;
import com.server.tori.entity.Guide;
import com.server.tori.entity.TourBus;
import com.server.tori.repository.GuideRepository;
import com.server.tori.repository.TourBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class GuideService {

  @Autowired
  GuideRepository guideRepository;
  @Autowired
  TourBusRepository tourBusRepository;

  // 5. 사용자 언어 설정을 받아와서 해당 언어에 따른 가이드 정보를 가져오는 메서드
  public GuideResponseDto guide(String userLanguage) {
    // 6. 사용자 언어에 맞는 가이드 정보를 데이터베이스에서 검색합니다.
    List<Guide> guides = guideRepository.findAllByLanguage(userLanguage);
    TourBus tourBus = tourBusRepository.findByLanguage(userLanguage);
    // 7. 가이드 정보를 가지고 GuideResponseDto를 초기화합니다.
    GuideResponseDto guideResponseDto = new GuideResponseDto();

    //8-1 투어버스 데이터 가져오기
    guideResponseDto.setContent(tourBus.getContent());

    // 8. GuideResponseDto에 언어별 카테고리 (예: A_course, B_course 등)에 해당하는 가이드 데이터를 할당하기 위해 mapGuideValues 메서드를 호출합니다.
    guideResponseDto.setA_course(mapGuideValues(guides, "A_course"));
    guideResponseDto.setB_course(mapGuideValues(guides, "B_course"));
    guideResponseDto.setC_course(mapGuideValues(guides, "C_course"));
    guideResponseDto.setD_course(mapGuideValues(guides, "D_course"));
    guideResponseDto.setE_course(mapGuideValues(guides, "E_course"));
    guideResponseDto.setF_course(mapGuideValues(guides, "F_course"));
    guideResponseDto.setG_course(mapGuideValues(guides, "G_course"));
    guideResponseDto.setH_course(mapGuideValues(guides, "H_course"));
    guideResponseDto.setI_course(mapGuideValues(guides, "I_course"));
    guideResponseDto.setJ_course(mapGuideValues(guides, "J_course"));
    guideResponseDto.setK_course(mapGuideValues(guides, "K_course"));
    guideResponseDto.setL_course(mapGuideValues(guides, "L_course"));

    // 9. GuideResponseDto를 반환합니다.
    return guideResponseDto;
  }

  private List<GuideValueDto> mapGuideValues(List<Guide> guides, String category) {
    List<GuideValueDto> guideValueDtos = new ArrayList<>();

    for (Guide guide : guides) {
      if (category.equals(guide.getCategory())) {
        GuideValueDto guideValueDto = new GuideValueDto();
        guideValueDto.setPrice(guide.getPrice());
        guideValueDto.setTripPoint(guide.getTripPoint());
        guideValueDto.setCourse(guide.getCourse());
        guideValueDtos.add(guideValueDto);
      }
    }
    return guideValueDtos;
  }

}
