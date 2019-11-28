package com.example.criteriaparser.repository;

import com.example.criteriaparser.apiservice.ScanApi;
import com.example.criteriaparser.constants.Constants;
import com.example.criteriaparser.model.ScanDataApiResponse;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CriteriaParserRepository {
    private Retrofit retrofit;
    public CriteriaParserRepository(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.NetworkConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public Observable<List<ScanDataApiResponse>> getDataFromServer(){
        return retrofit.create(ScanApi.class).getScanData();
    }
}
