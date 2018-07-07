package com.prime.asartaline.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yepyaesonetun on 7/4/18.
 **/

public class ShopByDistanceVO {
    @SerializedName("shopByDistanceId")
    public String shopByDistanceId;
//    @SerializedName("mealShop")
//    public MealShop mealShop;
    @SerializedName("distanceInFeet")
    public Double distanceInFeet;
}
