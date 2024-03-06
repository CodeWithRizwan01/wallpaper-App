package com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Activity.SingleImageActivity;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Model.Guns;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.R;

import java.io.Serializable;
import java.util.ArrayList;

public class RecyclerContentAdapter extends RecyclerView.Adapter<RecyclerContentAdapter.viewHolder> {

    Context context;
    ArrayList<Guns> imageList;
    public RecyclerContentAdapter(Context context,  ArrayList<Guns> imageList) {
        this.context = context;
        this.imageList = imageList;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_item_design, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder,  int position) {
        holder.wallpaperImg.setImageResource(imageList.get(position).getImage());

        holder.wallpaperImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SingleImageActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("imageList", (Serializable) imageList);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView wallpaperImg;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            wallpaperImg = itemView.findViewById(R.id.wallpaperImg);
        }
    }

}


