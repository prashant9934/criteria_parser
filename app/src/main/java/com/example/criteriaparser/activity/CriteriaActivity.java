package com.example.criteriaparser.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.criteriaparser.R;
import com.example.criteriaparser.UI.CreteriaDetailFragment;
import com.example.criteriaparser.adapter.ScanViewDetailAdapter;
import com.example.criteriaparser.constants.Constants;
import com.example.criteriaparser.model.ScanDataApiResponse;

import org.parceler.Parcels;

import java.util.List;

public class CriteriaActivity extends AppCompatActivity implements ScanViewDetailAdapter.HandleOnCustomizableCriteriaClick {

    public static final int BASE_INDEX = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criteria);
        getSupportActionBar().hide();
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

    @Override
    public void cutomizableCriteriaCliked(List<String> values, String title, boolean isCustomizable) {
        if (isCustomizable) {
            Intent intent = new Intent(this, CustomizableVariableActivity.class);
            intent.putExtra(Constants.Extras.CUSTOMIZABLE_VALUE, values.get(BASE_INDEX));
            intent.putExtra(Constants.Extras.TITLE, title);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, NonCustomizableVariableActivity.class);
            intent.putExtra(Constants.Extras.NON_CUSTOMIZABLE_VALUE, Parcels.wrap(values));
            startActivity(intent);
        }
    }
}
