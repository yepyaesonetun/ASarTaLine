package com.prime.asartaline.persistence.doas;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.prime.asartaline.data.vo.GeneralTasteVO;

import java.util.List;

/**
 * Created by yepyaesonetun on 7/6/18.
 **/

@Dao
public interface GeneralTasteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertGeneralTaste(GeneralTasteVO... generalTasteVOS);

    @Query("SELECT * FROM general_taste")
    List<GeneralTasteVO> getAllTastes();

    @Query("SELECT * FROM general_taste WHERE warDeeId = :warDeeId")
    GeneralTasteVO getTasteById(String warDeeId);

    @Query("SELECT * FROM general_taste WHERE warDeeId = :warDeeId")
    LiveData<List<GeneralTasteVO>> getTasteLDById(String warDeeId);
}
