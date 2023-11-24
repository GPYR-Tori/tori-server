package com.server.tori.repository;

import com.server.tori.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
  List<Like> findAllByUserId(Long user_Id);

  Optional<Like> findByLandmarkId(Long landmarkId);
}
