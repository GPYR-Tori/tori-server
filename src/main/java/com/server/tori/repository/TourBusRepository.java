package com.server.tori.repository;

import com.server.tori.entity.TourBus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourBusRepository extends JpaRepository<TourBus,Long > {
  TourBus findByLanguage(String language);
}
