package com.prime.asartaline.persistence.doas;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.prime.asartaline.data.vo.WarDeeVO;

import java.util.List;

/**
 * Created by yepyaesonetun on 7/6/18.
 **/

@Dao
public interface WarDeeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertFood(WarDeeVO... foodVOs);

    @Query("SELECT * FROM war_dee")
    List<WarDeeVO> getAllFoods();

    @Query("SELECT * FROM war_dee WHERE war_dee_id = :warDeeId")
    WarDeeVO getWarrDeeByID(String warDeeId);

    @Query("SELECT * FROM war_dee WHERE war_dee_id = :warDeeId")
    LiveData<WarDeeVO> getWarDeeByIdLD(String warDeeId);
}
