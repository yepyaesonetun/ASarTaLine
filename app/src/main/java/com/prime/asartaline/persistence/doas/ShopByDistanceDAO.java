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
    long[] insertShops(ShopByDistanceVO... shopByDistanceVOS);

    @Query("SELECT * FROM shop_by_distance")
    List<ShopByDistanceVO> getAllShops();

    @Query("SELECT * FROM shop_by_distance WHERE warDeeId = :warDeeId")
    ShopByDistanceVO getShopsById(String warDeeId);

    @Query("SELECT * FROM shop_by_distance WHERE warDeeId = :warDeeId")
    LiveData<List<ShopByDistanceVO>> getShopsLDById(String warDeeId);
}
