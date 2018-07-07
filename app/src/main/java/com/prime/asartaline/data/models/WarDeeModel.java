package com.prime.asartaline.data.models;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.prime.asartaline.data.vo.GeneralTasteVO;
import com.prime.asartaline.data.vo.MatchWarDeeVO;
import com.prime.asartaline.data.vo.MealShopVO;
import com.prime.asartaline.data.vo.ReviewVO;
import com.prime.asartaline.data.vo.ShopByDistanceVO;
import com.prime.asartaline.data.vo.ShopByPopularityVO;
import com.prime.asartaline.data.vo.ShopVO;
import com.prime.asartaline.data.vo.SuitedForVO;
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

    private List<ShopVO> mMealShopVOList = new ArrayList<>();
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
                                     final MutableLiveData<List<ShopVO>> mealShopLD,
                                     final MutableLiveData<String> errorLD) {

        // pageNo ...

        mTheAPI.loadMealShops(AppConstants.ACCESS_TOKEN)
                .flatMap(getMealShopResponse -> {
                    if (getMealShopResponse != null
                            && getMealShopResponse.getMealShopVOList() != null
                            && getMealShopResponse.getMealShopVOList().size() > 0) {

                        // could not invoke setValue on Background Thread, so store first to list
                        mMealShopVOList.addAll(getMealShopResponse.getMealShopVOList());

                        persistMealShopToDB(getMealShopResponse.getMealShopVOList());
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

                                persistWarDeeDataToDB(getWarteeResponse.getWarDeeVOList());
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

    private void persistWarDeeDataToDB(List<WarDeeVO> warDeeVOS) {
        for (WarDeeVO warDeeVO : warDeeVOS) {
            if (warDeeVO.getGeneralTaste() != null) {
                for (GeneralTasteVO generalTasteVO : warDeeVO.getGeneralTaste()) {
                    mTheDB.generalTasteDAO().insertGeneralTaste(generalTasteVO);
                }
            }
            if (warDeeVO.getMatchWarTees() != null) {
                for (MatchWarDeeVO matchWarTeeVO : warDeeVO.getMatchWarTees()) {
                    mTheDB.matchWarDeeDAO().insertMatchWarDee(matchWarTeeVO);
                }
            }
            if (warDeeVO.getShopByDistance() != null) {
                for (ShopByDistanceVO shopByDistanceVO : warDeeVO.getShopByDistance()) {
                    if (shopByDistanceVO.getMealShop() != null) {
                        for (MealShopVO mealShopVO : shopByDistanceVO.getMealShop()) {
                            mTheDB.mealShopDAO().insertMealShops(mealShopVO);
                        }
                    }
                    mTheDB.shopByDistanceDAO().insertShops(shopByDistanceVO);
                }
            }
            if (warDeeVO.getShopByPopularity() != null) {
                for (ShopByPopularityVO shopByPopularityVO : warDeeVO.getShopByPopularity()) {
                    if (shopByPopularityVO.getMealShop() != null) {
                        for (MealShopVO mealShopVO : shopByPopularityVO.getMealShop()) {
                            mTheDB.mealShopDAO().insertMealShops(mealShopVO);
                        }
                    }
                    mTheDB.shopByPopularityDAO().insertShops(shopByPopularityVO);
                }
            }
            if (warDeeVO.getSuitedFor() != null) {
                for (SuitedForVO suitedForVO : warDeeVO.getSuitedFor()) {
                    mTheDB.suitedForDAO().insertSuitedFor(suitedForVO);
                }
            }
            mTheDB.warDeeDAO().insertWarDee(warDeeVO);
        }
        Log.d("DB WarDee", "SAVED ");
    }

    private void persistMealShopToDB(List<ShopVO> mealShopVOList) {
        for (ShopVO shopVO : mealShopVOList) {
            if (shopVO.getReviewVOList() != null) {
                for (ReviewVO reviewsVO : shopVO.getReviewVOList()) {
//                    mTheDB.ReviewsDAO().insertAllReviews(reviewsVO);
                }
            }
//            mTheDB.ShopDAO().insertShops(shopVO);
        }
//        Log.d(ASarTaLineApp.LOG_TAG, "SAVED SHOP LIST ");
    }
}
