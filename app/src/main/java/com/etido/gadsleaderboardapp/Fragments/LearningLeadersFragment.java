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
import com.etido.gadsleaderboardapp.Model.LearningHoursModel;
//import com.etido.gadsleaderboardapp.R;
import com.etido.gadsleaderboardapp.R;
import com.etido.gadsleaderboardapp.Service.LearningService;
import com.etido.gadsleaderboardapp.Service.RetrofitInstance;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    public class LearningLeadersFragment extends Fragment {
        private RecyclerView mRecyclerView;
        private LearningRecyclerAdapter mLearningRecyclerAdapter;
        private List<LearningHoursModel> mLearningHoursModels;
        //    private FragmentAdapter mAdapter;

        public LearningLeadersFragment() {

        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate (R.layout.learning_leaders_list, container, false);
            mRecyclerView = view.findViewById (R.id.learner_list);
            mLearningHoursModels = new ArrayList<> ();
            LinearLayoutManager layoutManager = new LinearLayoutManager (getActivity ());
            mRecyclerView.setLayoutManager (layoutManager);

            mLearningRecyclerAdapter = new LearningRecyclerAdapter (mLearningHoursModels, getContext ());
            mRecyclerView.setAdapter (mLearningRecyclerAdapter);

            return view;
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated (view, savedInstanceState);
            fetchLearningHours ();
        }

        public void fetchLearningHours() {
            LearningService learningService = RetrofitInstance.getRetrofitInstance ()
                    .create (LearningService.class);
            Call<List<LearningHoursModel>> call = learningService.getAllHours ();
            call.enqueue (new Callback<List<LearningHoursModel>> () {

                @Override
                public void onResponse(Call<List<LearningHoursModel>> call,
                                       Response<List<LearningHoursModel>> response) {
                   List<LearningHoursModel> mLearningHoursModels = response.body ();
                    mLearningRecyclerAdapter = new LearningRecyclerAdapter (mLearningHoursModels, getContext ());
                    mRecyclerView.setAdapter (mLearningRecyclerAdapter);
                }

                @Override
                public void onFailure(Call<List<LearningHoursModel>> call, Throwable t) {
//                Toast.makeText()
                }
            });
        }
//
    }






