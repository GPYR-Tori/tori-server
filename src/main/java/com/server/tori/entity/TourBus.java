package com.server.tori.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "TourBus")
@Entity
public class TourBus {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;
  public String language;
  public String content;
}
