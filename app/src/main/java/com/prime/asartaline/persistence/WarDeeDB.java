package com.prime.asartaline.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.prime.asartaline.data.vo.GeneralTasteVO;
import com.prime.asartaline.data.vo.MatchWarDeeVO;
import com.prime.asartaline.data.vo.MealShopVO;
import com.prime.asartaline.data.vo.ShopByDistanceVO;
import com.prime.asartaline.data.vo.ShopByPopularityVO;
import com.prime.asartaline.data.vo.SuitedForVO;
import com.prime.asartaline.data.vo.WarDeeVO;
import com.prime.asartaline.persistence.doas.GeneralTasteDAO;
import com.prime.asartaline.persistence.doas.MatchWarDeeDAO;
import com.prime.asartaline.persistence.doas.MealShopDAO;
import com.prime.asartaline.persistence.doas.ShopByDistanceDAO;
import com.prime.asartaline.persistence.doas.ShopByPopularityDAO;
import com.prime.asartaline.persistence.doas.SuitedForDAO;
import com.prime.asartaline.persistence.doas.WarDeeDAO;

/**
 * Created by yepyaesonetun on 7/6/18.
 **/
//@Database(entities = {GeneralTasteVO.class, MatchWarDeeVO.class, MealShopVO.class,
//        ShopByDistanceVO.class, ShopByPopularityVO.class, SuitedForVO.class, WarDeeVO.class},
//        version = 1, exportSchema = false)
public abstract class WarDeeDB extends RoomDatabase{
    private static final String DB_NAME = "A_SAR_TA_LINE.DB";
    private static WarDeeDB DB_INSTANCE;

    //DEFINE DAOs
    public abstract GeneralTasteDAO generalTasteDAO();
    public abstract MatchWarDeeDAO matchWarDeeDAO();
    public abstract MealShopDAO mealShopDAO();
    public abstract ShopByDistanceDAO shopByDistanceDAO();
    public abstract ShopByPopularityDAO shopByPopularityDAO();
    public abstract SuitedForDAO suitedForDAO();
    public abstract WarDeeDAO warDeeDAO();

    public static WarDeeDB getDatabase(Context context){
        if (DB_INSTANCE == null){
            DB_INSTANCE = Room.inMemoryDatabaseBuilder(context, WarDeeDB.class).build();
//            DB_INSTANCE = Room.databaseBuilder(context, WarDeeDB.class, DB_NAME)
//                    .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
//                    .build();
        }
        return DB_INSTANCE;
    }
}
