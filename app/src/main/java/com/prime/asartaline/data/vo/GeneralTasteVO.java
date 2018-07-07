package com.prime.asartaline.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yepyaesonetun on 7/4/18.
 **/

public class GeneralTasteVO {

    @SerializedName("tasteId")
    public String tasteId;

    @SerializedName("taste")
    public String taste;

    @SerializedName("tasteDesc")
    public String tasteDesc;

    public String getTasteId() {
        return tasteId;
    }

    public void setTasteId(String tasteId) {
        this.tasteId = tasteId;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getTasteDesc() {
        return tasteDesc;
    }

    public void setTasteDesc(String tasteDesc) {
        this.tasteDesc = tasteDesc;
    }
}
