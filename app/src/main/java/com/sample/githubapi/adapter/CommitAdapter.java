package com.sample.githubapi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sample.githubapi.R;
import com.sample.githubapi.model.CommitRecord;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommitAdapter extends RecyclerView.Adapter<CommitAdapter.ViewHolder> {
    private List<CommitRecord> commits = new ArrayList();
    public CommitAdapter(List<CommitRecord> commits) {
        this.commits = commits;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_commit, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommitAdapter.ViewHolder holder, int position) {
        holder.txtMessage.setText("Message: "+ commits.get(position).getCommit().getMessage());
        holder.txtSha.setText("Sha: "+ commits.get(position).getSha());
        holder.txtAuthor.setText("Author: "+ commits.get(position).getCommit().getAuthor().getName());
    }

    @Override
    public int getItemCount() {
        return commits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtMessage;
        private TextView txtSha;
        private TextView txtAuthor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMessage = itemView.findViewById(R.id.txtCommitMessage);
            txtSha = itemView.findViewById(R.id.txtSha);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
        }
    }
}
