package com.example.criteriaparser.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.criteriaparser.R;
import com.example.criteriaparser.UI.CustomizableVariableFragment;
import com.example.criteriaparser.constants.Constants;

public class CustomizableVariableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customizable_view);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        String title = "";
        if (intent.hasExtra(Constants.Extras.TITLE))
            title = intent.getExtras().getString(Constants.Extras.TITLE);
        CustomizableVariableFragment fragment = CustomizableVariableFragment.getInstance(
                intent.getExtras().getString(Constants.Extras.CUSTOMIZABLE_VALUE), title);
        getSupportFragmentManager().beginTransaction().replace(
                R.id.customizable_variable_fragment, fragment).commit();
    }
}
