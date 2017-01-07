package com.exam.sky.one.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bluesky on 16/9/13.
 */
public class MainHomeDetailData {

    /**
     * res : 0
     * data : {"hpcontent_id":"1464","hp_title":"VOL.1437","author_id":"-1","hp_img_url":"http://image.wufazhuce.com/FmBxzN7EV5jjD3Ceyr4omJHb5Xd_","hp_img_original_url":"http://image.wufazhuce.com/FmBxzN7EV5jjD3Ceyr4omJHb5Xd_","hp_author":"你所看到的未必真实&amp;于雷 作品","ipad_url":"http://image.wufazhuce.com/FjuBR7SA7Nn9ZbYtdzdB1V9Pt0rp","hp_content":"幸福是做你来到这个世界上注定要做的事，幸福是你所从事的事业和你这个人的本性是一致的。 by 乔纳森·弗兰岑","hp_makettime":"2016-09-12 23:00:00","last_update_date":"2016-09-07 14:07:35","web_url":"http://m.wufazhuce.com/one/1464","wb_img_url":"","praisenum":11021,"sharenum":1297,"commentnum":0}
     */

    private int res;
    /**
     * hpcontent_id : 1464
     * hp_title : VOL.1437
     * author_id : -1
     * hp_img_url : http://image.wufazhuce.com/FmBxzN7EV5jjD3Ceyr4omJHb5Xd_
     * hp_img_original_url : http://image.wufazhuce.com/FmBxzN7EV5jjD3Ceyr4omJHb5Xd_
     * hp_author : 你所看到的未必真实&amp;于雷 作品
     * ipad_url : http://image.wufazhuce.com/FjuBR7SA7Nn9ZbYtdzdB1V9Pt0rp
     * hp_content : 幸福是做你来到这个世界上注定要做的事，幸福是你所从事的事业和你这个人的本性是一致的。 by 乔纳森·弗兰岑
     * hp_makettime : 2016-09-12 23:00:00
     * last_update_date : 2016-09-07 14:07:35
     * web_url : http://m.wufazhuce.com/one/1464
     * wb_img_url :
     * praisenum : 11021
     * sharenum : 1297
     * commentnum : 0
     */

    private DataBean data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable{
        private String hpcontent_id;
        private String hp_title;
        private String author_id;
        private String hp_img_url;
        private String hp_img_original_url;
        private String hp_author;
        private String ipad_url;
        private String hp_content;
        private String hp_makettime;
        private String last_update_date;
        private String web_url;
        private String wb_img_url;
        private int praisenum;
        private int sharenum;
        private int commentnum;

        protected DataBean(Parcel in) {
            hpcontent_id = in.readString();
            hp_title = in.readString();
            author_id = in.readString();
            hp_img_url = in.readString();
            hp_img_original_url = in.readString();
            hp_author = in.readString();
            ipad_url = in.readString();
            hp_content = in.readString();
            hp_makettime = in.readString();
            last_update_date = in.readString();
            web_url = in.readString();
            wb_img_url = in.readString();
            praisenum = in.readInt();
            sharenum = in.readInt();
            commentnum = in.readInt();
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

        public String getHpcontent_id() {
            return hpcontent_id;
        }

        public void setHpcontent_id(String hpcontent_id) {
            this.hpcontent_id = hpcontent_id;
        }

        public String getHp_title() {
            return hp_title;
        }

        public void setHp_title(String hp_title) {
            this.hp_title = hp_title;
        }

        public String getAuthor_id() {
            return author_id;
        }

        public void setAuthor_id(String author_id) {
            this.author_id = author_id;
        }

        public String getHp_img_url() {
            return hp_img_url;
        }

        public void setHp_img_url(String hp_img_url) {
            this.hp_img_url = hp_img_url;
        }

        public String getHp_img_original_url() {
            return hp_img_original_url;
        }

        public void setHp_img_original_url(String hp_img_original_url) {
            this.hp_img_original_url = hp_img_original_url;
        }

        public String getHp_author() {
            return hp_author;
        }

        public void setHp_author(String hp_author) {
            this.hp_author = hp_author;
        }

        public String getIpad_url() {
            return ipad_url;
        }

        public void setIpad_url(String ipad_url) {
            this.ipad_url = ipad_url;
        }

        public String getHp_content() {
            return hp_content;
        }

        public void setHp_content(String hp_content) {
            this.hp_content = hp_content;
        }

        public String getHp_makettime() {
            return hp_makettime;
        }

        public void setHp_makettime(String hp_makettime) {
            this.hp_makettime = hp_makettime;
        }

        public String getLast_update_date() {
            return last_update_date;
        }

        public void setLast_update_date(String last_update_date) {
            this.last_update_date = last_update_date;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public String getWb_img_url() {
            return wb_img_url;
        }

        public void setWb_img_url(String wb_img_url) {
            this.wb_img_url = wb_img_url;
        }

        public int getPraisenum() {
            return praisenum;
        }

        public void setPraisenum(int praisenum) {
            this.praisenum = praisenum;
        }

        public int getSharenum() {
            return sharenum;
        }

        public void setSharenum(int sharenum) {
            this.sharenum = sharenum;
        }

        public int getCommentnum() {
            return commentnum;
        }

        public void setCommentnum(int commentnum) {
            this.commentnum = commentnum;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(hpcontent_id);
            dest.writeString(hp_title);
            dest.writeString(author_id);
            dest.writeString(hp_img_url);
            dest.writeString(hp_img_original_url);
            dest.writeString(hp_author);
            dest.writeString(ipad_url);
            dest.writeString(hp_content);
            dest.writeString(hp_makettime);
            dest.writeString(last_update_date);
            dest.writeString(web_url);
            dest.writeString(wb_img_url);
            dest.writeInt(praisenum);
            dest.writeInt(sharenum);
            dest.writeInt(commentnum);
        }
    }
}
