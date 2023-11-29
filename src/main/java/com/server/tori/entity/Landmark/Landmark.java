package com.server.tori.entity.Landmark;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Landmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latitude;

    private Double longitude;

    @OneToMany(mappedBy = "landmark", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Category> categoryList;

    @OneToMany(mappedBy = "landmark", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Location> locationList;

    @OneToMany(mappedBy = "landmark", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Image> imageList;

    @OneToMany(mappedBy = "landmark", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Translation> translationList;
}
