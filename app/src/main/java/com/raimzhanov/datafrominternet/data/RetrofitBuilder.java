package com.raimzhanov.datafrominternet.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
 private static RetrofitService service;
 public static RetrofitService getService(){
     if (service == null){
         service = buildRetrofit();
     }
 return service;
 }
     private static RetrofitService buildRetrofit(){
     return new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").
             addConverterFactory(GsonConverterFactory.create()).build().create(RetrofitService.class);
     }
}
//https://ghibliapi.herokuapp.com/films
