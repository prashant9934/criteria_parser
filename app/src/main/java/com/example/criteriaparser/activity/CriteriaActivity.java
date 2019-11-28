package com.example.criteriaparser.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.criteriaparser.R;
import com.example.criteriaparser.UI.CreteriaDetailFragment;
import com.example.criteriaparser.constants.Constants;
import com.example.criteriaparser.model.ScanDataApiResponse;

import org.parceler.Parcels;

public class CriteriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criteria);
        Intent intent = getIntent();
        ScanDataApiResponse data = new ScanDataApiResponse();
        if (intent.hasExtra(Constants.Extras.CRITERIUM_SCAN_DATA)) {
            data = Parcels.unwrap(intent.getExtras().getParcelable(Constants.Extras.CRITERIUM_SCAN_DATA));
        }
        CreteriaDetailFragment detailFragment = new CreteriaDetailFragment();
        detailFragment.setScanData(data);
        getSupportFragmentManager().beginTransaction().replace(R.id.scan_detail_fragment,
                detailFragment).commit();
    }
}
