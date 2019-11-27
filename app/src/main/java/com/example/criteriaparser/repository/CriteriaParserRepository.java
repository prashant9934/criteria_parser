package com.example.criteriaparser.repository;

import com.example.criteriaparser.api.ScanApi;
import com.example.criteriaparser.model.ScanDataApiResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class CriteriaParserRepository {
    private Retrofit retrofit;

    public CriteriaParserRepository(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://mp-android-challenge.herokuapp.com/data")
                .build();
    }

    public Observable<List<ScanDataApiResponse>> getDataFromServer(){
        return retrofit.create(ScanApi.class).getScanData();
    }

}
