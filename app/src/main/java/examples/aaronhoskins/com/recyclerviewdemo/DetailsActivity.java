package examples.aaronhoskins.com.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    TextView tvMake;
    TextView tvModel;
    TextView tvEngine;
    TextView tvTransmission;
    ListView lvSampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //Get data from calling intent
        Intent passedIntent = getIntent();
        Car passedCar = passedIntent.getExtras().getParcelable("car");

        bindViews();
        populateViews(passedCar);
        initListView();
    }

    private void bindViews() {
        //bind the views
        tvMake = findViewById(R.id.tvMake);
        tvModel = findViewById(R.id.tvModel);
        tvEngine = findViewById(R.id.tvEngine);
        tvTransmission = findViewById(R.id.tvTransmission);
        lvSampleList = findViewById(R.id.lvSampleList);
    }

    private void populateViews(Car passedCar) {
        //populate the views
        tvMake.setText(passedCar.getMake());
        tvModel.setText(passedCar.getModel());
        tvEngine.setText(passedCar.getEngine());
        tvTransmission.setText(passedCar.getTransmission());
    }

    private void initListView() {
        final ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Value 1");
        stringArrayList.add("Value 2");
        stringArrayList.add("Value 3");
        stringArrayList.add("Value 4");
        stringArrayList.add("Value 5");
        stringArrayList.add("Value 6");
        stringArrayList.add("Value 7");

        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringArrayList);
        lvSampleList.setAdapter(arrayAdapter);
        lvSampleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast
                        .makeText(DetailsActivity.this, stringArrayList.get(position), Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
