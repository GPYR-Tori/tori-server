package com.server.tori.repository;


import com.server.tori.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GuideRepository extends JpaRepository <Guide, Long> {
  List<Guide> findAllByLanguage(String language);
}
