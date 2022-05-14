package com.raimzhanov.datafrominternet;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {
@GET("posts")
    Call<List<Post>>getAllPosts();
@GET("posts/{id}")
    Call<Post> getPostById(@Path("id") int id);
}
