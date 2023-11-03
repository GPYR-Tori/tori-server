package com.server.tori.repository;

import com.server.tori.entity.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandmarkRepository extends JpaRepository<Landmark, Long> {
    List<Landmark> findByCategory(String category);
    List<Landmark> findByLocation(String location);
    List<Landmark> findByCategoryAndLocation(String category, String location);
}
