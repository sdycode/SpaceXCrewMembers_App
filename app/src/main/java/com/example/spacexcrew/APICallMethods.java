package com.example.spacexcrew;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICallMethods {

    @GET("crew/")
    Call<ArrayList<model>>  getAllData();
}
