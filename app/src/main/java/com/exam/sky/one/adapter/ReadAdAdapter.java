package com.exam.sky.one.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.exam.sky.one.bean.MainReadAdData;
import com.exam.sky.one.callback.AdClickCallBack;

import java.util.List;

/**
 * Created by bluesky on 16/9/20.
 */
public class ReadAdAdapter extends PagerAdapter {
    List<View> viewList;
    AdClickCallBack adClickCallBack;
    List<MainReadAdData.DataBean> dataBeanList;

    public ReadAdAdapter(List<View> viewList, List<MainReadAdData.DataBean> dataBeanList) {
        this.viewList = viewList;
        this.dataBeanList = dataBeanList;
    }

    public void setAdClickCallBack(AdClickCallBack adClickCallBack) {
        this.adClickCallBack = adClickCallBack;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        container.addView(viewList.get(position));
        viewList.get(position).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adClickCallBack!=null){
                    adClickCallBack.setAdClickCallBack(dataBeanList.get(position));
                }
            }
        });
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }
}
