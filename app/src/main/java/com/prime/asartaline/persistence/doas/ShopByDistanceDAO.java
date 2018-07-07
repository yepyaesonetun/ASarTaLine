package com.prime.asartaline.persistence.doas;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.prime.asartaline.data.vo.ShopByDistanceVO;

import java.util.List;

/**
 * Created by yepyaesonetun on 7/6/18.
 **/

@Dao
public interface ShopByDistanceDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertShopByDistance(ShopByDistanceVO... shopByDistanceVOs);

    @Query("SELECT * FROM shop_by_distance")
    List<ShopByDistanceVO> getAllShopsByDistance();

    @Query("SELECT * FROM shop_by_distance WHERE shop_by_distance_id= :shopByDistanceId")
    ShopByDistanceVO getShopByDistanceById(String shopByDistanceId);

    @Query("SELECT * FROM shop_by_distance WHERE shop_by_distance_id= :shopByDistanceId")
    LiveData<ShopByDistanceVO> getShopByDistanceByIdLD(String shopByDistanceId);
}
