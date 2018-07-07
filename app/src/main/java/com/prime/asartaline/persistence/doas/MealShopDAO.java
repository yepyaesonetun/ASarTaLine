package com.prime.asartaline.persistence.doas;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.prime.asartaline.data.vo.MealShopVO;

import java.util.List;

/**
 * Created by yepyaesonetun on 7/6/18.
 **/

@Dao
public interface MealShopDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMealShops(MealShopVO... mealShopVOS);

    @Query("SELECT * FROM meal_shop WHERE warDeeId = :warDeeId")
    MealShopVO getMealShopById(String warDeeId);

    @Query("SELECT * FROM meal_shop WHERE warDeeId = :warDeeId")
    LiveData<List<MealShopVO>> getMealShopLDById(String warDeeId);
}
