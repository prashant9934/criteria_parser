package com.example.criteriaparser.UI;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.criteriaparser.R;
import com.example.criteriaparser.adapter.ScanViewDetailAdapter;
import com.example.criteriaparser.constants.Constants;
import com.example.criteriaparser.databinding.CriteriaDetailViewBinding;
import com.example.criteriaparser.model.ScanDataApiResponse;

import java.util.Objects;

public class CreteriaDetailFragment extends Fragment {

    public static final int BEGIN_INDEX = 0;
    private CriteriaDetailViewBinding binding;
    private ScanDataApiResponse data;
    private ScanViewDetailAdapter.HandleOnCustomizableCriteriaClick handleOnCustomizableCriteriaClick;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            handleOnCustomizableCriteriaClick = (ScanViewDetailAdapter.HandleOnCustomizableCriteriaClick) context;
        } catch (ClassCastException exception) {
            throw new ClassCastException(exception.getLocalizedMessage());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.criteria_detail_view, container, false);
        init();
        return binding.getRoot();
    }

    private void init() {
        initData();
        initRv();
    }

    private void initRv() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        ScanViewDetailAdapter adapter = new ScanViewDetailAdapter(getContext(), handleOnCustomizableCriteriaClick);
        binding.criteriaDetailRV.setLayoutManager(layoutManager);
        binding.criteriaDetailRV.setAdapter(adapter);
        adapter.setTitleValue(data.name.substring(BEGIN_INDEX, data.name.indexOf(Constants.Extras.SPACE)));
        adapter.setData(data.criteria);
    }

    private void initData() {
        binding.criteria.layout.setBackgroundColor(getResources().getColor(R.color.sky_blue,
                Objects.requireNonNull(getContext()).getTheme()));
        binding.criteria.name.setText(data.name);
        binding.criteria.tag.setText(data.tag);
        binding.criteria.tag.setTextColor(Color.parseColor(data.color));
        binding.criteria.dottedView.setVisibility(View.GONE);
    }

    public void setScanData(ScanDataApiResponse data) {
        this.data = data;
    }
}
