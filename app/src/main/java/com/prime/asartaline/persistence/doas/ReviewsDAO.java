package com.prime.asartaline.persistence.doas;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.prime.asartaline.data.vo.ReviewVO;
import com.prime.asartaline.data.vo.WarDeeVO;

import java.util.List;

/**
 * Created by yepyaesonetun on 7/7/18.
 **/

@Dao
public interface ReviewsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertReview(ReviewVO... reviewsVOs);

    @Query("SELECT * FROM reviews")
    List<ReviewVO> getAllReviews();

    @Query("SELECT * FROM reviews WHERE review_id= :reviewId")
    ReviewVO getReviewById(String reviewId);

    @Query("SELECT * FROM reviews WHERE review_id= :reviewId")
    LiveData<ReviewVO> getReviewByIdLD(String reviewId);
}
