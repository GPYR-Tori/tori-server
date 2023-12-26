package com.server.tori.repository;

import com.server.tori.entity.Landmark.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LandmarkRepository extends JpaRepository<Landmark, Long>, QuerydslPredicateExecutor<Landmark> {
    @Query("SELECT landmark FROM Landmark landmark " +
            "WHERE 6371 * acos(cos(radians(:latitude)) * cos(radians(landmark.latitude)) * cos(radians(landmark.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(landmark.latitude))) <= 5.0")
    List<Landmark> findLandmarkByDistance(@Param("latitude") double latitude, @Param("longitude") double longitude);

}

