package com.exam.sky.one.bean.search;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by BlueSky on 16/12/26.
 */

public class ReadingBean {

    /**
     * res : 0
     * data : [{"id":"1482","title":"Small Episode插曲","type":"essay","number":0},{"id":"1338","title":"AI觉醒","type":"essay","number":0},{"id":"1294","title":"IPhone Man","type":"essay","number":0},{"id":"921","title":"听《Reality》的女人","type":"essay","number":0},{"id":"833","title":"Brainternet","type":"essay","number":0},{"id":"668","title":"我的Pang友齐大福（四）","type":"essay","number":0},{"id":"617","title":"我的pang友齐大福（三）","type":"essay","number":0},{"id":"596","title":"我的pang友齐大福（二）","type":"essay","number":0},{"id":"590","title":"我的pang友齐大福","type":"essay","number":0},{"id":"543","title":"我认识的三个Sandy张","type":"essay","number":0},{"id":"330","title":"300 Days","type":"essay","number":0},{"id":"298","title":"You changed my life","type":"essay","number":0},{"id":"81","title":"纽约客的中国处女行:Hunting Hanhan","type":"essay","number":0},{"id":"1550","title":"\u201c所有人问所有人·郭麒麟答一个App工作室\u201d","type":"question","number":0},{"id":"1528","title":"所有人问所有人·陈坤答一个App工作室","type":"question","number":0},{"id":"1341","title":"女朋友如何看待你看AV？","type":"question","number":0},{"id":"1305","title":"直男被误会成gay是什么样的体验？","type":"question","number":0},{"id":"1292","title":"AI到底有没有可能统治人类？","type":"question","number":0},{"id":"1200","title":"为什么朋友对另一半的评价很容易影响我们对Ta的看法？","type":"question","number":0},{"id":"911","title":"为什么确信Ta就是真爱？","type":"question","number":0},{"id":"873","title":"你和Ta的友谊是怎么变淡的？","type":"question","number":0},{"id":"719","title":"你想对未来的Ta说什么？","type":"question","number":0},{"id":"710","title":"女生为什么要看AV？","type":"question","number":0},{"id":"634","title":"心里住进一个TA是怎样的感觉？","type":"question","number":0},{"id":"553","title":"在TA需要你的那一刻出现真的那么重要吗？","type":"question","number":0},{"id":"446","title":"如何评价Leonard Cohen？","type":"question","number":0},{"id":"257","title":"女明星们穿露背露胸的礼服时到底有没有穿Bra呢？","type":"question","number":0},{"id":"22","title":"Gay和拉拉可以做好朋友吗？","type":"question","number":0},{"id":"123","title":"《上海滩的贾斯汀·比伯》第十九话：Das Ewig-Weibliche，Zieht uns hinan.","type":"serialcontent","number":"19","serial_list":["105","106","107","108","109","110","111","112","113","114","116","115","117","118","119","120","121","122","123","129","130"]},{"id":"56","title":"How about now\u2014\u2014女王乔安Ⅱ","type":"serialcontent","number":"3","serial_list":["54","55","56","57","58","59","60","61","62","63"]}]
     */

    private int res;
    /**
     * id : 1482
     * title : Small Episode插曲
     * type : essay
     * number : 0
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
        private String type;
        private int number;

        protected DataBean() {

        }

        public DataBean(String id, String title, String type, int number) {
            this.id = id;
            this.title = title;
            this.type = type;
            this.number = number;
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                String id = in.readString();
                String title = in.readString();
                String type = in.readString();
                int number = in.readInt();
                return new DataBean(id, title, type, number);
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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(title);
            dest.writeString(type);
            dest.writeInt(number);
        }
    }
}
