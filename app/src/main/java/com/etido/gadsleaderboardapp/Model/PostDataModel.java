package com.etido.gadsleaderboardapp.Model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostDataModel {
    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("gitHubLink")
    @Expose
    private String gitHubLink;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String mFirstName) {
        firstName = mFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String mLastName) {
        lastName = mLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mEmail) {
        email = mEmail;
    }

    public String getGitHubLink() {
        return gitHubLink;
    }

    public void setGitHubLink(String mGitHubLink) {
        gitHubLink = mGitHubLink;
    }

    @NonNull
    @Override
    public String toString() {
        return "Post{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email=" + email +
                ", gitHubLink=" + gitHubLink +
                '}';
    }

}
