package com.example.criteriaparser.UI;

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
import com.example.criteriaparser.adapter.NonCustomizableViewAdapter;
import com.example.criteriaparser.constants.Constants;
import com.example.criteriaparser.databinding.ScanViewBinding;

import org.parceler.Parcels;

import java.util.List;

public class NonCustomizableVariableFragment extends Fragment {

    private ScanViewBinding binding;
    private List<Double> values;

    public NonCustomizableVariableFragment(Bundle extras) {
        values = Parcels.unwrap(extras.getParcelable(Constants.Extras.NON_CUSTOMIZABLE_VALUE));
    }

    public static NonCustomizableVariableFragment getInstance(List<Double> values) {
        Bundle extras = new Bundle();
        extras.putParcelable(Constants.Extras.NON_CUSTOMIZABLE_VALUE, Parcels.wrap(values));
        return new NonCustomizableVariableFragment(extras);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.scan_view, container, false);
        init();
        return binding.getRoot();
    }

    private void init() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        NonCustomizableViewAdapter adapter = new NonCustomizableViewAdapter(values);
        binding.scanViewRv.setLayoutManager(layoutManager);
        binding.scanViewRv.setAdapter(adapter);
        binding.progressBar.setVisibility(View.GONE);
    }
}
