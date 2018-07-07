package com.prime.asartaline.data.models;

import android.arch.lifecycle.LiveData;
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
                                persistWarDeeDataToDB(mWarDeeVOList);
                            }
                            if (mMealShopVOList.size() > 0) {
                                mealShopLD.setValue(mMealShopVOList);
                                persistMealShopToDB(mMealShopVOList);
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
        List<GeneralTasteVO> generalTasteList = new ArrayList<>();
        List<SuitedForVO> suitedForList = new ArrayList<>();
        List<MatchWarDeeVO> matchWarDeeList = new ArrayList<>();
        List<MealShopVO> mealShopList = new ArrayList<>();
        List<ShopByDistanceVO> shopByDistanceList = new ArrayList<>();
        List<ShopByPopularityVO> shopByPopularityList = new ArrayList<>();

        for (WarDeeVO food : warDeeVOS) {
            for (GeneralTasteVO generalTaste : food.getGeneralTaste()) {
                generalTaste.setFoodId(food.getWarDeeId());
                generalTasteList.add(generalTaste);
            }
            for (SuitedForVO suitedFor : food.getSuitedFor()) {
                suitedFor.setFoodId(food.getWarDeeId());
                suitedForList.add(suitedFor);
            }
            for (MatchWarDeeVO matchWarDee : food.getMatchWarDeeList()) {
                matchWarDee.setFoodId(food.getWarDeeId());
                matchWarDeeList.add(matchWarDee);
            }
            for (ShopByDistanceVO shopByDistance : food.getShopByDistance()) {
                mealShopList.add(shopByDistance.getMealShop());

                shopByDistance.setFoodId(food.getWarDeeId());
                shopByDistanceList.add(shopByDistance);
            }
            for (ShopByPopularityVO shopByPopularity : food.getShopByPopularity()) {
                mealShopList.add(shopByPopularity.getMealShop());

                shopByPopularity.setFoodId(food.getWarDeeId());
                shopByPopularityList.add(shopByPopularity);
            }
        }

        long[] insertedGeneratedTaste = mTheDB.generalTasteDao().insertGeneralTaste(generalTasteList.toArray(new GeneralTasteVO[0]));
        Log.d("WarDee DB", "insertedGeneratedTaste : " + insertedGeneratedTaste);

        long[] insertedSuitedFor = mTheDB.suitedForDao().insertSuitedFor(suitedForList.toArray(new SuitedForVO[0]));
        Log.d("WarDee DB", "insertedSuitedFor : " + insertedSuitedFor);

        long[] insertedMatchWarDee = mTheDB.matchWarDeeListDao().insertMatchWarDee(matchWarDeeList.toArray(new MatchWarDeeVO[0]));
        Log.d("WarDee DB", "insertedMatchWarDee : " + insertedMatchWarDee);

        long[] insertedShopByDistance = mTheDB.shopByDistanceDao().insertShopByDistance(shopByDistanceList.toArray(new ShopByDistanceVO[0]));
        Log.d("WarDee DB", "insertedShopByDistance : " + insertedShopByDistance);

        long[] insertedShopByPopularity = mTheDB.shopByPopularityDao().insertShopByPopularity(shopByPopularityList.toArray(new ShopByPopularityVO[0]));
        Log.d("WarDee DB", "insertedShopByPopularity : " + insertedShopByPopularity);

        long[] insertedMealShop = mTheDB.mealShopDao().insertMealShop(mealShopList.toArray(new MealShopVO[0]));
        Log.d("WarDee DB", "insertedMealShop : " + insertedMealShop);

        long[] insertedFoods = mTheDB.foodDao().insertFood(warDeeVOS.toArray(new WarDeeVO[0]));
        Log.d("WarDee DB", "insertedFoods : " + insertedFoods);
    }

    private void persistMealShopToDB(List<ShopVO> mealShopVOList) {
        List<ReviewVO> reviewsList = new ArrayList<>();

        for (ShopVO restaurant : mealShopVOList) {
            for (ReviewVO reviews : restaurant.getReviewVOList()) {
                reviews.setRestaurantId(restaurant.getShopId());
            }
        }

        long[] insertedReviews = mTheDB.reviewsDao().insertReview(reviewsList.toArray(new ReviewVO[0]));
        Log.d("Shop DB", "insertedReviews : " + insertedReviews);

        long[] insertedRestaurants = mTheDB.restaurantDao().insertRestaurant(mealShopVOList.toArray(new ShopVO[0]));
        Log.d("Shop DB", "insertedRestaurants : " + insertedRestaurants);
    }

    public LiveData<WarDeeVO> getWarDeeByIdLD(final String foodId) {
        final MutableLiveData<WarDeeVO> warDeeLD = new MutableLiveData<>();
        mTheDB.foodDao().getWarDeeByIdLD(foodId).observeForever(warDeeVO -> {
            if (warDeeVO != null) {
                for (ShopByDistanceVO shopByDistance : warDeeVO.getShopByDistance()) {
                    shopByDistance.setMealShop(mTheDB.mealShopDao().getMatchMealShopById(shopByDistance.getMealShopId()));
                }
                for (ShopByPopularityVO shopByPopularity : warDeeVO.getShopByPopularity()) {
                    shopByPopularity.setMealShop(mTheDB.mealShopDao().getMatchMealShopById(shopByPopularity.getMealShopId()));
                }

                warDeeLD.setValue(warDeeVO);
            }
        });
        return warDeeLD;
    }

    public LiveData<ShopVO> getRestaurantByIdLD(final String restaurantId) {
        final MutableLiveData<ShopVO> shopLD = new MutableLiveData<>();
        mTheDB.restaurantDao().getRestaurantsByIdLD(restaurantId).observeForever(restaurant -> shopLD.setValue(restaurant));
        return shopLD;
    }

}
