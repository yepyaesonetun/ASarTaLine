package com.prime.asartaline.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.prime.asartaline.persistence.typeconverters.FoodsImagesTypeConvertor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yepyaesonetun on 7/2/18.
 **/
@Entity(tableName = "war_dee")
@TypeConverters(FoodsImagesTypeConvertor.class)
public class WarDeeVO {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "war_dee_id")
    private String warDeeId;

    private String name;

    @ColumnInfo(name = "price_range_min")
    private int priceRangeMin;

    @ColumnInfo(name = "price_range_max")
    private int priceRangeMax;

    private List<String> images;

    @Ignore
    private List<GeneralTasteVO> generalTaste;

    @Ignore
    private List<SuitedForVO> suitedFor;

    @Ignore
    private List<MatchWarDeeVO> matchWarDeeList;

    @Ignore
    private List<ShopByDistanceVO> shopByDistance;

    @Ignore
    private List<ShopByPopularityVO> shopByPopularity;

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

    public int getPriceRangeMin() {
        return priceRangeMin;
    }

    public void setPriceRangeMin(int priceRangeMin) {
        this.priceRangeMin = priceRangeMin;
    }

    public int getPriceRangeMax() {
        return priceRangeMax;
    }

    public void setPriceRangeMax(int priceRangeMax) {
        this.priceRangeMax = priceRangeMax;
    }

    public List<String> getImages() {
        if (images == null) {
            images = new ArrayList<>();
        }
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<GeneralTasteVO> getGeneralTaste() {
        if (generalTaste == null) {
            generalTaste = new ArrayList<>();
        }
        return generalTaste;
    }

    public void setGeneralTaste(List<GeneralTasteVO> generalTaste) {
        this.generalTaste = generalTaste;
    }

    public List<SuitedForVO> getSuitedFor() {
        if (suitedFor == null) {
            suitedFor = new ArrayList<>();
        }
        return suitedFor;
    }

    public void setSuitedFor(List<SuitedForVO> suitedFor) {
        this.suitedFor = suitedFor;
    }

    public List<MatchWarDeeVO> getMatchWarDeeList() {
        if (matchWarDeeList == null) {
            matchWarDeeList = new ArrayList<>();
        }
        return matchWarDeeList;
    }

    public void setMatchWarDeeList(List<MatchWarDeeVO> matchWarDeeList) {
        this.matchWarDeeList = matchWarDeeList;
    }

    public List<ShopByDistanceVO> getShopByDistance() {
        if (shopByDistance == null) {
            shopByDistance = new ArrayList<>();
        }
        return shopByDistance;
    }

    public void setShopByDistance(List<ShopByDistanceVO> shopByDistance) {
        this.shopByDistance = shopByDistance;
    }

    public List<ShopByPopularityVO> getShopByPopularity() {
        if (shopByPopularity == null) {
            shopByPopularity = new ArrayList<>();
        }
        return shopByPopularity;
    }

    public void setShopByPopularity(List<ShopByPopularityVO> shopByPopularity) {
        this.shopByPopularity = shopByPopularity;
    }
}
