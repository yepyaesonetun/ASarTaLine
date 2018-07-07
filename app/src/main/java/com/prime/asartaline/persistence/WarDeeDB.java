package com.prime.asartaline.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.prime.asartaline.data.vo.GeneralTasteVO;
import com.prime.asartaline.data.vo.MatchWarDeeVO;
import com.prime.asartaline.data.vo.MealShopVO;
import com.prime.asartaline.data.vo.ReviewVO;
import com.prime.asartaline.data.vo.ShopByDistanceVO;
import com.prime.asartaline.data.vo.ShopByPopularityVO;
import com.prime.asartaline.data.vo.ShopVO;
import com.prime.asartaline.data.vo.SuitedForVO;
import com.prime.asartaline.data.vo.WarDeeVO;
import com.prime.asartaline.persistence.doas.GeneralTasteDAO;
import com.prime.asartaline.persistence.doas.MatchWarDeeDAO;
import com.prime.asartaline.persistence.doas.MealShopDAO;
import com.prime.asartaline.persistence.doas.ReviewsDAO;
import com.prime.asartaline.persistence.doas.ShopByDistanceDAO;
import com.prime.asartaline.persistence.doas.ShopByPopularityDAO;
import com.prime.asartaline.persistence.doas.ShopDAO;
import com.prime.asartaline.persistence.doas.SuitedForDAO;
import com.prime.asartaline.persistence.doas.WarDeeDAO;

/**
 * Created by yepyaesonetun on 7/6/18.
 **/
@Database(entities = {
        WarDeeVO.class, GeneralTasteVO.class, MatchWarDeeVO.class,
        MealShopVO.class, ShopVO.class, ReviewVO.class,
        ShopByDistanceVO.class, ShopByPopularityVO.class, SuitedForVO.class
}, version = 1, exportSchema = false)
public abstract class WarDeeDB extends RoomDatabase {

    private static final String DB_NAME = "A_SAR_TA_LINE.DB";
    private static WarDeeDB INSTANCE;

    public abstract WarDeeDAO foodDao();
    public abstract GeneralTasteDAO generalTasteDao();
    public abstract MatchWarDeeDAO matchWarDeeListDao();
    public abstract MealShopDAO mealShopDao();
    public abstract ShopDAO restaurantDao();
    public abstract ReviewsDAO reviewsDao();
    public abstract ShopByDistanceDAO shopByDistanceDao();
    public abstract ShopByPopularityDAO shopByPopularityDao();
    public abstract SuitedForDAO suitedForDao();

    public static WarDeeDB getDatabase(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, WarDeeDB.class, DB_NAME)
                    .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                    .build();
        }
        return INSTANCE;
    }
}
