package com.example.gitlabrepos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gitlabrepos.R;
import com.example.gitlabrepos.model.RepositoriesModel;

import java.util.List;

/* Created by harishrevuri on 2020-04-08 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<RepositoriesModel> repos;
    private Context context;

    public DataAdapter(@NonNull Context context, List<RepositoriesModel> repositoriesModels) {
        this.context = context;
        this.repos = repositoriesModels;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        holder.name.setText(repos.get(position).getNamespace().getName());
        holder.description.setText(repos.get(position).getName());
        holder.branches.setText(repos.get(position).getNamespace().getPath());
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, description, branches;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            description = (TextView) itemView.findViewById(R.id.description);
            branches = (TextView) itemView.findViewById(R.id.branches);
        }
    }
}
