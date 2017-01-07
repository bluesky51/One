package com.exam.sky.one.bean.question;

import java.util.List;

/**
 * Created by bluesky on 16/9/21.
 */
public class QuestionRelated {

    /**
     * res : 0
     * data : [{"question_id":"1210","question_title":"两个人的感情里到底有没有配不配？","answer_title":"沐沐答青椒：","answer_content":"感情，信了就配，不信就不配。感情里哪有配不配之说。如果你相信这份感情，相信另一半值得你付出，相信你们","question_makettime":"2015-12-29 22:00:00"},{"question_id":"562","question_title":"为什么人的感情需求永远无法满足？","answer_title":"@金国栋TOM答sLow cHiLd：","answer_content":"我常常听见这样的声音。说：我只不过想找一个能对我好，各种迁就照顾我，体贴我的人，外貌、金钱，真的不重","question_makettime":"2014-04-04 22:00:00"}]
     */

    private int res;
    /**
     * question_id : 1210
     * question_title : 两个人的感情里到底有没有配不配？
     * answer_title : 沐沐答青椒：
     * answer_content : 感情，信了就配，不信就不配。感情里哪有配不配之说。如果你相信这份感情，相信另一半值得你付出，相信你们
     * question_makettime : 2015-12-29 22:00:00
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
        private String question_id;
        private String question_title;
        private String answer_title;
        private String answer_content;
        private String question_makettime;

        public String getQuestion_id() {
            return question_id;
        }

        public void setQuestion_id(String question_id) {
            this.question_id = question_id;
        }

        public String getQuestion_title() {
            return question_title;
        }

        public void setQuestion_title(String question_title) {
            this.question_title = question_title;
        }

        public String getAnswer_title() {
            return answer_title;
        }

        public void setAnswer_title(String answer_title) {
            this.answer_title = answer_title;
        }

        public String getAnswer_content() {
            return answer_content;
        }

        public void setAnswer_content(String answer_content) {
            this.answer_content = answer_content;
        }

        public String getQuestion_makettime() {
            return question_makettime;
        }

        public void setQuestion_makettime(String question_makettime) {
            this.question_makettime = question_makettime;
        }
    }
}
