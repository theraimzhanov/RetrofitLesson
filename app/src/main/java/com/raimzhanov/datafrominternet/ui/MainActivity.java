package com.raimzhanov.datafrominternet.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.raimzhanov.datafrominternet.model.Post;
import com.raimzhanov.datafrominternet.ui.adapter.PostAdapter;
import com.raimzhanov.datafrominternet.helper.PostClick;
import com.raimzhanov.datafrominternet.R;
import com.raimzhanov.datafrominternet.data.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    PostAdapter adapter;
    RecyclerView recyclerView;
    List<Post> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerViewPost);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostAdapter(list);
       getData();

       adapter.setPostClick(new PostClick() {
           @Override
           public void postClick(int position) {
               Intent intent = new Intent(MainActivity.this, DetailActivity.class);
               intent.putExtra("id",position);
               startActivity(intent);
               Log.d("T", "postClick: "+position);
           }
       });
    }
    private void getData(){

        RetrofitBuilder.getService().getAllPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                adapter.setList(response.body());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}