package com.example.example_volley_comments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String url = "https://jsonplaceholder.typicode.com/comments";

    private RecyclerView recyclerView;
    private Button button;
    private CommentAdapter adapter;
    private List<Comment> commentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        button = findViewById(R.id.button);

        adapter = new CommentAdapter(commentList, comment -> {
            //обработка нажатия на элемент
            Log.i(TAG, "Selected Comment: " + comment.toString());
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(v -> getData());
    }

    private void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        commentList.clear();

                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject commJson = response.getJSONObject(i);
                                Comment comment = new Comment(
                                        commJson.getInt("id"),
                                        commJson.getString("name"),
                                        commJson.getString("email"),
                                        commJson.getString("body")
                                );
                                commentList.add(comment);
                            }
                            adapter.notifyDataSetChanged();
                        } catch (Exception ex) {
                            Log.e(TAG, "Error parsing JSON: " + ex.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "Error: " + error.getMessage());
                    }
                });

        requestQueue.add(jsonArrayRequest);
    }
}
