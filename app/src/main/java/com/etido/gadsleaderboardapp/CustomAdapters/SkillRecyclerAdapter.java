package com.etido.gadsleaderboardapp.CustomAdapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.etido.gadsleaderboardapp.Model.SkilliqModel;
import com.etido.gadsleaderboardapp.R;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SkillRecyclerAdapter extends RecyclerView.Adapter<SkillRecyclerAdapter.SkillViewHolder> {
    private List<SkilliqModel> mSkilliqModels;
    private Context context;
    private LayoutInflater mLayoutInflater;


    public SkillRecyclerAdapter(List<SkilliqModel> pLearningHoursModels, Context context) {
        this.context = context;
        this.mSkilliqModels = pLearningHoursModels;
//        mLayoutInflater = LayoutInflater.from (context);
    }


    @NonNull
    @Override
    public SkillRecyclerAdapter.SkillViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        mLayoutInflater = LayoutInflater.from (viewGroup.getContext ());
        View view = mLayoutInflater.inflate (R.layout.skill_card, viewGroup, false);
        return new SkillViewHolder (view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SkillViewHolder holder, int position) {
        holder.fullName.setText (mSkilliqModels.get (position).getName ());
        holder.scoreCountry.setText (new StringBuilder ().append (mSkilliqModels.get (position).getScore ()).append (", ")
                .append (mSkilliqModels.get (position).getCountry ()).toString ());

        Picasso.Builder builder = new Picasso.Builder (context);
        builder.downloader (new OkHttp3Downloader (context));
        builder.build ().load (mSkilliqModels.get (position).getBadgeUrl ())
                .placeholder ((R.drawable.skill_iq_trimmed))
                .error (R.drawable.skill_iq_trimmed)
                .into (holder.skillBadge);
//

    }

    @Override
    public int getItemCount() {
        return mSkilliqModels.size ();
    }

    public class SkillViewHolder extends RecyclerView.ViewHolder {

        TextView fullName;
        TextView scoreCountry;
        ImageView skillBadge;


        public SkillViewHolder(@NonNull View itemView) {
            super (itemView);

            fullName = (TextView) itemView.findViewById (R.id.name);
            scoreCountry = (TextView) itemView.findViewById (R.id.score_country);
            skillBadge = (ImageView) itemView.findViewById (R.id.skill_badge);
        }
    }
}
