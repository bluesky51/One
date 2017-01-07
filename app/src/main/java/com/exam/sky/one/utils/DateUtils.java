package com.exam.sky.one.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bluesky on 15/10/24.
 */
public class DateUtils {

    /**
     * 获取现在时间
     *
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String getEnglishMonth(String month) {
        String result="";
        switch (month){
            case "12":
                result="Dec";
                break;
            case "11":
                result="Nov";
                break;
            case "10":
                result="Oct";
                break;
            case "9":
                result="Sep";
                break;
            case "8":
                result="Aug";
                break;
            case "7":
                result="Jul";
                break;
            case "6":
                result="Jun";
                break;
            case "5":
                result="May";
                break;
            case "4":
                result="Apr";
                break;
            case "3":
                result="Mar";
                break;
            case "2":
                result="Feb";
                break;
            case "1":
                result="Jan";
                break;
        }

        return result;
    }
    public static String getAllEnglishMonth(String month) {
        String result="";
        switch (month){
            case "12":
                result="December";
                break;
            case "11":
                result="November";
                break;
            case "10":
                result="October";
                break;
            case "9":
                result="September";
                break;
            case "8":
                result="August";
                break;
            case "7":
                result="July";
                break;
            case "6":
                result="June";
                break;
            case "5":
                result="May";
                break;
            case "4":
                result="April";
                break;
            case "3":
                result="March";
                break;
            case "2":
                result="February";
                break;
            case "1":
                result="January";
                break;
        }

        return result;
    }
}
