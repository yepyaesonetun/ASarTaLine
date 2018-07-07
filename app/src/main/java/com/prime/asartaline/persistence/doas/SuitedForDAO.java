package com.prime.asartaline.persistence.doas;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.prime.asartaline.data.vo.SuitedForVO;

import java.util.List;

/**
 * Created by yepyaesonetun on 7/6/18.
 **/

@Dao
public interface SuitedForDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertSuitedFor(SuitedForVO... suitedForVOS);

    @Query("SELECT * FROM suited_for")
    List<SuitedForVO> getAllSuitedItems();

    @Query("SELECT * FROM suited_for WHERE warDeeId = :warDeeId")
    SuitedForVO getSuitedItemsById(String warDeeId);

    @Query("SELECT * FROM suited_for WHERE warDeeId = :warDeeId")
    LiveData<List<SuitedForVO>> getSuitedItemsLDById(String warDeeId);
}
