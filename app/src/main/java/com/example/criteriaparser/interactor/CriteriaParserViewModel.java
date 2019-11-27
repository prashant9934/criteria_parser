package com.example.criteriaparser.interactor;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.criteriaparser.model.ScanDataApiResponse;
import com.example.criteriaparser.repository.CriteriaParserRepository;

import java.util.List;

import io.reactivex.Observable;

public class CriteriaParserViewModel extends AndroidViewModel {

    private CriteriaParserRepository repository;
    public CriteriaParserViewModel(@NonNull Application application) {
        super(application);
        repository = new CriteriaParserRepository();
    }

    public Observable<List<ScanDataApiResponse>> getScanData(){
        return repository.getDataFromServer();
    }
}
