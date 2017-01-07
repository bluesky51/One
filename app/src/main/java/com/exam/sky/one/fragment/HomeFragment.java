package com.exam.sky.one.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements DataCallback {
    ViewPager vp;

    Handler handler =new Handler();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        vp = (ViewPager) view.findViewById(R.id.main_hp_vp);
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.getStrByNetWork(0,Constants.HOME.HOME_PATH,handler);
        httpUtils.setDataCallback(this);
        return view;
    }

    @Override
    public void setDataCallback(int type, final String s) {
        try {
            JSONObject object = new JSONObject(s);
            JSONArray array = object.getJSONArray("data");
            int count = array.length();
            final List<Fragment> fragmentList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String id = array.getString(i);
                HomeChildFragment child = new HomeChildFragment();
                Bundle b = new Bundle();
                b.putString("hp_id", id);
                child.setArguments(b);
                fragmentList.add(child);
            }
            vp.setAdapter(new MainViewPagerAdapter(getFragmentManager(), fragmentList));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
