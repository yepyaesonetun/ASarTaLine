package com.prime.asartaline.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yepyaesonetun on 7/6/18.
 **/

public class MealShopVO {

    @SerializedName("shopId")
    private String shopId;

    @SerializedName("name")
    private String name;

    @SerializedName("address")
    private String address;

    @SerializedName("lat")
    private double lat;

    @SerializedName("lng")
    private double lng;

    @SerializedName("township")
    private String township;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("shopImages")
    private List<String> shopImages;

    @SerializedName("reviews")
    private List<ReviewVO> reviewVOList;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public List<String> getShopImages() {
        return shopImages;
    }

    public void setShopImages(List<String> shopImages) {
        this.shopImages = shopImages;
    }

    public List<ReviewVO> getReviewVOList() {
        return reviewVOList;
    }

    public void setReviewVOList(List<ReviewVO> reviewVOList) {
        this.reviewVOList = reviewVOList;
    }
}
