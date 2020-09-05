package com.etido.gadsleaderboardapp.Activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.etido.gadsleaderboardapp.Model.PostDataModel;
import com.etido.gadsleaderboardapp.R;
import com.etido.gadsleaderboardapp.Service.ApiService;
import com.etido.gadsleaderboardapp.Service.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectSubmissionActivity extends AppCompatActivity {
    private ApiService mApiService;
    private static final String TAG = "Project";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_project_submission);

        ImageView backPress = findViewById (R.id.back_button);
        Button button = findViewById (R.id.project_submit_btn);

        backPress.setOnClickListener (view -> {
            Intent intent = new Intent (ProjectSubmissionActivity.this,
                    MainActivity.class);
            startActivity (intent);
        });

        button.setOnClickListener (view -> {
            showCustomDialog();
        });

    }

    private void showCustomDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder (
                ProjectSubmissionActivity.this);
        ViewGroup viewGroup = findViewById (R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.popup_window,
                viewGroup,false);
        builder.setView (dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        ImageView cancel = alertDialog.findViewById (R.id.cancel);
        Button yesButton = alertDialog.findViewById (R.id.yes_button);

        cancel.setOnClickListener (view -> {
            alertDialog.dismiss ();
        });

        yesButton.setOnClickListener (view -> {
            alertDialog.dismiss ();
            submitProject();

        });



    }

    private void submitProject() {
        final EditText firstName = findViewById (R.id.first_name);
        final EditText lastName = findViewById (R.id.last_name);
        final EditText email = findViewById (R.id.email_address);
        final EditText gitHubLink = findViewById (R.id.github_link);

        mApiService = ApiUtils.getAPIService ();
        String mFirstName = firstName.getText ().toString().trim();
        String mLastName = lastName.getText ().toString().trim();
        String mEmail = email.getText ().toString().trim();
        String mGitHubLink = gitHubLink.getText ().toString().trim();

        if (!TextUtils.isEmpty (mFirstName) && !TextUtils.isEmpty (mLastName) &&
                !TextUtils.isEmpty (mEmail) && !TextUtils.isEmpty (mGitHubLink)){
            sendPost(mFirstName, mLastName, mEmail, mGitHubLink);
        }

    }

    private void sendPost(String mFirstName, String mLastName,
                          String mEmail, String mGitHubLink) {
        mApiService.savePost (mFirstName, mLastName, mEmail, mGitHubLink)
                    .enqueue (new Callback<PostDataModel> () {
                        @Override
                        public void onResponse(Call<PostDataModel> call, Response<PostDataModel> response) {
                            if(response.isSuccessful ()){
                                showSuccessMessage();
                                Log.i (TAG, "Submission was Successful");
                                Intent intent = new Intent(getApplicationContext(), ProjectSubmissionActivity.class);
                                startActivity(intent);
                            }
                        }
                        @Override
                        public void onFailure(Call<PostDataModel> call, Throwable t) {
                                showFailureMessage();
                            Log.e("Project submission", "not successful");
                        }
                    });
    }

    private void showSuccessMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder (
                ProjectSubmissionActivity.this);
        ViewGroup viewGroup = findViewById (R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.popup_submit_success,
                viewGroup,false);
        builder.setView (dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showFailureMessage() {
        AlertDialog.Builder builders = new AlertDialog.Builder (
                ProjectSubmissionActivity.this);
        ViewGroup viewGroup = findViewById (R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.popup_submit_failure,
                viewGroup,false);
        builders.setView (dialogView);
        AlertDialog alertDialog = builders.create();
        alertDialog.show();
    }


}
