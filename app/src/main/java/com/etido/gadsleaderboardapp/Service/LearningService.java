package com.etido.gadsleaderboardapp.Service;


import com.etido.gadsleaderboardapp.Model.LearningHoursModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningService {
    @GET("/api/hours")
    Call<List<LearningHoursModel>> getAllHours();
}

