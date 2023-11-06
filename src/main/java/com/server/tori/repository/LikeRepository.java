package com.server.tori.repository;

import com.server.tori.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
  List<Like> findAllByUserId(Long user_Id);

}
