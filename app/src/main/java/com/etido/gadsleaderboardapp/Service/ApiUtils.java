package com.etido.gadsleaderboardapp.Service;

public class ApiUtils {

    private ApiUtils() {}

    private static final String BASE_URL = "https://docs.google.com/forms/d/e/";

    public static ApiService getAPIService() {
        return RetrofitPostClient.getRetrofitInstance(BASE_URL).create(ApiService.class);
    }
}
