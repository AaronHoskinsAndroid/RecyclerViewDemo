package examples.aaronhoskins.com.recyclerviewdemo;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {
    private String make;
    private String model;
    private String engine;
    private String transmission;

    public Car() {
    }

    public Car(String make, String model, String engine, String transmission) {
        this.make = make;
        this.model = model;
        this.engine = engine;
        this.transmission = transmission;
    }

    protected Car(Parcel in) {
        make = in.readString();
        model = in.readString();
        engine = in.readString();
        transmission = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(make);
        parcel.writeString(model);
        parcel.writeString(engine);
        parcel.writeString(transmission);
    }
}
