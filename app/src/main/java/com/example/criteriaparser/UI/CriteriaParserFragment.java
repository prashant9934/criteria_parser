package com.example.criteriaparser.UI;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import com.example.criteriaparser.basicutils.BasicUtils;
import com.example.criteriaparser.databinding.ScanViewBinding;
import com.example.criteriaparser.model.ScanDataApiResponse;
import com.example.criteriaparser.viewmodel.CriteriaParserViewModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CriteriaParserFragment extends Fragment implements ScanViewAdapter.HandleOnScanClick {

    private static final String TAG = "exception";
    private CriteriaParserViewModel viewModel;
    private ScanViewBinding binding;
    private CompositeDisposable lifecycle;
    private ScanViewAdapter adapter;
    private SendDataToActivityOnClick sendDataToActivityOnClick;
    private Context context;

    public interface SendDataToActivityOnClick {
        void handleData(ScanDataApiResponse response);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        try {
            sendDataToActivityOnClick = (SendDataToActivityOnClick) context;
        } catch (ClassCastException exception) {
            throw new ClassCastException(exception.getLocalizedMessage());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.scan_view, container, false);
        viewModel = ViewModelProviders.of(this).get(CriteriaParserViewModel.class);
        lifecycle = new CompositeDisposable();
        init();
        initData();
        return binding.getRoot();
    }

    private void initData() {
        if (!BasicUtils.isNetworkAvailable(context)) {
            binding.scanViewRv.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.INVISIBLE);
            binding.noInternetView.setVisibility(View.VISIBLE);
        }
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
                        Log.d(TAG, e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void populateDataOnRecyclerView(List<ScanDataApiResponse> scanDataApiResponse) {
        binding.progressBar.setVisibility(View.GONE);
        adapter.setData(scanDataApiResponse);
    }

    private void init() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter = new ScanViewAdapter(this);
        binding.scanViewRv.setLayoutManager(layoutManager);
        binding.scanViewRv.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        lifecycle.clear();
    }

    @Override
    public void handleOnClick(ScanDataApiResponse response) {
        sendDataToActivityOnClick.handleData(response);
    }
}
