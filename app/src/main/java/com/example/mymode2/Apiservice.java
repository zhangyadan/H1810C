package com.example.mymode2;

import com.example.mymode2.beans.UserBeans;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 张亚丹 on 2019/5/29.
 */

public interface Apiservice {
    // https://www.wanandroid.com/article/list/0/json
    String url = "https://www.wanandroid.com/";

    @GET("article/list/0/json")
    Observable<UserBeans> geturl();
}
