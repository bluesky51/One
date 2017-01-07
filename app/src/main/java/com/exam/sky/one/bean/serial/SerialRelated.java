package com.exam.sky.one.bean.serial;

import java.util.List;

/**
 * Created by bluesky on 16/9/21.
 */
public class SerialRelated {

    /**
     * res : 0
     * data : [{"id":"175","serial_id":"32","number":"15","title":"我在三十岁的第一年·第十五话","excerpt":"没有人真正成熟，有些人只是表现得比别人更加自信而已。","read_num":"178301","maketime":"2016-09-15 21:00:00","author":{"user_id":"4808838","user_name":"毛利","web_url":"http://image.wufazhuce.com/Fl3AgUQb4i6WocmORrnhMPkcDkV4","desc":"毛利，专栏作家。"},"has_audio":false},{"id":"176","serial_id":"32","number":"16","title":"我在三十岁的第一年·第十六话","excerpt":"这就是大姨妈带来的巨大负能量，几乎可以让一个女人，变成另一个人。","read_num":"156700","maketime":"2016-09-17 21:00:00","author":{"user_id":"4808838","user_name":"毛利","web_url":"http://image.wufazhuce.com/Fl3AgUQb4i6WocmORrnhMPkcDkV4","desc":"毛利，专栏作家。"},"has_audio":false}]
     */

    private int res;
    /**
     * id : 175
     * serial_id : 32
     * number : 15
     * title : 我在三十岁的第一年·第十五话
     * excerpt : 没有人真正成熟，有些人只是表现得比别人更加自信而已。
     * read_num : 178301
     * maketime : 2016-09-15 21:00:00
     * author : {"user_id":"4808838","user_name":"毛利","web_url":"http://image.wufazhuce.com/Fl3AgUQb4i6WocmORrnhMPkcDkV4","desc":"毛利，专栏作家。"}
     * has_audio : false
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

    public static class DataBean {
        private String id;
        private String serial_id;
        private String number;
        private String title;
        private String excerpt;
        private String read_num;
        private String maketime;
        /**
         * user_id : 4808838
         * user_name : 毛利
         * web_url : http://image.wufazhuce.com/Fl3AgUQb4i6WocmORrnhMPkcDkV4
         * desc : 毛利，专栏作家。
         */

        private AuthorBean author;
        private boolean has_audio;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSerial_id() {
            return serial_id;
        }

        public void setSerial_id(String serial_id) {
            this.serial_id = serial_id;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getExcerpt() {
            return excerpt;
        }

        public void setExcerpt(String excerpt) {
            this.excerpt = excerpt;
        }

        public String getRead_num() {
            return read_num;
        }

        public void setRead_num(String read_num) {
            this.read_num = read_num;
        }

        public String getMaketime() {
            return maketime;
        }

        public void setMaketime(String maketime) {
            this.maketime = maketime;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public boolean isHas_audio() {
            return has_audio;
        }

        public void setHas_audio(boolean has_audio) {
            this.has_audio = has_audio;
        }

        public static class AuthorBean {
            private String user_id;
            private String user_name;
            private String web_url;
            private String desc;

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

            public String getWeb_url() {
                return web_url;
            }

            public void setWeb_url(String web_url) {
                this.web_url = web_url;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }
    }
}
