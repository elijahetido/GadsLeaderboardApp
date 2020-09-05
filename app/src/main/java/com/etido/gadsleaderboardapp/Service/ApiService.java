package com.etido.gadsleaderboardapp.Service;

import com.etido.gadsleaderboardapp.Model.PostDataModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded

    Call<PostDataModel> savePost(@Field("entry.1877115667") String firstName,
                                 @Field("entry.2006916086") String lastName,
                                 @Field("entry.1824927963") String email,
                                 @Field("entry.284483984") String gitHubLink);


}

