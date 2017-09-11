package com.mthakuri.jenkinsplaystoretestproject.network;

import com.mthakuri.jenkinsplaystoretestproject.base.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mthakuri on 9/11/2017.
 */

public class RequestController {


    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());


    public static <S> S createService(Class<S> serviceClass) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES);
        okHttpClientBuilder.dispatcher(new Dispatcher());
        Retrofit retrofit = builder.client(okHttpClientBuilder.build()).build();
        return retrofit.create(serviceClass);
    }
}
