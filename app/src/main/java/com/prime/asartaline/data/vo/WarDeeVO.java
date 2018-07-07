package com.prime.asartaline.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yepyaesonetun on 7/2/18.
 **/

public class WarDeeVO  {
    @SerializedName("warDeeId")
    public String warDeeId;

    @SerializedName("name")
    public String name;

    @SerializedName("images")
    public List<String> images;

    @SerializedName("generalTaste")
    public List<GeneralTasteVO> generalTaste;

    @SerializedName("suitedFor")
    public List<SuitedForVO> suitedFor;

    @SerializedName("priceRangeMin")
    public Integer priceRangeMin;

    @SerializedName("priceRangeMax")
    public Integer priceRangeMax;

    @SerializedName("matchWarDeeList")
    public List<MatchWarDeeVO> matchWarDeeList;

    @SerializedName("shopByDistance")
    public List<ShopByDistanceVO> shopByDistance;

    @SerializedName("shopByPopularity")
    public List<ShopByPopularityVO> shopByPopularity;


    public String getWarDeeId() {
        return warDeeId;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImages() {
        if (images == null){
            images = new ArrayList<>();
        }
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<GeneralTasteVO> getGeneralTaste() {
        return generalTaste;
    }

    public void setGeneralTaste(List<GeneralTasteVO> generalTaste) {
        this.generalTaste = generalTaste;
    }

    public List<SuitedForVO> getSuitedFor() {
        return suitedFor;
    }

    public void setSuitedFor(List<SuitedForVO> suitedFor) {
        this.suitedFor = suitedFor;
    }

    public Integer getPriceRangeMin() {
        return priceRangeMin;
    }

    public void setPriceRangeMin(Integer priceRangeMin) {
        this.priceRangeMin = priceRangeMin;
    }

    public Integer getPriceRangeMax() {
        return priceRangeMax;
    }

    public void setPriceRangeMax(Integer priceRangeMax) {
        this.priceRangeMax = priceRangeMax;
    }

    public List<MatchWarDeeVO> getMatchWarDeeList() {
        return matchWarDeeList;
    }

    public void setMatchWarDeeList(List<MatchWarDeeVO> matchWarDeeList) {
        this.matchWarDeeList = matchWarDeeList;
    }

    public List<ShopByDistanceVO> getShopByDistance() {
        return shopByDistance;
    }

    public void setShopByDistance(List<ShopByDistanceVO> shopByDistance) {
        this.shopByDistance = shopByDistance;
    }

    public List<ShopByPopularityVO> getShopByPopularity() {
        return shopByPopularity;
    }

    public void setShopByPopularity(List<ShopByPopularityVO> shopByPopularity) {
        this.shopByPopularity = shopByPopularity;
    }
}
