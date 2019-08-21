package examples.aaronhoskins.com.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instance for recycler view
        recyclerView = findViewById(R.id.rvCars);
        //Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Adapter
        ArrayList<Car> carListForRV = getCarList();
        CarsRVAdapter carsRVAdapter = new CarsRVAdapter(carListForRV);
        recyclerView.setAdapter(carsRVAdapter);
    }

    private ArrayList<Car> getCarList() {
        ArrayList<Car> returnList = new ArrayList<>();
        returnList.add(new Car("BMW", "528i", "Inline 6", "Auto"));
        returnList.add(new Car("Honda", "Accord", "H22A1", "Manual"));
        returnList.add(new Car("Toyota", "Camary", "V6", "Auto"));
        returnList.add(new Car("Nissan", "Maxium", "V6", "Manual"));
        returnList.add(new Car("Audi", "Q4", "Inline 6", "Auto"));
        returnList.add(new Car("Chevy", "S10", "Inline 6", "Manual"));
        returnList.add(new Car("Ford", "F150", "V8", "Auto"));
        returnList.add(new Car("Dodge", "Ram", "HEMI", "Manual"));
        returnList.add(new Car("Honda", "Civic", "K20A1", "Manual"));

        return returnList;
    }
}
