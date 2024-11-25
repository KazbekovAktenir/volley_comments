package com.example.example_volley_comments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private final List<Comment> comments;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Comment comment);
    }

    public CommentAdapter(List<Comment> comments, OnItemClickListener listener) {
        this.comments = comments;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = comments.get(position);
        holder.bind(comment, listener);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    static class CommentViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView emailTextView;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
        }

        public void bind(Comment comment, OnItemClickListener listener) {
            nameTextView.setText(comment.getName());
            emailTextView.setText(comment.getEmail());
            itemView.setOnClickListener(v -> listener.onItemClick(comment));
        }
    }
}