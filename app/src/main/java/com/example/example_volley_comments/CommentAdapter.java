package com.example.example_volley_comments;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private List<Comment> commentList;

    public CommentAdapter(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Инфляция макета элемента списка
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comment, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = commentList.get(position);
        holder.nameTextView.setText(comment.getName());
        holder.emailTextView.setText(comment.getEmail());

        // Обработчик клика на элемент
        holder.itemView.setOnClickListener(v -> {
            // Создание и показ AlertDialog
            new AlertDialog.Builder(holder.itemView.getContext())
                    .setTitle("Comment Details")
                    .setMessage(
                            "ID: " + comment.getId() +
                                    "\nName: " + comment.getName() +
                                    "\nEmail: " + comment.getEmail() +
                                    "\nBody: " + comment.getBody())
                    .setPositiveButton("OK", null)
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    // ViewHolder для привязки элементов в списке
    public static class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, emailTextView;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
        }
    }
}
