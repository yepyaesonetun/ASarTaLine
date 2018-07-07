package com.prime.asartaline.data.models;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.prime.asartaline.data.vo.MealShopVO;
import com.prime.asartaline.data.vo.WarDeeVO;
import com.prime.asartaline.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yepyaesonetun on 7/2/18.
 **/

public class WarDeeModel extends BaseModel {

    private static WarDeeModel sObjInstance;

    private List<MealShopVO> mMealShopVOList = new ArrayList<>();
    private List<WarDeeVO> mWarDeeVOList = new ArrayList<>();
    private String mMealShopErrMsg;
    private String mWarDeeErrMsg;

    public static void initWarDeeModel(Context context) {
        sObjInstance = new WarDeeModel(context);
    }

    public static WarDeeModel getInstance() {
        if (sObjInstance == null) {
            throw new RuntimeException("NewsModel is being invoked before initializing.");
        }
        return sObjInstance;
    }

    protected WarDeeModel(Context context) {
        super(context);
    }

    public void startLoadingASTLData(int pageNo, final MutableLiveData<List<WarDeeVO>> warDeeLD,
                                     final MutableLiveData<List<MealShopVO>> mealShopLD,
                                     final MutableLiveData<String> errorLD) {

        // pageNo ...

        mTheAPI.loadMealShops(AppConstants.ACCESS_TOKEN)
                .flatMap(getMealShopResponse -> {
                    if (getMealShopResponse != null
                            && getMealShopResponse.getMealShopVOList() != null
                            && getMealShopResponse.getMealShopVOList().size() > 0) {

                        // could not invoke setValue on Background Thread, so store first to list
                        mMealShopVOList.addAll(getMealShopResponse.getMealShopVOList());
                    } else {
                        mMealShopErrMsg = "Empty MealShops";
                    }

                    return mTheAPI.loadWarDees(AppConstants.ACCESS_TOKEN);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        getWarteeResponse -> {
                            if (getWarteeResponse != null
                                    && getWarteeResponse.getWarDeeVOList() != null
                                    && getWarteeResponse.getWarDeeVOList().size() > 0) {

                                // could not invoke setValue on Background Thread, so store first to list
                                mWarDeeVOList.addAll(getWarteeResponse.getWarDeeVOList());
                            } else {
                                mWarDeeErrMsg = "Empty WarDees";
                            }

                            if (mWarDeeVOList.size() > 0) {
                                warDeeLD.setValue(mWarDeeVOList);
                            }
                            if (mMealShopVOList.size() > 0) {
                                mealShopLD.setValue(mMealShopVOList);
                            }
                            if (mMealShopErrMsg != null) {
                                errorLD.setValue(mMealShopErrMsg);
                            }
                            if (mWarDeeErrMsg != null) {
                                errorLD.setValue(mWarDeeErrMsg);
                            }
                        },
                        throwable -> errorLD.setValue(throwable.getMessage())
                );
    }
}
