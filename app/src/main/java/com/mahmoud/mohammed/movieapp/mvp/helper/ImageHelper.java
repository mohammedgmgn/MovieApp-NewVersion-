package com.mahmoud.mohammed.movieapp.mvp.helper;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by mohammed on 11/3/2017.
 */

public class ImageHelper {
    public static void setGlideImage(Context context, String imageUrl, ImageView imageView) {
        Glide.with(context).load(Constants.BASE_IMAGE_URL + imageUrl).diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
}
