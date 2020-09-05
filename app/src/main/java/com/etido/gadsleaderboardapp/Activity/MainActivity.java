package com.etido.gadsleaderboardapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.etido.gadsleaderboardapp.CustomAdapters.FragmentAdapter;
//import com.etido.gadsleaderboardapp.Adapters.LearningRecyclerAdapter;
import com.etido.gadsleaderboardapp.Model.LearningHoursModel;
//import com.etido.gadsleaderboardapp.R;
import com.etido.gadsleaderboardapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout mTabLayout;
    ViewPager mViewPager;
    TabItem mLearningTab;
    TabItem mSkilliqTab;
//    LearningRecyclerAdapter mLearningRecyclerAdapter;
    List<LearningHoursModel> mLearningHoursModels;

    private RecyclerView mRecyclerView;
    private FragmentAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        mTabLayout = findViewById (R.id.tabLayout);
        mLearningTab = findViewById (R.id.learner_tab);
        mSkilliqTab = findViewById (R.id.skill_tab);

        mViewPager = findViewById (R.id.view_page);

        mLearningHoursModels = new ArrayList<>();

        mAdapter = new FragmentAdapter (this,
                getSupportFragmentManager(),
                mTabLayout.getTabCount());

        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition () == 0){
                    mAdapter.notifyDataSetChanged ();
                } else if (tab.getPosition () == 1){
                    mAdapter.notifyDataSetChanged ();
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        Button button = findViewById (R.id.submit);
        button.setOnClickListener(v -> {
            Intent intent = new Intent (MainActivity.this, ProjectSubmissionActivity.class);
            startActivity (intent);
        });


    }

//



}
