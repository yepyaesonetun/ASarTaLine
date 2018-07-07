package com.prime.asartaline.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yepyaesonetun on 7/4/18.
 **/

public class SuitedForVO {

    @SerializedName("suitedForId")
    public String suitedForId;

    @SerializedName("suitedFor")
    public String suitedFor;

    @SerializedName("suitedForDesc")
    public String suitedForDesc;

    public String getSuitedForId() {
        return suitedForId;
    }

    public void setSuitedForId(String suitedForId) {
        this.suitedForId = suitedForId;
    }

    public String getSuitedFor() {
        return suitedFor;
    }

    public void setSuitedFor(String suitedFor) {
        this.suitedFor = suitedFor;
    }

    public String getSuitedForDesc() {
        return suitedForDesc;
    }

    public void setSuitedForDesc(String suitedForDesc) {
        this.suitedForDesc = suitedForDesc;
    }
}
