package com.threadhomework.mohsen.recyclerview;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class ShortcutAdapter extends RecyclerView.Adapter<ShortcutAdapter.ViewHolder> {

    private List<Shortcut> items;
    private Context context;

    public ShortcutAdapter(List<Shortcut> items , Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.template_shortcut_row  , parent ,false);
        return new ViewHolder(view , context , items );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.shortcutName.setText(items.get(position).getName());
            holder.shortcutImage.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView shortcutName;
        ImageView shortcutImage;
        Context context ;
        List<Shortcut> itemsShortcut;
        String path ="" ;
        public ViewHolder(View itemView , Context context , List<Shortcut> items) {
            super(itemView);
            shortcutName = (TextView) itemView.findViewById(R.id.shortcut_name);
            shortcutImage = (ImageView) itemView.findViewById(R.id.shortcut_image);
            this.context = context;
            itemView.setOnClickListener(this);
            itemsShortcut = items;
        }

        @Override
        public void onClick(View v) {
            Bundle bundle = new Bundle();
            bundle.putString("Name" , shortcutName.getText().toString());
            Intent intent = new Intent(context , ListFile.class );
            intent.putExtra("shortcut" , bundle);
            context.startActivity(intent);
        }
    }
}
