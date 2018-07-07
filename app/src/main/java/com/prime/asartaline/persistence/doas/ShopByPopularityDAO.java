package com.prime.asartaline.persistence.doas;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.prime.asartaline.data.vo.ShopByPopularityVO;

import java.util.List;

/**
 * Created by yepyaesonetun on 7/6/18.
 **/

@Dao
public interface ShopByPopularityDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertShopByPopularity(ShopByPopularityVO... shopByPopularityVOs);

    @Query("SELECT * FROM shop_by_popularity")
    List<ShopByPopularityVO> getAllShopsByPopularity();

    @Query("SELECT * FROM shop_by_popularity WHERE shop_by_popularity_id= :shopByPopularityId")
    ShopByPopularityVO getShopByPopularityById(String shopByPopularityId);

    @Query("SELECT * FROM shop_by_popularity WHERE shop_by_popularity_id= :shopByPopularityId")
    LiveData<ShopByPopularityVO> getShopByPopularityByIdLD(String shopByPopularityId);
}
