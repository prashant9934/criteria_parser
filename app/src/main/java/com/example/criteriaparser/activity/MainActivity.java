package com.example.criteriaparser.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.example.criteriaparser.R;
import com.example.criteriaparser.UI.CriteriaParserFragment;
import com.example.criteriaparser.constants.Constants;
import com.example.criteriaparser.model.ScanDataApiResponse;

import org.parceler.Parcels;

public class MainActivity extends AppCompatActivity implements
        CriteriaParserFragment.SendDataToActivityOnClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void handleData(ScanDataApiResponse response) {
        Intent intent = new Intent(this, CriteriaActivity.class);
        intent.putExtra(Constants.Extras.CRITERIUM_SCAN_DATA, Parcels.wrap(response));
        startActivity(intent);
    }
}
