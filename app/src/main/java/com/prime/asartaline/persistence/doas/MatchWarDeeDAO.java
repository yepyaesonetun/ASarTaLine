package com.prime.asartaline.persistence.doas;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.prime.asartaline.data.vo.MatchWarDeeVO;

import java.util.List;

/**
 * Created by yepyaesonetun on 7/6/18.
 **/

@Dao
public interface MatchWarDeeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMatchWarDee(MatchWarDeeVO... matchWarTeeLists);

    @Query("SELECT * FROM match_war_tee WHERE warDeeId = :warDeeId")
    MatchWarDeeVO getMatchWarDeeById(String warDeeId);

    @Query("SELECT * FROM match_war_tee WHERE warDeeId = :warDeeId")
    LiveData<List<MatchWarDeeVO>> getMatchWarDeeLDById(String warDeeId);
}
