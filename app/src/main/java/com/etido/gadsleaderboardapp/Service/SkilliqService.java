package com.etido.gadsleaderboardapp.Service;


import com.etido.gadsleaderboardapp.Model.LearningHoursModel;
import com.etido.gadsleaderboardapp.Model.SkilliqModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SkilliqService {
    @GET("/api/skilliq")
    Call<List<SkilliqModel>> getAllScore();
}
