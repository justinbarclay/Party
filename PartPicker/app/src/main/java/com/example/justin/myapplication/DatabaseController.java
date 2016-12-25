package com.example.justin.myapplication;

import android.provider.ContactsContract;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Justin on 2016-12-25.
 */

public class DatabaseController {
    String test = "http://productdb.dev/";
    String dev = "https://partsdb.herokuapp.com/";
    APIService restService;
    DatabaseController(){
        restService = new Retrofit.Builder().baseUrl(dev).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(APIService.class);
    }

    public void getProduct(String id){
        restService.getProduct(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Part>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("Completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.toString());
                    }

                    @Override
                    public void onNext(Part part) {
                        System.out.println("Part: " + part.toString());
                    }
                });
    }
}
