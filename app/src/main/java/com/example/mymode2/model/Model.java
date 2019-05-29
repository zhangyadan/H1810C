package com.example.mymode2.model;

import com.example.mymode2.Apiservice;
import com.example.mymode2.beans.UserBeans;
import com.example.mymode2.callback.ICallback;

import java.security.GeneralSecurityException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 张亚丹 on 2019/5/29.
 */

public class Model implements IModel{
    @Override
    public void getData(final ICallback callback) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(Apiservice.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Apiservice apiservice = build.create(Apiservice.class);
        Observable<UserBeans> geturl = apiservice.geturl();
        geturl.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBeans>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBeans userBeans) {
                        callback.OnSuccess(userBeans);
                    }

                    @Override
                    public void onError(Throwable e) {
                       callback.OnFailed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
