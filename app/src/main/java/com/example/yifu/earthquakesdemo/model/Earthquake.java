package com.example.yifu.earthquakesdemo.model;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

public class Earthquake implements Parcelable{
    private double magnitude;
    private long time;
    private String place;
    private String location;

    public Earthquake(double magnitude, long time, String place, String location) {
        this.magnitude = magnitude;
        this.place = place;
        this.time = time;
        this.location = location;
    }

    protected Earthquake(Parcel in) {
        magnitude = in.readDouble();
        place = in.readString();
        time = in.readLong();
        location = in.readString();
    }

    public long getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getLocation() {
        return location;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public static final Creator<Earthquake> CREATOR = new Creator<Earthquake>() {
        @Override
        public Earthquake createFromParcel(Parcel in) {
            return new Earthquake(in);
        }

        @Override
        public Earthquake[] newArray(int size) {
            return new Earthquake[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(magnitude);
        parcel.writeString(place);
        parcel.writeLong(time);
        parcel.writeString(location);
    }
}
