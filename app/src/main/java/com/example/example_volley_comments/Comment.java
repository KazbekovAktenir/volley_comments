package com.example.example_volley_comments;

public class Comment {
    private int id;
    private String name;
    private String email;
    private String body;

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

    @Override
    public String toString() {
        return "Comment {" +
                "ID: " + id +
                ", Name: '" + name + '\'' +
                ", Email: '" + email + '\'' +
                ", Body: '" + body + '\'' +
                '}';
    }
}
