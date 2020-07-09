package com.barefooted.retrofit;

import android.widget.EditText;

import com.barefooted.model.Profile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface SuperHeroApi {


    String BASE_URL = "https://superheroapi.com/api/1004555809958987/search/";



    //Non static endpoint
    @GET("{hero_name}")
    Call<Profile> getData(@Path("hero_name") String hero_name);


    //static endpoint
   // @GET("Superman")
  // Call<Profile> getData();
}
