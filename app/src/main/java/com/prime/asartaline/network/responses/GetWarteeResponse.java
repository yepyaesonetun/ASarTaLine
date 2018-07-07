package com.prime.asartaline.network.responses;

import com.google.gson.annotations.SerializedName;
import com.prime.asartaline.data.vo.WarDeeVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yepyaesonetun on 7/2/18.
 **/

public class GetWarteeResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int pageNo;

    @SerializedName("astlWarDee")
    private List<WarDeeVO> warDeeVOList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPageNo() {
        return pageNo;
    }

    public List<WarDeeVO> getWarDeeVOList() {
        if(warDeeVOList == null){
            warDeeVOList = new ArrayList<>();
        }
        return warDeeVOList;
    }
}
