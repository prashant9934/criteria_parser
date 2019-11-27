package com.example.criteriaparser.repository;

import retrofit2.Retrofit;

public class CriteriaParserRepository {
    private Retrofit retrofit;

    private CriteriaParserRepository(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://mp-android-challenge.herokuapp.com/data")
                .build();
    }

}
