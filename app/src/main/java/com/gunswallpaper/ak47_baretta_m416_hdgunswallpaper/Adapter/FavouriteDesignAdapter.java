package com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.MyDb.DbModel;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.R;
import java.util.ArrayList;

public class FavouriteDesignAdapter extends RecyclerView.Adapter<FavouriteDesignAdapter.ViewHolder> {

    ArrayList<DbModel> designList;
    public FavouriteDesignAdapter(ArrayList<DbModel> designList) {
        this.designList = designList;
    }

    onImageClickListener onImageClickListener;
    public void setOnImageClickListener(FavouriteDesignAdapter.onImageClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_design, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DbModel imageModel = designList.get(position);
        byte[] imageData = imageModel.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);
        holder.ivSingleDesignImg.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return designList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivSingleDesignImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivSingleDesignImg = itemView.findViewById(R.id.wallpaperImg);
            ivSingleDesignImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onImageClickListener!=null){
                        onImageClickListener.onImageClick(ivSingleDesignImg, getAdapterPosition());
                    }
                }
            });
        }
    }

    public interface onImageClickListener{
        void onImageClick(ImageView image, int position);
    }


}
