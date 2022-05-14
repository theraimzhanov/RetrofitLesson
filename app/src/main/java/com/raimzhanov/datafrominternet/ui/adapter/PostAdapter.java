package com.raimzhanov.datafrominternet.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.raimzhanov.datafrominternet.model.Post;
import com.raimzhanov.datafrominternet.helper.PostClick;
import com.raimzhanov.datafrominternet.R;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

   List<Post> list;
   PostClick postClick;

    public PostAdapter(List<Post> list) {
        this.list = list;
    }

    public void setPostClick(PostClick postClick) {
        this.postClick = postClick;
    }

    public void setList(List<Post> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
   Post post = list.get(position);
   holder.textViewBody.setText(post.getBody());
   holder.textViewTitle.setText(post.getTitle());
   holder.textViewId.setText(post.getId().toString());
   holder.textViewID.setText(post.getUserId().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder{
TextView textViewId;
TextView textViewID;
TextView textViewBody;
TextView textViewTitle;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.postId);
            textViewID = itemView.findViewById(R.id.postID);
            textViewTitle = itemView.findViewById(R.id.postTitle);
            textViewBody = itemView.findViewById(R.id.postBody);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (postClick != null){
                        postClick.postClick(list.get(getAdapterPosition()).getId());

                    }
                }
            });
        }
    }
}
