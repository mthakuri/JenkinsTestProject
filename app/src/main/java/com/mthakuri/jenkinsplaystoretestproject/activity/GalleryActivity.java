package com.mthakuri.jenkinsplaystoretestproject.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mthakuri.jenkinsplaystoretestproject.R;
import com.mthakuri.jenkinsplaystoretestproject.adapter.GalleryAdapter;
import com.mthakuri.jenkinsplaystoretestproject.model.PictureModel;
import com.mthakuri.jenkinsplaystoretestproject.network.RequestController;
import com.mthakuri.jenkinsplaystoretestproject.network.webservice.UnsplashWebServices;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mthakuri on 9/11/2017.
 */

public class GalleryActivity extends AppCompatActivity {

    GalleryAdapter adapter;
    ProgressBar loadingProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        fetchPictures();
    }


    private void init() {
        loadingProgressBar = findViewById(R.id.pb_loading);
        RecyclerView recyclerView = findViewById(R.id.rv_gallery);
        adapter = new GalleryAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void updateList(ArrayList<PictureModel> pictures) {
        adapter.addAll(pictures);
        adapter.notifyDataSetChanged();
        if (adapter.getItemCount() > 0)
            loadingProgressBar.setVisibility(View.GONE);
    }

    private void fetchPictures() {
        Call<ArrayList<PictureModel>> pictures = RequestController
                .createService(UnsplashWebServices.class).fetchPictures();
        pictures.enqueue(new Callback<ArrayList<PictureModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<PictureModel>> call,
                                   @NonNull Response<ArrayList<PictureModel>> response) {
                if (response.isSuccessful()) {
                    ArrayList<PictureModel> pictures = response.body();
                    if (!isFinishing()) {
                        updateList(pictures);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<PictureModel>> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), "Unable to complete the request",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
