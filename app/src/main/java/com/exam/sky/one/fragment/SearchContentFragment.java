package com.exam.sky.one.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.exam.sky.one.R;
import com.exam.sky.one.activity.AuthorActivity;
import com.exam.sky.one.activity.EssayDetailActivity;
import com.exam.sky.one.activity.MoveDetailActivity;
import com.exam.sky.one.activity.QuestionActivity;
import com.exam.sky.one.activity.SearchInfoActivity;
import com.exam.sky.one.activity.SerialDetailActivity;
import com.exam.sky.one.adapter.SearchListContentAdapter;
import com.exam.sky.one.bean.search.AuthorBean;
import com.exam.sky.one.bean.search.MainHpBean;
import com.exam.sky.one.bean.search.MovieBean;
import com.exam.sky.one.bean.search.MusicBean;
import com.exam.sky.one.bean.search.ReadingBean;
import com.exam.sky.one.callback.DataCallback;
import com.exam.sky.one.callback.SearchItemClickCallBack;
import com.exam.sky.one.constants.Constants;
import com.exam.sky.one.http.HttpUtils;

import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchContentFragment extends BaseFragment implements DataCallback,
        SearchItemClickCallBack {

    Context ctx;
    String key;
    int pos;
    Handler handler = new Handler();
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.loading)
    ImageView img_loading;
    SearchListContentAdapter contentAdapter;
    // 标志位，标志已经初始化完成。
    private boolean isPrepared;
    AnimationDrawable drawable;
    public SearchContentFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ctx = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        key = bundle.getString("key");
        pos = bundle.getInt("pos");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_content, container, false);
        ButterKnife.bind(this, view);
        drawable = (AnimationDrawable) img_loading.getDrawable();
        drawable.start();
        LinearLayoutManager manager = new LinearLayoutManager(ctx);
        recyclerView.setLayoutManager(manager);
        contentAdapter = new SearchListContentAdapter(ctx);
        recyclerView.setAdapter(contentAdapter);
        contentAdapter.setSearchItemClickCallBack(this);
        //XXX初始化view的各控件
        isPrepared = true;
        lazyLoad();
        return view;
    }

    @Override
    public void setDataCallback(int type, String s) {
        switch (type) {
            case 0:
                MainHpBean hpBean = JSON.parseObject(s, MainHpBean.class);
                contentAdapter.setList(hpBean.getData(), 0);
                break;
            case 1:
                ReadingBean readingBean = JSON.parseObject(s, ReadingBean.class);
                contentAdapter.setList(readingBean.getData(), 1);
                break;
            case 2:
                MusicBean musicBean = JSON.parseObject(s, MusicBean.class);
                contentAdapter.setList(musicBean.getData(), 2);
                break;
            case 3:
                MovieBean movieBean = JSON.parseObject(s, MovieBean.class);
                contentAdapter.setList(movieBean.getData(), 3);

                break;
            case 4:
                AuthorBean authorBean = JSON.parseObject(s, AuthorBean.class);
                contentAdapter.setList(authorBean.getData(), 4);
                break;
        }

        drawable.stop();
        img_loading.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        switch (pos) {
            case 0:
                httpUtils.getStrByNetWork(pos,
                        String.format(Constants.SEARCH.SEARCH_HP_PATH, URLEncoder.encode(key)),
                        handler);
                break;
            case 1:
                httpUtils.getStrByNetWork(pos,
                        String.format(Constants.SEARCH.SEARCH_READING_PATH, URLEncoder.encode(key)),
                        handler);
                break;
            case 2:
                httpUtils.getStrByNetWork(pos,
                        String.format(Constants.SEARCH.SEARCH_MUSIC_PATH, URLEncoder.encode(key)),
                        handler);
                break;
            case 3:
                httpUtils.getStrByNetWork(pos,
                        String.format(Constants.SEARCH.SEARCH_MOVIE_PATH, URLEncoder.encode(key)),
                        handler);
                break;
            case 4:
                httpUtils.getStrByNetWork(pos,
                        String.format(Constants.SEARCH.SEARCH_AUTHOR_PATH, URLEncoder.encode(key)),
                        handler);
                break;
        }

        httpUtils.setDataCallback(this);
    }

    @Override
    public void setSearchItemClickCallBack(Object b, int pos, int type) {
        Toast.makeText(ctx, "点击了位置" + pos, Toast.LENGTH_LONG).show();
        switch (type) {
            case 0:
                Intent intent = new Intent(ctx, SearchInfoActivity.class);
                intent.putExtra("type",type);
                intent.putExtra("obj",((MainHpBean.DataBean)b).getHpcontent_id());
                startActivity(intent);
                break;
            case 1:
                ReadingBean.DataBean dataBean1=(ReadingBean.DataBean)b;
                Intent intent1=null;
                String types = dataBean1.getType();
                if ("essay".equals(types)){
                    intent1= new Intent(ctx, EssayDetailActivity.class);
                } else if ("serial".equals(types)) {
                    intent1= new Intent(ctx, SerialDetailActivity.class);
                } else if ("question".equals(types)){
                    intent1= new Intent(ctx, QuestionActivity.class);
                }
                intent1.putExtra("id",dataBean1.getId());
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(ctx, SearchInfoActivity.class);
                intent2.putExtra("type",type);
                intent2.putExtra("id",((MusicBean.DataBean)b).getMusic_id());
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(ctx, MoveDetailActivity.class);
                MovieBean.DataBean dataBean3=(MovieBean.DataBean)b;
                Bundle bundle=new Bundle();
                bundle.putString("id",dataBean3.getId());
                bundle.putString("title",dataBean3.getTitle());
                bundle.putString("score",dataBean3.getScore());
                intent3.putExtra("bundle",bundle);
                startActivity(intent3);
                break;
            case 4:
                Intent intent4 = new Intent(ctx, AuthorActivity.class);
                AuthorBean.DataBean dataBean=(AuthorBean.DataBean)b;
                intent4.putExtra("data",dataBean);
                startActivity(intent4);
                break;
        }

    }
}
