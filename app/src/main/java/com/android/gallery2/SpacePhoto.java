package com.android.gallery2;

import android.os.Parcel;
import android.os.Parcelable;

public class SpacePhoto implements Parcelable{

    private String mUrl;
    private String mTitle;

    public SpacePhoto(String mUrl,String mTitle){
        this.mUrl=mUrl;
        this.mTitle=mTitle;
    }

    public SpacePhoto(Parcel in){
        mUrl=in.readString();
        mTitle=in.readString();
    }

    public static final Creator<SpacePhoto> CREATOR=new Creator<SpacePhoto>() {
        @Override
        public SpacePhoto createFromParcel(Parcel source) {
            return new SpacePhoto(source);
        }

        @Override
        public SpacePhoto[] newArray(int size) {
            return new SpacePhoto[size];
        }
    };

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUrl);
        dest.writeString(mTitle);
    }

    public static SpacePhoto[] getSpacePhotos(){
            return new SpacePhoto[]{
                    new SpacePhoto("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy"),
                    new SpacePhoto("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle"),
                    new SpacePhoto("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion"),
                    new SpacePhoto("http://i.imgur.com/qpr5LR2.jpg", "Earth"),
                    new SpacePhoto("http://i.imgur.com/pSHXfu5.jpg", "Astronaut"),
                    new SpacePhoto("http://i.imgur.com/3wQcZeY.jpg", "Satellite"),
                    new SpacePhoto("https://i.imgur.com/28FkQdmb.jpg", "Earth2"),
                    new SpacePhoto("https://i.imgur.com/3yimZNXb.jpg", "moon"),
            };
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
