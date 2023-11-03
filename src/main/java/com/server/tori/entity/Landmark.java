package com.server.tori.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Landmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> category = new ArrayList<>();

    @ElementCollection
    private List<String> location = new ArrayList<>();
    
    private String name;

    private String address;

    private Double latitude;

    private Double longitude;

    private String description;

    private String price;

    private String time;

    private String site;

    @ElementCollection
    @Column(columnDefinition = "TEXT")
    private List<String> image = new ArrayList<>();

    private String language;

    public Landmark(String name, String address, String description, double latitude, double longitude, String price, String time, String site, String language,
                    List<String> category, List<String> location, List<String> image) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.price = price;
        this.time = time;
        this.site = site;
        this.language = language;
        this.category = category;
        this.location = location;
        this.image = image;
    }
}
