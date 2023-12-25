package com.server.tori.dto.Landmark;

import com.server.tori.entity.Landmark.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class LandmarkGetResponseDto {
    private Long landmarkId;
    private String name;
    private List<String> categoryList;
    private List<String> locationList;
    private List<String> imageList;

    public LandmarkGetResponseDto(Landmark landmark, Translation translation) {
        this.landmarkId = landmark.getId();
        this.name = translation.getName();
        this.categoryList = mapCategory(landmark.getCategoryList());
        this.locationList = mapLocation(landmark.getLocationList());
        this.imageList = mapImage(landmark.getImageList());
    }

    private List<String> mapCategory(List<Category> categoryList) {
        return categoryList.stream()
                .map(Category::getType)
                .collect(Collectors.toList());
    }

    private List<String> mapLocation(List<Location> locationList) {
        return locationList.stream()
                .map(Location::getType)
                .collect(Collectors.toList());
    }

    private List<String> mapImage(List<Image> ImageList) {
        return ImageList.stream()
                .map(Image::getPath)
                .collect(Collectors.toList());
    }
}
