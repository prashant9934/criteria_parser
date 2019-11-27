package com.example.criteriaparser.repository;

import com.example.criteriaparser.api.ScanApi;
import com.example.criteriaparser.model.ScanDataApiResponse;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CriteriaParserRepository {
    private static final String BASE_URL = "https://mp-android-challenge.herokuapp.com/";
    private Retrofit retrofit;
    public CriteriaParserRepository(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Observable<List<ScanDataApiResponse>> getDataFromServer(){
        return retrofit.create(ScanApi.class).getScanData();
    }
}
