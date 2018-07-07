package com.prime.asartaline.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yepyaesonetun on 7/4/18.
 **/

@Entity(tableName = "match_war_tee")
public class MatchWarDeeVO {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "war_dee_id")
    private String warDeeId;
    @ColumnInfo(name = "food_id")
    private transient String foodId;

    public String getWarDeeId() {
        return warDeeId;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

}
