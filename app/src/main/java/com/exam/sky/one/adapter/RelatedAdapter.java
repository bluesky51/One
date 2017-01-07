package com.exam.sky.one.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.exam.sky.one.R;
import com.exam.sky.one.bean.question.QuestionRelated;
import com.exam.sky.one.bean.serial.SerialRelated;

import java.util.List;

/**
 * Created by bluesky on 16/9/20.
 */
public class RelatedAdapter extends BaseAdapter {
    List<?> objectList;
    Context context;

    int type;
    public RelatedAdapter(List<?> objectList, Context context) {
        this.objectList = objectList;
        this.context = context;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getCount() {
        return objectList.size();
    }

    @Override
    public Object getItem(int position) {
        return objectList.get(position);
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
        Object obj = objectList.get(position);
        if (type==0){
            //连载相关
            SerialRelated.DataBean dataBean = ( SerialRelated.DataBean) obj;
            viewHolder.img_type.setImageResource(R.mipmap.serial_image);
            viewHolder.tv_title.setText(dataBean.getTitle());
            viewHolder.tv_author.setText(dataBean.getAuthor().getUser_name());
            viewHolder.tv_content.setText(dataBean.getExcerpt());

        }else if (type==1){
            //问题相关
            QuestionRelated.DataBean dataBean = ( QuestionRelated.DataBean) obj;
            viewHolder.img_type.setImageResource(R.mipmap.question_image);
            viewHolder.tv_title.setText(dataBean.getQuestion_title());
            viewHolder.tv_author.setText(dataBean.getAnswer_title());
            viewHolder.tv_content.setText(dataBean.getAnswer_content());

        }
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
            itemView.setTag(this);
        }
    }
}
