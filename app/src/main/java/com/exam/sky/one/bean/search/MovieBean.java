package com.exam.sky.one.bean.search;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by BlueSky on 16/12/26.
 */

public class MovieBean {

    /**
     * res : 0
     * data : [{"id":"192","title":"摆渡人","verse":"","verse_en":"","score":"74","revisedscore":"0","releasetime":"2016-12-23 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"http://music.wufazhuce.com/lro4kjATb2AhIrbY2-1_nktbpfti","cover":"http://image.wufazhuce.com/FgI3BjsyBRwSj84MHZj-HhCdWkuz"},{"id":"215","title":"摆渡人","verse":"","verse_en":"","score":null,"revisedscore":"0","releasetime":"0000-00-00 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"","cover":""}]
     */

    private int res;
    /**
     * id : 192
     * title : 摆渡人
     * verse :
     * verse_en :
     * score : 74
     * revisedscore : 0
     * releasetime : 2016-12-23 00:00:00
     * scoretime : 0000-00-00 00:00:00
     * start_video : http://music.wufazhuce.com/lro4kjATb2AhIrbY2-1_nktbpfti
     * cover : http://image.wufazhuce.com/FgI3BjsyBRwSj84MHZj-HhCdWkuz
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
        private String id;
        private String title;
        private String verse;
        private String verse_en;
        private String score;
        private String revisedscore;
        private String releasetime;
        private String scoretime;
        private String start_video;
        private String cover;

        protected DataBean() {

        }

        public DataBean(String id, String title, String verse, String verse_en, String score, String revisedscore, String releasetime, String scoretime, String start_video, String cover) {
            this.id = id;
            this.title = title;
            this.verse = verse;
            this.verse_en = verse_en;
            this.score = score;
            this.revisedscore = revisedscore;
            this.releasetime = releasetime;
            this.scoretime = scoretime;
            this.start_video = start_video;
            this.cover = cover;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(title);
            dest.writeString(verse);
            dest.writeString(verse_en);
            dest.writeString(score);
            dest.writeString(revisedscore);
            dest.writeString(releasetime);
            dest.writeString(scoretime);
            dest.writeString(start_video);
            dest.writeString(cover);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                String id = in.readString();
                String title = in.readString();
                String verse = in.readString();
                String verse_en = in.readString();
                String score = in.readString();
                String revisedscore = in.readString();
                String releasetime = in.readString();
                String scoretime = in.readString();
                String start_video = in.readString();
                String cover = in.readString();
                return new DataBean(id,title,verse,verse_en,score,revisedscore,releasetime,scoretime,start_video,cover);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVerse() {
            return verse;
        }

        public void setVerse(String verse) {
            this.verse = verse;
        }

        public String getVerse_en() {
            return verse_en;
        }

        public void setVerse_en(String verse_en) {
            this.verse_en = verse_en;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getRevisedscore() {
            return revisedscore;
        }

        public void setRevisedscore(String revisedscore) {
            this.revisedscore = revisedscore;
        }

        public String getReleasetime() {
            return releasetime;
        }

        public void setReleasetime(String releasetime) {
            this.releasetime = releasetime;
        }

        public String getScoretime() {
            return scoretime;
        }

        public void setScoretime(String scoretime) {
            this.scoretime = scoretime;
        }

        public String getStart_video() {
            return start_video;
        }

        public void setStart_video(String start_video) {
            this.start_video = start_video;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }
    }
}
