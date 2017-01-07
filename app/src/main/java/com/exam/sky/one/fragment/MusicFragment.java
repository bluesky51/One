package com.exam.sky.one.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exam.sky.one.R;
import com.exam.sky.one.adapter.MainViewPagerAdapter;
import com.exam.sky.one.callback.DataCallback;
import com.exam.sky.one.constants.Constants;
import com.exam.sky.one.http.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends Fragment implements DataCallback{

    @BindView(R.id.music_vp)
    ViewPager music_vp;

    Handler handler =new Handler();

    public MusicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        ButterKnife.bind(this, view);
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.getStrByNetWork(0, Constants.MUSIC.MUSIC_PATH,handler);
        httpUtils.setDataCallback(this);
        return view;
    }

    @Override
    public void setDataCallback(int type, String s) {
        try {
            JSONObject object = new JSONObject(s);
            JSONArray array = object.getJSONArray("data");
            int count = array.length();
            Log.e("=====","====count==="+count);
            final List<Fragment> fragmentList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String id = array.getString(i);
                MusicChildFragment child = new MusicChildFragment();
                Bundle b = new Bundle();
                b.putString("music_id", id);
                child.setArguments(b);
                fragmentList.add(child);
            }
            music_vp.setAdapter(new MainViewPagerAdapter(getFragmentManager(), fragmentList));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
