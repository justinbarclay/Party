package com.example.justin.myapplication;

import android.app.Activity;
import android.provider.ContactsContract;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Justin on 2016-12-25.
 */

public class PartsController {
    PartWatcher activity;
    APIService database;

    PartsController(PartWatcher activity){
        this.activity = activity;
        database = new DatabaseController().getService();
    }

    public void getPart(String id) {
        database.getProduct(id)
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
                        activity.setPart(part);
                    }
                });
    }

    public void getAllParts(){
        database.getProducts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<HashMap<String,String>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.toString());
                    }

                    @Override
                    public void onNext(ArrayList<HashMap<String,String>> parts) {
                        System.out.println(parts);
                        activity.setPartList(parts);
                    }
                });
    }

}
