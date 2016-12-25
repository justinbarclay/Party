package com.example.justin.myapplication;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;
import rx.Observable;

/**
 * Created by Justin on 2016-12-25.
 */

public class PartController {
    Observable<List<Part>> parts;
    DatabaseController database;

    PartController(){
        database = new DatabaseController();
    }

    public void getProduct(String id){
        database.getProduct(id);
    }


}
