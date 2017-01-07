package com.exam.sky.one.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.exam.sky.one.R;
import com.exam.sky.one.activity.ADDetailActivity;
import com.exam.sky.one.adapter.MainViewPagerAdapter;
import com.exam.sky.one.adapter.ReadAdAdapter;
import com.exam.sky.one.bean.MainReadAdData;
import com.exam.sky.one.bean.MainReadContentData;
import com.exam.sky.one.callback.AdClickCallBack;
import com.exam.sky.one.callback.DataCallback;
import com.exam.sky.one.constants.Constants;
import com.exam.sky.one.http.HttpUtils;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadingFragment extends Fragment implements DataCallback, AdClickCallBack {

    AutoScrollViewPager viewPager_Ad;
    ViewPager viewPager_Content;
    LinearLayout layout_point_container;
    Handler handler =new Handler();
    public ReadingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reading, container, false);
        layout_point_container = (LinearLayout) view.findViewById(R.id.layout_point_container);
        viewPager_Ad = (AutoScrollViewPager) view.findViewById(R.id.read_ad);
        viewPager_Content = (ViewPager) view.findViewById(R.id.read_content);

        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.getStrByNetWork(0,  Constants.READING.READING_AD_PATH,handler);
        httpUtils.getStrByNetWork(1, Constants.READING.READING_CONTENT_PATH,handler);
        httpUtils.setDataCallback(this);


        return view;
    }


    @Override
    public void setDataCallback(int type, String s) {
        if (type == 0) {
            //表示广告轮播的数据
            initAdData(s);
        }
        if (type == 1) {
            //表示底部滑动页面的数据
            MainReadContentData contentData = JSON.parseObject(s, MainReadContentData.class);
            //短篇连载问答数据条数一样，随便选择一个
            int size = contentData.getData().getSerial().size();
            List<Fragment> fragmentList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                ReadChildFragment childFragment = new ReadChildFragment();
                Bundle b = new Bundle();
                b.putInt("pos", i);
                b.putParcelable("contentData", contentData);
                childFragment.setArguments(b);
                fragmentList.add(childFragment);
                viewPager_Content.setAdapter(new MainViewPagerAdapter(getFragmentManager(), fragmentList));
            }

        }
    }


    public void initAdData(String s) {
        MainReadAdData adData = JSON.parseObject(s, MainReadAdData.class);
        List<MainReadAdData.DataBean> dataBeanList = adData.getData();
        List<View> viewList = new ArrayList<>();
        for (int i = 0; i < dataBeanList.size(); i++) {
            ImageView img = new ImageView(getActivity());
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.with(getActivity()).load(dataBeanList.get(i).getCover())
                    .config(Bitmap.Config.RGB_565)
                    .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .placeholder(R.mipmap.default_hp_image).into(img);
            viewList.add(img);

            ImageView img_point = new ImageView(getActivity());
            img_point.setPadding(10, 0, 10, 0);
            if (i == 0) {
                img_point.setImageResource(R.drawable.indicator_point_pressed);
            } else {
                img_point.setImageResource(R.drawable.indicator_point_default);
            }
            layout_point_container.addView(img_point);
        }
        ReadAdAdapter adAdapter = new ReadAdAdapter(viewList, dataBeanList);
        viewPager_Ad.setAdapter(adAdapter);
        adAdapter.setAdClickCallBack(this);
        viewPager_Ad.startAutoScroll();
        viewPager_Ad.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int count = layout_point_container.getChildCount();
                for (int i = 0; i < count; i++) {
                    ImageView img = (ImageView) layout_point_container.getChildAt(i);
                    if (i == position) {
                        img.setImageResource(R.drawable.indicator_point_pressed);
                    } else {
                        img.setImageResource(R.drawable.indicator_point_default);
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void setAdClickCallBack(MainReadAdData.DataBean dataBean) {
        Intent intent = new Intent(getActivity(), ADDetailActivity.class);
        intent.putExtra("dataBean", dataBean);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.up_in,R.anim.ani);
    }

}
