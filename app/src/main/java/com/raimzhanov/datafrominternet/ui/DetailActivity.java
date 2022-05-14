package com.raimzhanov.datafrominternet.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.raimzhanov.datafrominternet.model.Post;
import com.raimzhanov.datafrominternet.R;
import com.raimzhanov.datafrominternet.data.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {


    TextView textViewDetail;
    private  int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        textViewDetail = findViewById(R.id.postDetail);
        if (intent.hasExtra("id")){
             id =intent.getIntExtra("id",1);
        }
        Log.d("TAG", "onCreate: "+id);
        RetrofitBuilder.getService().getPostById(id).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                String body = response.body().getBody();
                String title = response.body().getTitle();
                String id = response.body().getId().toString();
                String userId = response.body().getUserId().toString();
                textViewDetail.setText("Body :" + body+"\n"+"Title :"+title +"\n"+"ID :"+id+"\n"+"User ID :"+userId);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
}