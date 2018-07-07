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
    long[] insertMatchWarDee(MatchWarDeeVO... matchWarDeeListVOs);

    @Query("SELECT * FROM match_war_tee")
    List<MatchWarDeeVO> getAllMatchWarDeeList();

    @Query("SELECT * FROM match_war_tee WHERE war_dee_id= :warDeeId")
    MatchWarDeeVO getMatchWarDeeListById(String warDeeId);

    @Query("SELECT * FROM match_war_tee WHERE war_dee_id= :warDeeId")
    LiveData<MatchWarDeeVO> getMatchWarDeeListByIdLD(String warDeeId);
}
