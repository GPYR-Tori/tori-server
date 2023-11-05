package com.server.tori.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Guide {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  public String language; // 언어구별
  private String price; // 여행가격
  private String tripPoint; // 여행출발,도착지
  private String course; // 여행코스
  private String categori; // A, B ... course


}
