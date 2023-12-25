package com.server.tori.dto.Landmark;

import com.server.tori.entity.Landmark.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class LandmarkDetailGetResponseDto {
    private String name;
    private String address;
    private String description;
    private String price;
    private String time;
    private String site;
    private String phoneNum;
    private List<String> categoryList;
    private List<String> locationList;
    private List<String> imageList;

    public LandmarkDetailGetResponseDto(Landmark landmark, Translation translation) {
        this.name = translation.getName();
        this.address = translation.getAddress();
        this.description = translation.getDescription();
        this.price = landmark.getPrice();
        this.time = landmark.getTime();
        this.site = landmark.getSite();
        this.phoneNum = landmark.getPhoneNum();
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