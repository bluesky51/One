package com.exam.sky.one.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.exam.sky.one.R;
import com.exam.sky.one.bean.essay.EssayComment;
import com.exam.sky.one.bean.question.QuestionComment;
import com.exam.sky.one.bean.serial.SerialComment;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by bluesky on 16/9/20.
 */
public class ReadCommentAdapter extends BaseAdapter {
    List<?> data;
    Context context;
    int type;

    public ReadCommentAdapter(List<?> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_comment, null);
            viewHolder = new ViewHolder(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if ( type ==0){
           EssayComment.DataBean.DataBeans dataBeans = (EssayComment.DataBean.DataBeans) data.get(position);
            String path = dataBeans.getUser().getWeb_url();
            if (!TextUtils.isEmpty(path)){
                Picasso.with(context).load(path).into(viewHolder.img_head);
            }

            viewHolder.tv_author.setText(dataBeans.getUser().getUser_name());
            viewHolder.tv_content.setText(dataBeans.getContent());
            viewHolder.tv_date.setText(dataBeans.getInput_date());
        }else if (type==1){
            QuestionComment.DataBean.DataBeans dataBeans = (QuestionComment.DataBean.DataBeans) data.get(position);
            String path = dataBeans.getUser().getWeb_url();
            if (!TextUtils.isEmpty(path)){
                Picasso.with(context).load(path).into(viewHolder.img_head);
            }

            viewHolder.tv_author.setText(dataBeans.getUser().getUser_name());
            viewHolder.tv_content.setText(dataBeans.getContent());
            viewHolder.tv_date.setText(dataBeans.getInput_date());
        }else if (type==2){
            SerialComment.DataBean.DataBeans dataBeans = (SerialComment.DataBean.DataBeans) data.get(position);
            String path = dataBeans.getUser().getWeb_url();
            if (!TextUtils.isEmpty(path)){
                Picasso.with(context).load(path).into(viewHolder.img_head);
            }

            viewHolder.tv_author.setText(dataBeans.getUser().getUser_name());
            viewHolder.tv_content.setText(dataBeans.getContent());
            viewHolder.tv_date.setText(dataBeans.getInput_date());
        }

        return convertView;
    }

    class ViewHolder {
        TextView tv_author;
        TextView tv_date;
        TextView tv_content;
        ImageView img_head;
        View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
            img_head = (CircleImageView) itemView.findViewById(R.id.img_head);
            tv_author = (TextView) itemView.findViewById(R.id.tv_author);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content1);
            itemView.setTag(this);
        }
    }
}
