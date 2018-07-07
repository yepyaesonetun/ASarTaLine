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
    long[] insertGeneralTaste(GeneralTasteVO... generalTasteVOs);

    @Query("SELECT * FROM general_taste")
    List<GeneralTasteVO> getAllGeneralTastes();

    @Query("SELECT * FROM general_taste WHERE taste_id= :tasteId")
    GeneralTasteVO getGeneralTastesByFoodId(String tasteId);

    @Query("SELECT * FROM general_taste WHERE taste_id= :tasteId")
    LiveData<GeneralTasteVO> getGeneralTastesByIdLD(String tasteId);
}
