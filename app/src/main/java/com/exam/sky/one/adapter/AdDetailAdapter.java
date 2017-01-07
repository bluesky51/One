package com.exam.sky.one.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.exam.sky.one.R;
import com.exam.sky.one.bean.ReadAdDetailBean;

import java.util.List;

/**
 * Created by bluesky on 16/9/20.
 */
public class AdDetailAdapter extends BaseAdapter {
    List<ReadAdDetailBean.DataBean> adDetailBeanList;
    Context context;

    public AdDetailAdapter(List<ReadAdDetailBean.DataBean> adDetailBeanList, Context context) {
        this.adDetailBeanList = adDetailBeanList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return adDetailBeanList.size();
    }

    @Override
    public ReadAdDetailBean.DataBean getItem(int position) {
        return adDetailBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_item_reading, null);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ReadAdDetailBean.DataBean dataBean = adDetailBeanList.get(position);
        viewHolder.tv_title.setTextColor(Color.WHITE);
        viewHolder.tv_author.setTextColor(Color.WHITE);
        viewHolder.tv_content.setTextColor(Color.WHITE);
        viewHolder.tv_title.setText(position+dataBean.getTitle());
        viewHolder.tv_author.setText(dataBean.getAuthor());
        viewHolder.tv_content.setText(dataBean.getIntroduction());

        return convertView;
    }

    class ViewHolder {
        TextView tv_title;
        TextView tv_content;
        TextView tv_author;
        ImageView img_type;
        View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
            tv_title = (TextView) itemView.findViewById(R.id.tv_author);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content1);
            tv_author = (TextView) itemView.findViewById(R.id.tv_date);
            img_type = (ImageView) itemView.findViewById(R.id.img_type);
            img_type.setVisibility(View.GONE);
            itemView.setTag(this);
        }
    }
}
