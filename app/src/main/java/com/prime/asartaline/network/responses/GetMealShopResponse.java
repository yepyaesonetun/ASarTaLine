package com.prime.asartaline.network.responses;

import com.google.gson.annotations.SerializedName;
import com.prime.asartaline.data.vo.ShopVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yepyaesonetun on 7/6/18.
 **/

public class GetMealShopResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("astlMealShop")
    private List<ShopVO> mealShopVOList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public List<ShopVO> getMealShopVOList() {
        if (mealShopVOList == null){
            mealShopVOList = new ArrayList<>();
        }
        return mealShopVOList;
    }
}
