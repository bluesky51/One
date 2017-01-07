package com.exam.sky.one.bean.search;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by BlueSky on 16/12/26.
 */

public class AuthorBean {

    /**
     * res : 0
     * data : [{"user_id":"6237338","user_name":"Jeff Buckley","desc":"美国民谣/摇滚歌手","wb_name":"","is_settled":"0","settled_type":"0","summary":"美国民谣/摇滚歌手","fans_total":"0","web_url":"http://image.wufazhuce.com/FrbSJ7ouFnvmL9u2_g7ZZlpe89tS"},{"user_id":"7472263","user_name":"Jeff Beal","desc":"美国知名作曲家","wb_name":"","is_settled":"0","settled_type":"0","summary":"美国知名作曲家","fans_total":"0","web_url":"http://image.wufazhuce.com/Flx-Vw7y3AfsoK8VklOdAXSJ9oqK"}]
     */

    private int res;
    /**
     * user_id : 6237338
     * user_name : Jeff Buckley
     * desc : 美国民谣/摇滚歌手
     * wb_name :
     * is_settled : 0
     * settled_type : 0
     * summary : 美国民谣/摇滚歌手
     * fans_total : 0
     * web_url : http://image.wufazhuce.com/FrbSJ7ouFnvmL9u2_g7ZZlpe89tS
     */

    private List<DataBean> data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable{
        private String user_id;
        private String user_name;
        private String desc;
        private String wb_name;
        private String is_settled;
        private String settled_type;
        private String summary;
        private String fans_total;
        private String web_url;

        protected DataBean(Parcel in) {
            user_id = in.readString();
            user_name = in.readString();
            desc = in.readString();
            wb_name = in.readString();
            is_settled = in.readString();
            settled_type = in.readString();
            summary = in.readString();
            fans_total = in.readString();
            web_url = in.readString();
        }

        public DataBean() {
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getWb_name() {
            return wb_name;
        }

        public void setWb_name(String wb_name) {
            this.wb_name = wb_name;
        }

        public String getIs_settled() {
            return is_settled;
        }

        public void setIs_settled(String is_settled) {
            this.is_settled = is_settled;
        }

        public String getSettled_type() {
            return settled_type;
        }

        public void setSettled_type(String settled_type) {
            this.settled_type = settled_type;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getFans_total() {
            return fans_total;
        }

        public void setFans_total(String fans_total) {
            this.fans_total = fans_total;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(user_id);
            dest.writeString(user_name);
            dest.writeString(desc);
            dest.writeString(wb_name);
            dest.writeString(is_settled);
            dest.writeString(settled_type);
            dest.writeString(summary);
            dest.writeString(fans_total);
            dest.writeString(web_url);
        }
    }
}
