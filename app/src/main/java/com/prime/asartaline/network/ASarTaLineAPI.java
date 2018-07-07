package com.prime.asartaline.network;

import com.prime.asartaline.network.responses.GetMealShopResponse;
import com.prime.asartaline.network.responses.GetWarteeResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by yepyaesonetun on 7/2/18.
 **/

public interface ASarTaLineAPI {

    @FormUrlEncoded
    @POST("v1/GetWarDee.php")
    Observable<GetWarteeResponse> loadWarDees(
            @Field("access_token") String accessToken
    );

    @FormUrlEncoded
    @POST("v1/GetMealShop.php")
    Observable<GetMealShopResponse> loadMealShops(
            @Field("access_token") String accessToken
    );
}
