package com.server.tori.service;

import com.server.tori.dto.GuideTourBusResponseDto;
import com.server.tori.entity.TourBus;
import com.server.tori.repository.TourBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourBusService {
  @Autowired
  TourBusRepository tourBusRepository;

  public GuideTourBusResponseDto tourBus(String userLanguage) {
    TourBus tourBus = tourBusRepository.findByLanguage(userLanguage);
    return new GuideTourBusResponseDto(tourBus.getContent());
  }
}
