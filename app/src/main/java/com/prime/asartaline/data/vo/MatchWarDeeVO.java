package com.prime.asartaline.data.vo;

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
    @SerializedName("warDeeId")
    private String matchWarDeeId;

    private String warDeeId;

    public String getWarDeeId() {
        return warDeeId;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }

    @NonNull
    public String getMatchWarDeeId() {
        return matchWarDeeId;
    }

    public void setMatchWarDeeId(@NonNull String matchWarDeeId) {
        this.matchWarDeeId = matchWarDeeId;
    }

}
