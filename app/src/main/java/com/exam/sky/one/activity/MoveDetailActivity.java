package com.exam.sky.one.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.exam.sky.one.R;
import com.exam.sky.one.adapter.MovieCommentAdapter;
import com.exam.sky.one.bean.movie.MovieCommentDetail;
import com.exam.sky.one.bean.movie.MovieStoryDetail;
import com.exam.sky.one.bean.movie.MovieTopDetail;
import com.exam.sky.one.callback.DataCallback;
import com.exam.sky.one.constants.Constants;
import com.exam.sky.one.fragment.GrossFragment;
import com.exam.sky.one.fragment.PlotFragment;
import com.exam.sky.one.fragment.StillFragment;
import com.exam.sky.one.http.HttpUtils;
import com.exam.sky.one.utils.DisplayUtils;
import com.exam.sky.one.view.CustomListView;
import com.exam.sky.one.view.RotateTextView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MoveDetailActivity extends AppCompatActivity implements DataCallback,
        RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.tv_detail_title)
    TextView tv_title;
    @BindView(R.id.img_movie_detail_bg)
    ImageView img_movie_detail_bg;
    @BindView(R.id.score)
    RotateTextView tv_score;
    Handler handler = new Handler();


    @BindView(R.id.tv_movie_author)
    TextView tv_movie_author;
    @BindView(R.id.tv_movie_date)
    TextView tv_movie_date;
    @BindView(R.id.img_movie_head)
    CircleImageView img_movie_head;
    @BindView(R.id.tv_movie_like)
    TextView tv_movie_like;
    @BindView(R.id.tv_movie_title)
    TextView tv_movie_title;
    @BindView(R.id.web_movie_content)
    WebView web_movie_content;

    @BindView(R.id.rg_movie_extra_content)
    RadioGroup radioGroup;
    @BindView(R.id.movie_extraInfo)
    LinearLayout layout_movie_extraInfo;

    @BindView(R.id.movie_extra_title)
    TextView tv_movie_extra_title;

    FragmentManager fragmentManager;
    MovieStoryDetail movieStoryDetail;
    MovieTopDetail movieTopDetail;

    @BindView(R.id.comment_Listview)
    CustomListView comment_Listview;

    @BindView(R.id.movie_scrollview)
    ScrollView movie_scrollview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_detail);
        ButterKnife.bind(this);
        movie_scrollview.smoothScrollTo(0, 0);
        fragmentManager = getSupportFragmentManager();
        Bundle bundle = getIntent().getBundleExtra("bundle");
        tv_title.setText(bundle.getString("title"));
        tv_score.setText(bundle.getString("score"));
        tv_score.setDegrees(330);

        tv_score.setTypeface(Typeface.createFromAsset(
                getAssets(), "BradBold.ttf"
        ));
        tv_score.getPaint().setFlags(TextPaint.UNDERLINE_TEXT_FLAG);
        radioGroup.setOnCheckedChangeListener(this);
        getData(bundle.getString("id"));
    }

    @OnClick(R.id.img_movie_detail_bg)
    public void clickToPlayMovie(View view) {
        Intent intent = new Intent(this, MovieActivity.class);
        intent.putExtra("path",movieTopDetail.getData().getVideo());
        startActivity(intent);
    }


    public void getData(String id) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        //页面顶部内容请求
        httpUtils.getStrByNetWork(0, String.format(Constants.MOVIE.MOVIE_TOP_PATH, id), handler);
        //页面中间故事请求
        httpUtils.getStrByNetWork(1, String.format(Constants.MOVIE.MOVIE_DETAIL_STORY_PATH, id), handler);
        //页面底部评论请求
        httpUtils.getStrByNetWork(2, String.format(Constants.MOVIE.MOVIE_COMMENT_PATH, id), handler);
        httpUtils.setDataCallback(this);
    }

    public void back(View view) {
        finish();
    }

    @Override
    public void setDataCallback(int type, String s) {
        if (!TextUtils.isEmpty(s)) {
            switch (type) {
                case 0:
                    movieTopDetail = JSON.parseObject(s, MovieTopDetail.class);
                    Picasso.with(this).load(movieTopDetail.getData().getDetailcover())
                            .placeholder(R.mipmap.default_hp_image)
                            .memoryPolicy(MemoryPolicy.NO_CACHE)
                            .resize(DisplayUtils.getWindowWidth(this), DisplayUtils.getWindowHeight(this) / 3)
                            .centerCrop()
                            .into(img_movie_detail_bg);

                    String str = movieTopDetail.getData().getKeywords();
                    GrossFragment grossFragment = new GrossFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("keywords", str);
                    grossFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .replace(R.id.movie_extraInfo, grossFragment).commit();
                    break;
                case 1:
                    movieStoryDetail = JSON.parseObject(s, MovieStoryDetail.class);
                    MovieStoryDetail.DataBean.DataBeans dataBeans = movieStoryDetail.getData().getData().get(0);
                    tv_movie_author.setText(dataBeans.getUser().getUser_name());
                    String imgPath = dataBeans.getUser().getWeb_url();
                    if (!TextUtils.isEmpty(imgPath)) {
                        Picasso.with(this).load(imgPath)
                                .placeholder(R.mipmap.head)
                                .into(img_movie_head);
                    }
                    tv_movie_like.setText(String.valueOf(dataBeans.getPraisenum()));
                    tv_movie_date.setText(dataBeans.getInput_date());
                    tv_movie_title.setText(dataBeans.getTitle());
                    //更改webView中的字体大小
                    web_movie_content.getSettings().setTextZoom(70);
                    web_movie_content.loadDataWithBaseURL(null,
                            dataBeans.getContent(), "text/html", "utf-8", null);

                    break;
                case 2:
                    MovieCommentDetail movieCommentDetail = JSON.parseObject(s, MovieCommentDetail.class);

                    List<MovieCommentDetail.DataBean.DataBeans> beanList = movieCommentDetail.getData().getData();
                    MovieCommentAdapter adapter =
                            new MovieCommentAdapter(beanList, MoveDetailActivity.this);
                    comment_Listview.setAdapter(adapter);


                    break;
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId){
            switch (checkedId) {
                case R.id.rb1:
                    tv_movie_extra_title.setText("一个人～电影");
                    String str = movieTopDetail.getData().getKeywords();
                    GrossFragment grossFragment = new GrossFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("keywords", str);
                    grossFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .replace(R.id.movie_extraInfo, grossFragment).commit();
                    break;
                case R.id.rb2:
                    tv_movie_extra_title.setText("剧照");
                    ArrayList<String> photoList = movieTopDetail.getData().getPhoto();
                    PlotFragment plotFragment = new PlotFragment();
                    Bundle bundle1 = new Bundle();
                    bundle1.putStringArrayList("photoList", photoList);
                    plotFragment.setArguments(bundle1);
                    fragmentManager.beginTransaction()
                            .replace(R.id.movie_extraInfo, plotFragment).commit();
                    break;
                case R.id.rb3:
                    tv_movie_extra_title.setText("影片信息");
                    String info = movieTopDetail.getData().getInfo();
                    StillFragment stillFragment = new StillFragment();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("info", info);
                    stillFragment.setArguments(bundle2);
                    fragmentManager.beginTransaction()
                            .replace(R.id.movie_extraInfo, stillFragment).commit();
                    break;

            }

    }
}
