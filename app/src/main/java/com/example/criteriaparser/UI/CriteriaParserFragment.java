package com.example.criteriaparser.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.criteriaparser.R;
import com.example.criteriaparser.adapter.ScanViewAdapter;
import com.example.criteriaparser.databinding.ScanViewBinding;
import com.example.criteriaparser.interactor.CriteriaParserViewModel;
import com.example.criteriaparser.model.ScanDataApiResponse;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CriteriaParserFragment extends Fragment {

    private CriteriaParserViewModel viewModel;
    private ScanViewBinding binding;
    private CompositeDisposable lifecycle;
    private ScanViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.scan_view, container, true);
        viewModel = ViewModelProviders.of(this).get(CriteriaParserViewModel.class);
        init();
        initData();
        return binding.getRoot();
    }

    private void initData() {
        viewModel.getScanData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ScanDataApiResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        lifecycle.add(d);
                    }

                    @Override
                    public void onNext(List<ScanDataApiResponse> scanDataApiResponses) {
                        populateDataOnRecyclerView(scanDataApiResponses);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void populateDataOnRecyclerView(List<ScanDataApiResponse> scanDataApiResponse) {
        adapter.setData(scanDataApiResponse);
    }

    private void init() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter = new ScanViewAdapter();
        binding.scanViewRv.setLayoutManager(layoutManager);
        binding.scanViewRv.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        lifecycle.clear();
    }
}
