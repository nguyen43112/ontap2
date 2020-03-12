package com.example.ontap2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class commentsApdater extends RecyclerView.Adapter<commentsApdater.commentsHolder> {
private List<comments>commentsList;
private Context context;

public commentsApdater(Context context,List<comments> commentsList){
this.commentsList = commentsList;
this.context = context;
}
    @NonNull
    @Override
    public commentsHolder onCreateViewHolder(@NonNull ViewGroup ViewGroup, int i) {
    View view = LayoutInflater.from(ViewGroup.getContext()).inflate(R.layout.row,ViewGroup,false);
        return new commentsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull commentsHolder commentsHolder, int i) {
    comments comments = commentsList.get(i);
        String postId = String.valueOf(comments.getPostId());
        String id = String.valueOf(comments.getId());
        String name = String.valueOf(comments.getName());
        String email = String.valueOf(comments.getEmail());
        String body = String.valueOf(comments.getBody());
        Boolean check = Boolean.valueOf(comments.isCheck());
        commentsHolder.tvpostId.setText(postId);
        commentsHolder.tvid.setText(id);
        commentsHolder.tvname.setText(name);
        commentsHolder.tvemail.setText(email);
        commentsHolder.tvbody.setText(body);
        if (comments.isCheck()){

            commentsHolder.tvemail.setTextColor(Color.RED);
        }
        else   {

            commentsHolder.tvemail.setTextColor(Color.BLUE);
        }
        commentsHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SeconActivity.class);

            }
        });
    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }

    public class commentsHolder extends RecyclerView.ViewHolder {
    public TextView tvpostId , tvid , tvname,tvemail,tvbody;
        public commentsHolder(@NonNull View itemView) {
            super(itemView);
            tvpostId = itemView.findViewById(R.id.postId);
            tvid  = itemView.findViewById(R.id.id);
            tvname = itemView.findViewById(R.id.name);
            tvemail = itemView.findViewById(R.id.email);
            tvbody= itemView.findViewById(R.id.body);
        }
    }
}

