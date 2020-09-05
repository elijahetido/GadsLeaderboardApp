package com.etido.gadsleaderboardapp.CustomAdapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.etido.gadsleaderboardapp.Fragments.LearningLeadersFragment;
import com.etido.gadsleaderboardapp.Fragments.SkillLeadersFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private int totalTabs;

    public FragmentAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        mContext = context;
        this.totalTabs = totalTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                LearningLeadersFragment learning = new LearningLeadersFragment ();
                return learning;
            case 1:
               SkillLeadersFragment skill = new SkillLeadersFragment ();
                return skill;
            default:
                return new LearningLeadersFragment ();
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}