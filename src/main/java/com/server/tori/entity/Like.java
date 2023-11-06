package com.server.tori.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "landmark_like")
@Entity
@NoArgsConstructor
public class Like {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;
  public Long userId;
  public Long landmarkId;

  public Like(Long userId, Long landmarkId) {
    this.userId = userId;
    this.landmarkId = landmarkId;
  }

}
