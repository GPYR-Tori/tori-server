package com.server.tori.entity.Landmark;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "landmark_id")
    @JsonBackReference
    private Landmark landmark;

    @Column(columnDefinition = "TEXT")
    private String path;
}
