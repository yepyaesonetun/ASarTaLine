package com.prime.asartaline.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yepyaesonetun on 7/6/18.
 **/

@Entity(tableName = "meal_shop")
public class MealShopVO {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "meal_shop_id")
    private String mealShopId;

    public String getMealShopId() {
        return mealShopId;
    }

    public void setMealShopId(String mealShopId) {
        this.mealShopId = mealShopId;
    }
}
