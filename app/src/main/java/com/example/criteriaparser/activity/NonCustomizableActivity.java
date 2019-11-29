package com.example.criteriaparser.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.criteriaparser.R;
import com.example.criteriaparser.UI.NonCustomizableVariableFragment;
import com.example.criteriaparser.constants.Constants;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class NonCustomizableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_customizable);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        List<String> values = new ArrayList<>();
        if (intent.hasExtra(Constants.Extras.NON_CUSTOMIZABLE_VALUE))
            values = Parcels.unwrap(intent.getParcelableExtra(Constants.Extras.NON_CUSTOMIZABLE_VALUE));
        NonCustomizableVariableFragment fragment = NonCustomizableVariableFragment.getInstance(values);
        getSupportFragmentManager().beginTransaction().replace(
                R.id.non_customizable_variable_fragment, fragment).commit();
    }
}
