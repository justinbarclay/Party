package com.example.justin.myapplication;

import android.app.Activity;
import android.provider.ContactsContract;
import android.view.View;

import java.util.ArrayList;
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

    public void getParts(String id) {
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

}
