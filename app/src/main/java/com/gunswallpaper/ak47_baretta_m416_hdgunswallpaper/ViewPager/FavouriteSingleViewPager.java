package com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.MyDb.DbModel;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.R;

import java.util.ArrayList;
import java.util.Objects;

public class FavouriteSingleViewPager extends PagerAdapter {

    Context context;
    ArrayList<DbModel> designsArrayList;
    LayoutInflater layoutInflater;

    onFavouriteClickListener onFavouriteClickListener;
    onSaveImageClickListener onSaveImageClickListener;
    onShareImageClickListener onShareImageClickListener;
    onSetWallPaperClickListener onSetWallPaperClickListener;

    public void setOnFavouriteClickListener(FavouriteSingleViewPager.onFavouriteClickListener onFavouriteClickListener) {
        this.onFavouriteClickListener = onFavouriteClickListener;
    }
    public void setOnSaveImageClickListener(FavouriteSingleViewPager.onSaveImageClickListener onSaveImageClickListener) {
        this.onSaveImageClickListener = onSaveImageClickListener;
    }
    public void setOnShareImageClickListener(FavouriteSingleViewPager.onShareImageClickListener onShareImageClickListener) {
        this.onShareImageClickListener = onShareImageClickListener;
    }
    public void setOnSetWallPaperClickListener(FavouriteSingleViewPager.onSetWallPaperClickListener onSetWallPaperClickListener) {
        this.onSetWallPaperClickListener = onSetWallPaperClickListener;
    }

    public FavouriteSingleViewPager(Context context, ArrayList<DbModel> designsArrayList) {
        this.context = context;
        this.designsArrayList = designsArrayList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return designsArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((RelativeLayout) object);
    }

    @NonNull
    @Override
    @SuppressLint("MissingInflatedId")
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.single_image_pager, container, false);

        ImageView ivAddToFavourite = itemView.findViewById(R.id.btnFavorite);
        ivAddToFavourite.setImageResource(R.drawable.baseline_favorite_fill_24);
        ImageView ivShareImage = itemView.findViewById(R.id.btnShare);
        ImageView ivDownloadImage = itemView.findViewById(R.id.btnSave);
        ImageView btnWallpaper = itemView.findViewById(R.id.btnWallpaper);

        ivAddToFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onFavouriteClickListener != null){
                    onFavouriteClickListener.onFavourite(ivAddToFavourite, ivAddToFavourite, position);
                }
            }
        });
        ivShareImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onShareImageClickListener != null){
                    onShareImageClickListener.onShareImage(ivShareImage, position);
                }
            }
        });
        ivDownloadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSaveImageClickListener != null){
                    onSaveImageClickListener.onSaveImage(ivDownloadImage, position);
                }
            }
        });
        btnWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSetWallPaperClickListener != null){
                    onSetWallPaperClickListener.onsetWallPaperClick(btnWallpaper, position);
                }
            }
        });


        ImageView imageView = (ImageView) itemView.findViewById(R.id.vp_singleImageSlide);

        byte[] imageData = designsArrayList.get(position).getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);

        imageView.setImageBitmap(bitmap);
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        Objects.requireNonNull(container).addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {

        return super.getItemPosition(object);
    }

    public interface onShareImageClickListener{
        void onShareImage(ImageView image, int position);
    }
    public interface onSaveImageClickListener{
        void onSaveImage(ImageView image, int position);
    }
    public interface onFavouriteClickListener{
        void onFavourite(ImageView image, ImageView icon, int position);
    }

    public interface onSetWallPaperClickListener {
        void onsetWallPaperClick(ImageView imageView, int position);
    }

}
