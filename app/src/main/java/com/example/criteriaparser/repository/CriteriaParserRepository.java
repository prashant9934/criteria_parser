package com.example.criteriaparser.repository;

import com.example.criteriaparser.model.ScanDataApiResponse;
import com.example.criteriaparser.service.RetrofitProvider;
import com.example.criteriaparser.service.ScanApi;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class CriteriaParserRepository {
    private Retrofit retrofit;

    public CriteriaParserRepository() {
        retrofit = RetrofitProvider.getInstance();
    }

    public Observable<List<ScanDataApiResponse>> getDataFromServer() {
        return retrofit.create(ScanApi.class).getScanData();
    }
}
