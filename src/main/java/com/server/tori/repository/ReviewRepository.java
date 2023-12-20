package com.server.tori.repository;

import com.server.tori.entity.Landmark.Landmark;
import com.server.tori.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByLandmark(Landmark landmark);

}
