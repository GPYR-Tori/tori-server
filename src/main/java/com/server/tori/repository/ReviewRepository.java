package com.server.tori.repository;

import com.server.tori.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    int countReviewsByLandmarkId(Long landmarkId);
}
