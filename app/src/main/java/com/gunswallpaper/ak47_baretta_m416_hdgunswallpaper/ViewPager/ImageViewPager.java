package com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.ViewPager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.Model.Guns;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.MyDb.DbHelper;
import com.gunswallpaper.ak47_baretta_m416_hdgunswallpaper.R;
import com.ortiz.touchview.TouchImageView;

import java.util.ArrayList;
import java.util.Objects;

public class ImageViewPager extends PagerAdapter {

    Context context;
    ArrayList<Guns> designsArrayList;
    LayoutInflater layoutInflater;
    DbHelper dbHelper;
    boolean addToFavourite = false;

    onShareImageClickListener onShareImageClickListener;
    onSaveImageClickListener onSaveImageClickListener;
    onSetWallPaperClickListener onSetWallPaperClickListener;

    public void setOnShareImageClickListener(ImageViewPager.onShareImageClickListener onShareImageClickListener) {
        this.onShareImageClickListener = onShareImageClickListener;
    }

    public void setOnSaveImageClickListener(ImageViewPager.onSaveImageClickListener onSaveImageClickListener) {
        this.onSaveImageClickListener = onSaveImageClickListener;
    }

    public void setOnSetWallPaperClickListener(ImageViewPager.onSetWallPaperClickListener onSetWallPaperClickListener) {
        this.onSetWallPaperClickListener = onSetWallPaperClickListener;
    }

    public ImageViewPager(Context context, ArrayList<Guns> designsArrayList) {
        this.context = context;
        this.designsArrayList = designsArrayList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        dbHelper = DbHelper.getInstance(context.getApplicationContext());
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
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.single_image_pager, container, false);

        TouchImageView imageView = itemView.findViewById(R.id.vp_singleImageSlide);
        imageView.setImageResource(designsArrayList.get(position).getImage());

        ImageView btnAddFavorite = itemView.findViewById(R.id.btnFavorite);
        ImageView btnShareImg = itemView.findViewById(R.id.btnShare);
        ImageView btnDownloadImg = itemView.findViewById(R.id.btnSave);
        ImageView btnWallpaper = itemView.findViewById(R.id.btnWallpaper);

        String isFavourite = designsArrayList.get(position).getIsFavourite();
        if (isFavourite.equals("0")) {
            btnAddFavorite.setImageResource(R.drawable.baseline_favorite_border_24);
            addToFavourite = false;
        } else {
            btnAddFavorite.setImageResource(R.drawable.baseline_favorite_fill_24);
            addToFavourite = true;
        }

        btnAddFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!addToFavourite){
                    btnAddFavorite.setImageResource(R.drawable.baseline_favorite_fill_24);
                    addToFavourite(position);
                    addToFavourite = true;
                    designsArrayList.get(position).setIsFavourite("1");
                }
                else {
                    btnAddFavorite.setImageResource(R.drawable.baseline_favorite_border_24);
                    removeToFavourite(position);
                    addToFavourite = false;
                    designsArrayList.get(position).setIsFavourite("0");
                }
            }
        });
        btnShareImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onShareImageClickListener != null) {
                    onShareImageClickListener.onShareImage(btnShareImg, position);
                }
            }
        });
        btnDownloadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSaveImageClickListener != null) {
                    onSaveImageClickListener.onSaveImage(btnDownloadImg, position);
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

        Objects.requireNonNull(container).addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }


    private void addToFavourite(int position) {
        dbHelper.insertBitMapImages(context.getApplicationContext(), designsArrayList.get(position).getImage());
        Toast.makeText(context.getApplicationContext(), "Add to Favourite", Toast.LENGTH_SHORT).show();
    }

    private void removeToFavourite(int position) {
        dbHelper.deleteImage(designsArrayList.get(position).getImage());
        Toast.makeText(context.getApplicationContext(), "Remove From Favourite", Toast.LENGTH_SHORT).show();
    }

    public interface onShareImageClickListener {
        void onShareImage(ImageView imageView, int position);
    }

    public interface onSaveImageClickListener {
        void onSaveImage(ImageView imageView, int position);
    }

    public interface onSetWallPaperClickListener {
        void onsetWallPaperClick(ImageView imageView, int position);
    }

}
