package com.raimzhanov.datafrominternet.data;


import com.raimzhanov.datafrominternet.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
@GET("posts")
    Call<List<Post>>getAllPosts();


@GET("posts/{id}")
    Call<Post> getPostById(@Path("id") int id);
}
