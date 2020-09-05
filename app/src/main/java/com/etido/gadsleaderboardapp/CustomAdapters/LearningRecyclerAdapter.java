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

import com.etido.gadsleaderboardapp.Model.LearningHoursModel;
import com.etido.gadsleaderboardapp.R;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LearningRecyclerAdapter extends RecyclerView.Adapter<LearningRecyclerAdapter.LearningViewHolder> {
    private List<LearningHoursModel> mLearningHoursModels;
    private Context context;
    private LayoutInflater mLayoutInflater;


    public LearningRecyclerAdapter(List<LearningHoursModel> pLearningHoursModels, Context context) {
       this.context = context;
        this.mLearningHoursModels = pLearningHoursModels;
//        mLayoutInflater = LayoutInflater.from (context);
    }


    @NonNull
    @Override
    public LearningViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        mLayoutInflater = LayoutInflater.from (viewGroup.getContext ());
        View view = mLayoutInflater.inflate (R.layout.learning_card, viewGroup, false);
        return new LearningViewHolder (view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull LearningRecyclerAdapter.LearningViewHolder holder, int position) {
        holder.fullName.setText (mLearningHoursModels.get (position).getName ());
        holder.hoursCountry.setText (new StringBuilder ().append (mLearningHoursModels.get (position).getHours ()).append (", ")
                .append (mLearningHoursModels.get (position).getCountry ()).toString ());

        Picasso.Builder builder = new Picasso.Builder (context);
        builder.downloader (new OkHttp3Downloader (context));
        builder.build ().load (mLearningHoursModels.get (position).getBadgeUrl ())
                .placeholder ((R.drawable.top_learner))
                .error (R.drawable.top_learner)
                .into (holder.learningBadge);
//

    }

    @Override
    public int getItemCount() {
        return mLearningHoursModels.size ();
    }

   public class LearningViewHolder extends RecyclerView.ViewHolder {
//            public final View mView;

        private TextView fullName;
       private TextView hoursCountry;
       private ImageView learningBadge;


        public LearningViewHolder(@NonNull View itemView) {
            super (itemView);
//                mView = itemView;

            fullName = (TextView) itemView.findViewById (R.id.name);
            hoursCountry = (TextView) itemView.findViewById (R.id.score_country);
            learningBadge = (ImageView) itemView.findViewById (R.id.learning_badge);
        }
    }
}
