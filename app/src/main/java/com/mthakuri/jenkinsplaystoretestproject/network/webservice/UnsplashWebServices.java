package com.mthakuri.jenkinsplaystoretestproject.network.webservice;

import com.mthakuri.jenkinsplaystoretestproject.model.PictureModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by skhan4 on 11/28/2016.
 */

public interface UnsplashWebServices {

    String GET_ACCOUNTS = "photos?client_id=a38ae0a274649c2efb08cf3deb4b6f8fc52e14781c67266c610620b15f012666";

    @GET(GET_ACCOUNTS)
    Call<ArrayList<PictureModel>> fetchPictures();
}
