package com.server.tori.dto.Dotori;

import com.server.tori.entity.Landmark.Landmark;
import com.server.tori.entity.Landmark.Translation;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DotoriLocationResponseDto {
    private Long landmarkId;
    private String landmarkName;
    private String landmarkAddress;
    private double landmarkLongitude;
    private double landmarkLatitude;

    public DotoriLocationResponseDto(Landmark landmark, Translation translation) {
        this.landmarkId = landmark.getId();
        this.landmarkName = translation.getName();
        this.landmarkAddress = translation.getAddress();
        this.landmarkLongitude = landmark.getLongitude();
        this.landmarkLatitude = landmark.getLatitude();
    }
}
