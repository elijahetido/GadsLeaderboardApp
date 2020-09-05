package com.etido.gadsleaderboardapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.etido.gadsleaderboardapp.Adapters.LearningRecyclerAdapter;
import com.etido.gadsleaderboardapp.CustomAdapters.LearningRecyclerAdapter;
import com.etido.gadsleaderboardapp.CustomAdapters.SkillRecyclerAdapter;
import com.etido.gadsleaderboardapp.Model.LearningHoursModel;
//import com.etido.gadsleaderboardapp.R;
import com.etido.gadsleaderboardapp.Model.SkilliqModel;
import com.etido.gadsleaderboardapp.R;
import com.etido.gadsleaderboardapp.Service.LearningService;
import com.etido.gadsleaderboardapp.Service.RetrofitInstance;
import com.etido.gadsleaderboardapp.Service.SkilliqService;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillLeadersFragment extends Fragment {
    RecyclerView sRecyclerView;
    SkillRecyclerAdapter mSkillRecyclerAdapter;
    List<SkilliqModel> mSkilliqModels;

    //    private FragmentAdapter mAdapter;

    public SkillLeadersFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.skill_leaders_list, container, false);
        sRecyclerView = view.findViewById (R.id.skill_list);
        mSkilliqModels = new ArrayList<> ();
        LinearLayoutManager layoutManager = new LinearLayoutManager (getActivity ());
        sRecyclerView.setLayoutManager (layoutManager);
        mSkillRecyclerAdapter = new SkillRecyclerAdapter (mSkilliqModels, getContext ());
        sRecyclerView.setAdapter (mSkillRecyclerAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        fetchSkillScore ();
    }

    public void fetchSkillScore() {
        SkilliqService skilliqService = RetrofitInstance.getRetrofitInstance ()
                .create (SkilliqService.class);
        Call<List<SkilliqModel>> call = skilliqService.getAllScore ();
        call.enqueue (new Callback<List<SkilliqModel>> () {

            @Override
            public void onResponse(Call<List<SkilliqModel>> call,
                                   Response<List<SkilliqModel>> response) {
                List<SkilliqModel> mSkilliqModels = response.body ();
                mSkillRecyclerAdapter = new SkillRecyclerAdapter (mSkilliqModels, getContext ());
                sRecyclerView.setAdapter (mSkillRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<SkilliqModel>> call, Throwable t) {
//
        }
        });
    }

}
