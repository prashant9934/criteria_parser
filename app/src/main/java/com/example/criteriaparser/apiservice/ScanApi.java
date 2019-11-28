package com.example.criteriaparser.apiservice;

import com.example.criteriaparser.model.ScanDataApiResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ScanApi {

    @GET("data")
    Observable<List<ScanDataApiResponse>> getScanData();
}
