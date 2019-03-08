package com.android.gallery2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;

public class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder> {

    private SpacePhoto[] mSpacePhotos;
    private Context mContext;

    public ImageGalleryAdapter(Context context,SpacePhoto[] spacePhotos){
        mContext=context;
        mSpacePhotos=spacePhotos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SpacePhoto spacePhoto=mSpacePhotos[position];
        ImageView imageView=holder.mPhotoImageView;

        Glide
                .with(mContext)
                .load(spacePhoto.getUrl())
                .placeholder(R.drawable.cloud)
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return mSpacePhotos.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView mPhotoImageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mPhotoImageView=itemView.findViewById(R.id.iv_photo);
            mPhotoImageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            int position=getAdapterPosition();
            if(position!= RecyclerView.NO_POSITION){
                SpacePhoto spacePhoto=mSpacePhotos[position];
                Intent intent=new Intent(mContext,SpacePhotoActivity.class);
                intent.putExtra(SpacePhotoActivity.Extra_space_Photo,spacePhoto);
                mContext.startActivity(intent);
            }
        }
    }
}
