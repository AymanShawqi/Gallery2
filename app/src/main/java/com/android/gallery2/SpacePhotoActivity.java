package com.android.gallery2;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class SpacePhotoActivity extends AppCompatActivity {

    public static final String Extra_space_Photo="Extra_space_Photo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_photo);

        final ImageView  img=findViewById(R.id.image_show);
        SpacePhoto spacePhoto=getIntent().getParcelableExtra(Extra_space_Photo);

        Glide.with(this)
                .asBitmap()
                .load(spacePhoto.getUrl())
                .error(R.drawable.ic_launcher_background)
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        onPalette(Palette.from(resource).generate());
                        //img.setImageBitmap(resource);
                        return false;
                    }

                    public void onPalette(Palette Palette){
                        if (Palette != null){
                            ViewGroup parent=(ViewGroup)img.getParent().getParent();
                            parent.setBackgroundColor(Palette.getDarkVibrantColor(Color.GRAY));
                        }
                    }
                })
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(img);
    }
}
