package com.exam.sky.one.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bluesky on 16/9/20.
 */
public class MainReadBean implements Parcelable {
    int type;
    Object object;

    public MainReadBean() {

    }

    public MainReadBean(int type) {
        this.type = type;
    }

    public static final Creator<MainReadBean> CREATOR = new Creator<MainReadBean>() {
        @Override
        public MainReadBean createFromParcel(Parcel in) {
            int type = in.readInt();
            return new MainReadBean(type);
        }

        @Override
        public MainReadBean[] newArray(int size) {
            return new MainReadBean[size];
        }
    };

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(type);
    }
}
