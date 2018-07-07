package com.prime.asartaline.persistence.doas;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.prime.asartaline.data.vo.ShopVO;

import java.util.List;

/**
 * Created by yepyaesonetun on 7/7/18.
 **/

@Dao
public interface ShopDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertRestaurant(ShopVO... restaurantVOs);

    @Query("SELECT * FROM shops")
    List<ShopVO> getAllRestaurants();

    @Query("SELECT * FROM shops WHERE shop_id = :shopId")
    ShopVO getRestaurantById(String shopId);

    @Query("SELECT * FROM shops WHERE shop_id = :shopId")
    LiveData<ShopVO> getRestaurantsByIdLD(String shopId);
}
