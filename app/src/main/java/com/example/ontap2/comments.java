package com.example.ontap2;

import com.google.gson.annotations.SerializedName;

public class comments {
    private int postId;
    private  int id;
    private String name;
    private  String email;
    private String body;
    private boolean check;
    @SerializedName("body")
    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isCheck() {
        return check;
    }

    public String getBody() {
        return body;

    }
}
