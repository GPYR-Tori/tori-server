package com.server.tori.dto.Dotori;

import com.server.tori.entity.Landmark.Landmark;
import com.server.tori.entity.Landmark.Translation;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DotoriLocationGetResponseDto {
    private Long landmarkId;
    private String name;
    private String address;
    private double longitude;
    private double latitude;

    public DotoriLocationGetResponseDto(Landmark landmark, Translation translation) {
        this.landmarkId = landmark.getId();
        this.name = translation.getName();
        this.address = translation.getAddress();
        this.longitude = landmark.getLongitude();
        this.latitude = landmark.getLatitude();
    }
}
