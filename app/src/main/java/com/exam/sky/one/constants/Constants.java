package com.exam.sky.one.constants;

/**
 * Created by bluesky on 16/9/12.
 */
public class Constants {


    public static class HOME {
        //获取首页每个页面的数字号码的接口地址：
        public static final String HOME_PATH = "http://v3.wufazhuce.com:8000/api/hp/idlist/0";
        //根据每个页面的数据号码得到首页具体信息的接口地址：
        public static final String HOME_DETAIL_PATH = "http://v3.wufazhuce.com:8000/api/hp/detail/%s";//?表示每一页的数字号码

    }

    public static class READING {
        //阅读界面的广播轮播的接口
        public static final String READING_AD_PATH = "http://v3.wufazhuce.com:8000/api/reading/carousel/?";
        //阅读界面的广告轮播的详情页面接口地址％s用广播轮播接口中的id进行传递拼接
        public static final String READING_AD_DETIL_PATH = "http://v3.wufazhuce.com:8000/api/reading/carousel/%s";

        //阅读界面的广播轮播下的短片连载问答的接口
        public static final String READING_CONTENT_PATH = "http://v3.wufazhuce.com:8000/api/reading/index/?";

        //连载的详情页内容的接口地址
        public static final String SERIAL_CONTENT = "http://v3.wufazhuce.com:8000/api/serialcontent/%s";
        //连载的详情页相关推荐的接口地址
        public static final String SERIAL_RELATED_CONTENT = "http://v3.wufazhuce.com:8000/api/related/serial/%s";
        //连载的详情页内评论内容的接口地址
        public static final String SERIAL_COMMENT_CONTENT = "http://v3.wufazhuce.com:8000/api/comment/praiseandtime/serial/%s/0";

        //问答的详情页内容的接口地址
        public static final String QUESTION_CONTENT = "http://v3.wufazhuce.com:8000/api/question/%s";
        //问答的详情页相关推荐的接口地址
        public static final String QUESTION_RELATED_CONTENT = "http://v3.wufazhuce.com:8000/api/related/question/%s";
        //问答的详情页内评论内容的接口地址
        public static final String QUESTION_COMMENT_CONTENT = "http://v3.wufazhuce.com:8000/api/comment/praiseandtime/question/%s/0";

        //短篇的详情页内容的接口地址
        public static final String ESSAY_CONTENT = "http://v3.wufazhuce.com:8000/api/essay/%s";
        //短篇的详情页相关推荐的接口地址
        //public static final String ESSAY_RELATED_CONTENT = "http://v3.wufazhuce.com:8000/api/related/essay/%s";
        //短篇的详情页内评论内容的接口地址
        public static final String ESSAY_COMMENT_CONTENT = "http://v3.wufazhuce.com:8000/api/comment/praiseandtime/essay/%s/0";

    }

    public static class MUSIC {
        //获取音乐每个页面的数字号码的接口地址：
        public static final String MUSIC_PATH = "http://v3.wufazhuce.com:8000/api/music/idlist/0";
        //根据每个页面的数据号码得到音乐的具体信息的接口地址：
        public static final String MUSIC_DETAIL_PATH = "http://v3.wufazhuce.com:8000/api/music/detail/%s";//?表示每一页的数字号码
        //音乐评论接口地址
        public static final String MUSIC_COMMENT_PATH = "http://v3.wufazhuce.com:8000/api/comment/praiseandtime/music/%s/0?user_id=7398526&version=3.5.0&platform=android";


    }

    public static class MOVIE {
        //电影模块列表分页的接口地址：
        public static final String MOVIE_PATH = "http://v3.wufazhuce.com:8000/api/movie/list/%s";//?表示每页数量(0,48,96....)
        //电影详情页面故事的接口地址:
        public static final String MOVIE_DETAIL_STORY_PATH = "http://v3.wufazhuce.com:8000/api/movie/%s/story/1/0?user_id=7398526&version=3.5.0&platform=android";
        //电影详情页面故顶部接口地址:
        public static final String MOVIE_TOP_PATH = "http://v3.wufazhuce.com:8000/api/movie/detail/%s?user_id=7398526&version=3.5.0&platform=android";
        //电影详情页面评论的接口地址:
        public static final String MOVIE_COMMENT_PATH = "http://v3.wufazhuce.com:8000/api/comment/praiseandtime/movie/%s/0?user_id=7398526&version=3.5.0&platform=android";
    }

    public static class SEARCH {
        //首页图文搜索的接口地址：
        public static final String SEARCH_HP_PATH = "http://v3.wufazhuce.com:8000/api/search/hp/%s?user_id=7398526&version=3.5.0&platform=android";
        //阅读的搜索的接口地址:
        public static final String SEARCH_READING_PATH = "http://v3.wufazhuce.com:8000/api/search/reading/%s?user_id=7398526&version=3.5.0&platform=android";
        //音乐的搜索接口地址:
        public static final String SEARCH_MUSIC_PATH = "http://v3.wufazhuce.com:8000/api/search/music/%s?user_id=7398526&version=3.5.0&platform=android";
        //电影搜索的接口地址:
        public static final String SEARCH_MOVIE_PATH = "http://v3.wufazhuce.com:8000/api/search/movie/%s?user_id=7398526&version=3.5.0&platform=android";
        //作者/音乐人的搜索接口
        public static final String SEARCH_AUTHOR_PATH = "http://v3.wufazhuce.com:8000/api/search/author/%s?user_id=7398526&version=3.5.0&platform=android";
    }

}
