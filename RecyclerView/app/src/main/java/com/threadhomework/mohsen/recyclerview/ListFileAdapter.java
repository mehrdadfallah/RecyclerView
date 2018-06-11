package com.threadhomework.mohsen.recyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListFileAdapter extends RecyclerView.Adapter<ListFileAdapter.ViewHolder> {

    List<File> list;

    public ListFileAdapter(List<File> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.template_list_file_row  , parent ,false);
        return new ListFileAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("TAG 32" , list.get(position).getName());
        holder.fileView.setText(list.get(position).getName());
        if (list.get(position).isDirectory()){
            holder.imageFile.setImageResource(R.drawable.directory);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

        class ViewHolder extends RecyclerView.ViewHolder {

        TextView fileView;
        ImageView imageFile;

        public ViewHolder(View itemView) {
            super(itemView);
            fileView = (TextView) itemView.findViewById(R.id.file_name);
            imageFile = (ImageView) itemView.findViewById(R.id.file_image);
        }
    }
}
