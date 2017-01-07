package com.exam.sky.one.bean.movie;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by BlueSky on 16/12/24.
 */

public class Movie {

    /**
     * res : 0
     * data : [{"id":"192","title":"摆渡人","verse":"","verse_en":"","score":"74","revisedscore":"0","releasetime":"2016-12-23 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"http://music.wufazhuce.com/lro4kjATb2AhIrbY2-1_nktbpfti","cover":"http://image.wufazhuce.com/FgI3BjsyBRwSj84MHZj-HhCdWkuz","author_list":[{"user_id":"5664698","user_name":"肉山大魔王","desc":"我从小就想做个黑帮。","wb_name":"","is_settled":"0","settled_type":"0","summary":"我从小就想做个黑帮。","fans_total":"0","web_url":"http://image.wufazhuce.com/FvNnsE2f_tS6BI0XnwsYYEPe-5U5"}],"servertime":1482584945},{"id":"191","title":"铁道飞虎","verse":"","verse_en":"","score":"85","revisedscore":"0","releasetime":"2016-12-23 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"http://music.wufazhuce.com/lro4kjATb2AhIrbY2-1_nktbpfti","cover":"http://image.wufazhuce.com/FoRdp7yBX6eSEVgEiX9KPOT-mcgJ","author_list":[{"user_id":"5652778","user_name":"武束衣","desc":"南人北飘，笔头藏刃，电影已然是本命中之根本；理工底子文艺心，抒怀之余还把逻辑当盘下酒菜。","wb_name":"@武束衣","is_settled":"0","settled_type":"0","summary":"南人北飘，笔头藏刃，电影已然是本命中之根本；理工底子文艺心，抒怀之余还把逻辑当盘下酒菜。","fans_total":"0","web_url":"http://image.wufazhuce.com/Fhd2fFp1N8631gskn-YWxWHFqm7D"}],"servertime":1482584945},{"id":"187","title":"长城","verse":"","verse_en":"","score":"75","revisedscore":"0","releasetime":"2016-12-16 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"","cover":"http://image.wufazhuce.com/FmRaRY6V2mcJwX01P7j3tJ9nQ36e","author_list":[{"user_id":"5563424","user_name":"马夋","desc":"拖延症晚期患者","wb_name":"","is_settled":"0","settled_type":"0","summary":"拖延症晚期患者","fans_total":"0","web_url":"http://image.wufazhuce.com/FkeYd8K3Yg1xGVUDSGUyJ4dfIwnt"}],"servertime":1482584945},{"id":"185","title":"少年","verse":"","verse_en":"","score":"83","revisedscore":"0","releasetime":"2016-12-16 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"","cover":"http://image.wufazhuce.com/Fhh-TXhnc_7FNLIoDMcGHMXPGDBj","author_list":[{"user_id":"7588435","user_name":"杨树鹏","desc":"电影导演","wb_name":"","is_settled":"0","settled_type":"0","summary":"电影导演","fans_total":"0","web_url":"http://image.wufazhuce.com/Fj9Pkic7z3b7xqA38iSwmx35i_eS"}],"servertime":1482584945},{"id":"188","title":"我在故宫修文物","verse":"","verse_en":"","score":"90","revisedscore":"0","releasetime":"2016-12-16 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"","cover":"http://image.wufazhuce.com/Ft8JD6tFijQoV8sP4Vk0TMyGyzy9","author_list":[{"user_id":"7588924","user_name":"萧寒","desc":"导演","wb_name":"","is_settled":"0","settled_type":"0","summary":"导演","fans_total":"0","web_url":"http://image.wufazhuce.com/Fti3FzRu19EmF2sKN5sceCNeiF7A"}],"servertime":1482584945},{"id":"189","title":"罗曼蒂克消亡史","verse":"","verse_en":"","score":"82","revisedscore":"0","releasetime":"2016-12-16 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"http://music.wufazhuce.com/lro4kjATb2AhIrbY2-1_nktbpfti","cover":"http://image.wufazhuce.com/FlKS_M25F-_InG2hx16czrAs_Sc7","author_list":[{"user_id":"5664698","user_name":"肉山大魔王","desc":"我从小就想做个黑帮。","wb_name":"","is_settled":"0","settled_type":"0","summary":"我从小就想做个黑帮。","fans_total":"0","web_url":"http://image.wufazhuce.com/FvNnsE2f_tS6BI0XnwsYYEPe-5U5"}],"servertime":1482584945},{"id":"182","title":"28岁未成年","verse":"","verse_en":"","score":"78","revisedscore":"0","releasetime":"2016-12-09 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"","cover":"http://image.wufazhuce.com/Fq_0p7ZLVAd6xMw9OlMrtD9A9W7A","author_list":[{"user_id":"7566973","user_name":"张末","desc":"电影导演","wb_name":"","is_settled":"0","settled_type":"0","summary":"电影导演","fans_total":"0","web_url":"http://image.wufazhuce.com/FpzuInoKizW156j37K0RnGntHX9Y"}],"servertime":1482584945},{"id":"184","title":"塔洛","verse":"","verse_en":"","score":"65","revisedscore":"0","releasetime":"2016-12-09 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"","cover":"http://image.wufazhuce.com/FrFoY1o2LfQ_C5UILEYb85BXGvQm","author_list":[{"user_id":"7567900","user_name":"万玛才旦","desc":"代表作《塔洛》《老狗》《静静的嘛呢石》等","wb_name":"","is_settled":"0","settled_type":"0","summary":"电影导演，作家","fans_total":"0","web_url":"http://image.wufazhuce.com/FroDSCoTLWWpT3ZS1BWe44fqkwz0"}],"servertime":1482584945},{"id":"183","title":"萨利机长","verse":"","verse_en":"","score":"83","revisedscore":"0","releasetime":"2016-12-09 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"","cover":"http://image.wufazhuce.com/FrHItGDbDTn2-O2VqLYN1KDvsl3o","author_list":[{"user_id":"5670786","user_name":"正义联盟实习生","desc":"喜欢那些喜欢的东西","wb_name":"@正义联盟实习生","is_settled":"0","settled_type":"0","summary":"混圈的","fans_total":"0","web_url":"http://image.wufazhuce.com/Fs1x1V7Ao1bTrB4tEm2WgTHVVu0Q"}],"servertime":1482584945},{"id":"181","title":"血战钢锯岭","verse":"","verse_en":"","score":"88","revisedscore":"0","releasetime":"2016-12-08 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"","cover":"http://image.wufazhuce.com/FqHKiPYpBYqVrxGLFm0Lvv-QsRB5","author_list":[{"user_id":"5664698","user_name":"肉山大魔王","desc":"我从小就想做个黑帮。","wb_name":"","is_settled":"0","settled_type":"0","summary":"我从小就想做个黑帮。","fans_total":"0","web_url":"http://image.wufazhuce.com/FvNnsE2f_tS6BI0XnwsYYEPe-5U5"}],"servertime":1482584945},{"id":"165","title":"你的名字。","verse":"","verse_en":"","score":"90","revisedscore":"0","releasetime":"2016-12-02 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"","cover":"http://image.wufazhuce.com/Fs9ZaSrD2bqCpoTcH0frrvBJwUyW","author_list":[{"user_id":"7541866","user_name":"Ume","desc":"她和时间跳华尔兹。","wb_name":"","is_settled":"0","settled_type":"0","summary":"日系影音爱好者","fans_total":"0","web_url":"http://image.wufazhuce.com/FmMnD2UCJBpBEUF4yGObbmeIvIxc"}],"servertime":1482584945},{"id":"166","title":"三少爷的剑","verse":"","verse_en":"","score":"78","revisedscore":"0","releasetime":"2016-12-02 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"","cover":"http://image.wufazhuce.com/FhC38EIiARDniyhUFfrBY1co9L_B","author_list":[{"user_id":"5664698","user_name":"肉山大魔王","desc":"我从小就想做个黑帮。","wb_name":"","is_settled":"0","settled_type":"0","summary":"我从小就想做个黑帮。","fans_total":"0","web_url":"http://image.wufazhuce.com/FvNnsE2f_tS6BI0XnwsYYEPe-5U5"}],"servertime":1482584945},{"id":"167","title":"佩小姐的奇幻城堡","verse":"","verse_en":"","score":"87","revisedscore":"0","releasetime":"2016-12-02 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"","cover":"http://image.wufazhuce.com/Fhjpn7o1JsUp-zTXjort5BauYVeV","author_list":[{"user_id":"5670786","user_name":"正义联盟实习生","desc":"喜欢那些喜欢的东西","wb_name":"@正义联盟实习生","is_settled":"0","settled_type":"0","summary":"混圈的","fans_total":"0","web_url":"http://image.wufazhuce.com/Fs1x1V7Ao1bTrB4tEm2WgTHVVu0Q"}],"servertime":1482584945},{"id":"163","title":"乘风破浪","verse":"","verse_en":"","score":null,"revisedscore":"0","releasetime":"2016-11-29 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"","cover":"http://image.wufazhuce.com/FisDAhzzb4qUfHkbRzT8ms1V1Wmx","author_list":[{"user_id":"7535968","user_name":"马锐拉","desc":"互联影库(时光网前身)创始人，前兰亭集势产品开发总监","wb_name":"","is_settled":"0","settled_type":"0","summary":"互联网工作从业者","fans_total":"0","web_url":"http://image.wufazhuce.com/Fj5n1SpmiVCAxbHOsuigOEn_5kbD"}],"servertime":1482584945},{"id":"162","title":"间谍同盟","verse":"","verse_en":"","score":"66","revisedscore":"0","releasetime":"2016-11-30 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"http://music.wufazhuce.com/liAix_-82yPHCh9KsBRfWUxKIl8c","cover":"http://image.wufazhuce.com/FkoVGb4a9jS9M5FMydKA29xh_OQB","author_list":[{"user_id":"7257021","user_name":"白日饮酒","desc":"资深影迷","wb_name":"妹纸的围脖","is_settled":"0","settled_type":"0","summary":"资深影迷","fans_total":"1","web_url":"http://image.wufazhuce.com/Fm1CX230zUXw13GHobHFnLjG6MHn"}],"servertime":1482584945},{"id":"158","title":"神奇动物在哪里","verse":"","verse_en":"","score":"87","revisedscore":"0","releasetime":"2016-11-25 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"http://music.wufazhuce.com/liAix_-82yPHCh9KsBRfWUxKIl8c","cover":"http://image.wufazhuce.com/FvBynNczaOkYshD-Wji_HUzAh72v","author_list":[{"user_id":"5670786","user_name":"正义联盟实习生","desc":"喜欢那些喜欢的东西","wb_name":"@正义联盟实习生","is_settled":"0","settled_type":"0","summary":"混圈的","fans_total":"0","web_url":"http://image.wufazhuce.com/Fs1x1V7Ao1bTrB4tEm2WgTHVVu0Q"}],"servertime":1482584945},{"id":"159","title":"海洋奇缘","verse":"","verse_en":"","score":"87","revisedscore":"0","releasetime":"2016-11-25 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"","cover":"http://image.wufazhuce.com/FlMvcoSHM_EBjwsiH7mmaomr94vT","author_list":[{"user_id":"5664698","user_name":"肉山大魔王","desc":"我从小就想做个黑帮。","wb_name":"","is_settled":"0","settled_type":"0","summary":"我从小就想做个黑帮。","fans_total":"0","web_url":"http://image.wufazhuce.com/FvNnsE2f_tS6BI0XnwsYYEPe-5U5"}],"servertime":1482584945},{"id":"160","title":"名侦探柯南：纯黑的恶梦","verse":"","verse_en":"","score":"87","revisedscore":"0","releasetime":"2016-11-25 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"","cover":"http://image.wufazhuce.com/FkRTSQdQdKXGESlWymHMGAkp9JqJ","author_list":[{"user_id":"7521907","user_name":"莫小巧","desc":"见习编剧，自由撰稿人.","wb_name":"","is_settled":"0","settled_type":"0","summary":"见习编剧，自由撰稿人","fans_total":"0","web_url":"http://image.wufazhuce.com/FiJHxb6WIYWfsWau-8b8SeBoez--"}],"servertime":1482584945},{"id":"161","title":"冲天火","verse":"","verse_en":"","score":"61","revisedscore":"0","releasetime":"2016-11-25 00:00:00","scoretime":"0000-00-00 00:00:00","start_video":"","cover":"http://image.wufazhuce.com/Fl0zPBtiQoVAvLdP1qPnoQ81gNUJ","author_list":[{"user_id":"7522206","user_name":"北青天天副刊","desc":"一个专注于人物、人生和文化生活方式的微信订阅号","wb_name":"","is_settled":"0","settled_type":"0","summary":"与你一起见证人生传奇","fans_total":"0","web_url":"http://image.wufazhuce.com/FkVxIu6QriYz8El2N8I5nbsqI_kn"}],"servertime":1482584945},{"id":"157","title":"我不是潘金莲","verse":"","verse_en":"","score":"76","revisedscore":"0","releasetime":"2016-11-18 00:00:00","scoretime":"2016-11-19 00:00:00","start_video":"","cover":"http://image.wufazhuce.com/FtNgzTAmSrxUQLeYmym26mN-i5uN","author_list":[{"user_id":"5664698","user_name":"肉山大魔王","desc":"我从小就想做个黑帮。","wb_name":"","is_settled":"0","settled_type":"0","summary":"我从小就想做个黑帮。","fans_total":"0","web_url":"http://image.wufazhuce.com/FvNnsE2f_tS6BI0XnwsYYEPe-5U5"}],"servertime":1482584945}]
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
     * author_list : [{"user_id":"5664698","user_name":"肉山大魔王","desc":"我从小就想做个黑帮。","wb_name":"","is_settled":"0","settled_type":"0","summary":"我从小就想做个黑帮。","fans_total":"0","web_url":"http://image.wufazhuce.com/FvNnsE2f_tS6BI0XnwsYYEPe-5U5"}]
     * servertime : 1482584945
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

    public static class DataBean implements Parcelable {
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
        private int servertime;
        /**
         * user_id : 5664698
         * user_name : 肉山大魔王
         * desc : 我从小就想做个黑帮。
         * wb_name :
         * is_settled : 0
         * settled_type : 0
         * summary : 我从小就想做个黑帮。
         * fans_total : 0
         * web_url : http://image.wufazhuce.com/FvNnsE2f_tS6BI0XnwsYYEPe-5U5
         */

        private List<AuthorListBean> author_list;

        public DataBean() {
        }

        public DataBean(String id, String title, String verse, String verse_en, String score, String revisedscore, String releasetime, String scoretime, String start_video, String cover, int servertime) {
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
            this.servertime = servertime;
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
                int servertime = in.readInt();
                return new DataBean(id, title, verse, verse_en, score, revisedscore, releasetime, scoretime, start_video, cover, servertime);
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

        public int getServertime() {
            return servertime;
        }

        public void setServertime(int servertime) {
            this.servertime = servertime;
        }

        public List<AuthorListBean> getAuthor_list() {
            return author_list;
        }

        public void setAuthor_list(List<AuthorListBean> author_list) {
            this.author_list = author_list;
        }

        @Override
        public int describeContents() {
            return 0;
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
            dest.writeInt(servertime);
        }

        public static class AuthorListBean implements Parcelable {
            private String user_id;
            private String user_name;
            private String desc;
            private String wb_name;
            private String is_settled;
            private String settled_type;
            private String summary;
            private String fans_total;
            private String web_url;

            public AuthorListBean() {
            }

            public AuthorListBean(String user_id, String user_name,
                                  String desc, String wb_name, String is_settled, String settled_type, String summary, String fans_total, String web_url) {
                this.user_id = user_id;
                this.user_name = user_name;
                this.desc = desc;
                this.wb_name = wb_name;
                this.is_settled = is_settled;
                this.settled_type = settled_type;
                this.summary = summary;
                this.fans_total = fans_total;
                this.web_url = web_url;
            }

            public static final Creator<AuthorListBean> CREATOR = new Creator<AuthorListBean>() {
                @Override
                public AuthorListBean createFromParcel(Parcel in) {
                    String user_id = in.readString();
                    String user_name = in.readString();
                    String desc = in.readString();
                    String wb_name = in.readString();
                    String is_settled = in.readString();
                    String settled_type = in.readString();
                    String summary = in.readString();
                    String fans_total = in.readString();
                    String web_url = in.readString();
                    return new AuthorListBean(user_id, user_name, desc
                            , wb_name, is_settled, settled_type, summary, fans_total, web_url);
                }

                @Override
                public AuthorListBean[] newArray(int size) {
                    return new AuthorListBean[size];
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
}
