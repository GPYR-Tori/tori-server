package com.server.tori.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.server.tori.entity.Landmark.Landmark;
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

  @ManyToOne
  @JoinColumn(name = "user_id")
  public User user;

  @ManyToOne
  @JoinColumn(name = "landmark_id")
  public Landmark landmark;

  public Like(User user, Landmark landmark) {
    this.user = user;
    this.landmark = landmark;
  }

  public void setUser(User user){
    this.user = user;
  }

}
