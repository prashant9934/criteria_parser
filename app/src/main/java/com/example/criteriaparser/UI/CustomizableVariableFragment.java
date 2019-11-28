package com.example.criteriaparser.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.criteriaparser.R;
import com.example.criteriaparser.constants.Constants;
import com.example.criteriaparser.databinding.CustomizableViewFragmentLayoutBinding;

public class CustomizableVariableFragment extends Fragment {

    private static final String VALUE = "value";
    private CustomizableViewFragmentLayoutBinding binding;
    private String value;
    private String title;

    public CustomizableVariableFragment(Bundle extras) {
        this.value = extras.getString(VALUE);
        this.title = extras.getString(Constants.Extras.TITLE);
    }

    public static CustomizableVariableFragment getInstance(String value, String title) {
        Bundle extras = new Bundle();
        extras.putString(VALUE, value);
        extras.putString(Constants.Extras.TITLE, title);
        return new CustomizableVariableFragment(extras);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.customizable_view_fragment_layout, container, false);
        init();
        return binding.getRoot();
    }

    private void init() {
        binding.header.setText(title);
        binding.editText.setText(String.valueOf(value));
    }
}
