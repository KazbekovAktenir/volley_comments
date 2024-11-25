package com.example.example_volley_comments;

import androidx.annotation.NonNull;

public class Comment {
    int id;
    String name;
    String email;
    String body;

    public Comment(int id, String name, String email, String body) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
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

    public String getBody() {
        return body;
    }

    @NonNull
    @Override
    public String toString() {
        return "Comment " + id + "{" +
                "\nName:" + name +
                "\nEmail:" + email +
                "\nBody:" + body + "}";
    }
}
