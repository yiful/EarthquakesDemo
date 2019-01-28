package com.example.yifu.earthquakesdemo.network;

import com.example.yifu.earthquakesdemo.model.EarthquakesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    //summary call
    @GET("all_hour.geojson")
    Call<EarthquakesResponse> getEarthQuakes();
}
