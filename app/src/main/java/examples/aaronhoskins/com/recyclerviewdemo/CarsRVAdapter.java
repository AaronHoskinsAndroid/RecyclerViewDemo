package examples.aaronhoskins.com.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarsRVAdapter extends RecyclerView.Adapter<CarsRVAdapter.ViewHolder> {
    private ArrayList<Car> carArrayList;

    public CarsRVAdapter(ArrayList<Car> carArrayList) {
        this.carArrayList = carArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedItem = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.car_item, parent, false);
        return new ViewHolder(inflatedItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car currentCar = carArrayList.get(position);
        holder.populateValues(currentCar);
        //holder.tvModel.setText(currentCar.getModel());
        //holder.tvMake.setText(currentCar.getMake());
        //holder.setItemCar(currentCar);
    }

    @Override
    public int getItemCount() {
        return carArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvMake;
        private TextView tvModel;
        private Car itemCar;

        public ViewHolder(View itemView) {
            super(itemView);
            tvMake = itemView.findViewById(R.id.tvMake);
            tvModel = itemView.findViewById(R.id.tvModel);
            itemView.setOnClickListener(this);
        }

        public void setItemCar(Car itemCar) {
            this.itemCar = itemCar;
        }

        public void populateValues(Car car) {
            tvMake.setText(car.getMake());
            tvModel.setText(car.getModel());
            setItemCar(car);
        }

        @Override
        public void onClick(View view) {
            Intent detailsIntent = new Intent(view.getContext(), DetailsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("car", itemCar);
            detailsIntent.putExtras(bundle);
            view.getContext().startActivity(detailsIntent);
        }
    }
}
