package com.example.justin.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;
/**
 * Created by Justin on 2016-12-25.
 */

public interface APIService {
    @GET("products/{id}")
    Observable<Part> getProduct(@Path("id") String id);

    @GET("products")
    Observable<List<Part>> getProducts();
}
