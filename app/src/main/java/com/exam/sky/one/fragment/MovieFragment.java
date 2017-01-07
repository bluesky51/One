package com.exam.sky.one.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.exam.sky.one.R;
import com.exam.sky.one.activity.MoveDetailActivity;
import com.exam.sky.one.adapter.MovieAdapter;
import com.exam.sky.one.bean.movie.Movie;
import com.exam.sky.one.callback.DataCallback;
import com.exam.sky.one.constants.Constants;
import com.exam.sky.one.http.HttpUtils;
import com.exam.sky.one.view.AutoRefreshListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements DataCallback {

    @BindView(R.id.movie_listview)
    AutoRefreshListView movie_listview;
    private Context ctx;
    private MovieAdapter movieAdapter;
    private Handler handler = new Handler();
    int page = 0;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ctx = context;
    }

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        ButterKnife.bind(this, view);
        movieAdapter = new MovieAdapter(ctx);
        movie_listview.setAdapter(movieAdapter);
        movie_listview.setCallBack(new AutoRefreshListView.RefreshCallBack() {
            @Override
            public void onRefreshing() {
                Log.e("HHHHHHH", "加载数据啦");
                page += 48;
                getData(page);

            }
        });
        getData(page);
        return view;
    }

    public void getData(int page) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.getStrByNetWork(0, String.format(Constants.MOVIE.MOVIE_PATH, page), handler);
        httpUtils.setDataCallback(this);
    }

    @Override
    public void setDataCallback(int type, String s) {
        if (type == 0 && !TextUtils.isEmpty(s)) {
            Movie movie = JSON.parseObject(s, Movie.class);
            List<Movie.DataBean> dataBeanList = movie.getData();
            if (dataBeanList != null) {
                movieAdapter.setDataBeenList(dataBeanList);
                movieAdapter.notifyDataSetChanged();
                movie_listview.loadComplete();
            } else {
                Toast.makeText(ctx, "没有更多数据了", Toast.LENGTH_LONG).show();
                movie_listview.loadingFail();
            }

        }
    }


    @OnItemClick(R.id.movie_listview)
    public void itemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Movie.DataBean dataBean = movieAdapter.getItem(position);
        Intent intent = new Intent(ctx, MoveDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("id", dataBean.getId());
        bundle.putString("title", dataBean.getTitle());
        bundle.putString("score", dataBean.getScore());
        intent.putExtra("bundle", bundle);
        intent.putExtra("MovieDataBean", bundle);
        startActivity(intent);

    }

}
