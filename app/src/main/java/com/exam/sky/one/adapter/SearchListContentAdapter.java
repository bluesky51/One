package com.exam.sky.one.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.exam.sky.one.R;
import com.exam.sky.one.bean.search.AuthorBean;
import com.exam.sky.one.bean.search.MainHpBean;
import com.exam.sky.one.bean.search.MovieBean;
import com.exam.sky.one.bean.search.MusicBean;
import com.exam.sky.one.bean.search.ReadingBean;
import com.exam.sky.one.callback.SearchItemClickCallBack;
import com.exam.sky.one.utils.DpTransformSpUtils;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BlueSky on 16/12/26.
 */

public class SearchListContentAdapter<T> extends RecyclerView.Adapter<SearchListContentAdapter.SearchViewHolder> {

    List<T> list = new ArrayList<>();
    Context context;
    LayoutInflater inflater;
    int type;
    SearchItemClickCallBack searchItemClickCallBack;
    public SearchListContentAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setSearchItemClickCallBack(SearchItemClickCallBack searchItemClickCallBack) {
        this.searchItemClickCallBack = searchItemClickCallBack;
    }

    public void setList(List<T> list, int type) {
        this.list = list;
        this.type = type;
        notifyDataSetChanged();
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_search3, parent, false);

        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SearchViewHolder holder, int position) {
        final T t = list.get(position);
        switch (type) {
            case 0:
                MainHpBean.DataBean hpBean = (MainHpBean.DataBean) t;
                holder.tv_title.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, 0, 1));
                holder.tv_content.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, 0, 1));
                holder.tv_title.setText(hpBean.getHp_author());
                holder.tv_content.setText(hpBean.getHp_content());
                holder.tv_content.setVisibility(View.VISIBLE);
                holder.tv_title.setTextColor(Color.parseColor("#99878787"));
                holder.tv_content.setTextColor(Color.parseColor("#99878787"));
                holder.img_circle_cover.setVisibility(View.GONE);
                holder.img_cover.setVisibility(View.VISIBLE);
                Picasso.with(context).load(hpBean.getHp_img_url())
                        .placeholder(R.mipmap.head)
                        .config(Bitmap.Config.RGB_565)
                        .memoryPolicy(MemoryPolicy.NO_CACHE)
                        .into(holder.img_cover);
                break;
            case 1:
                ReadingBean.DataBean rdBean = (ReadingBean.DataBean) t;
                holder.tv_title.setText(rdBean.getTitle());
                holder.tv_content.setVisibility(View.GONE);
                holder.tv_title.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, 0, 1));
                holder.tv_content.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0));
                holder.tv_title.setTextColor(Color.parseColor("#99878787"));
                holder.img_circle_cover.setVisibility(View.GONE);
                holder.img_cover.setVisibility(View.VISIBLE);
                if ("essay".equals(rdBean.getType())) {
                    holder.img_cover.setImageResource(R.mipmap.essay_image);
                } else if ("serial".equals(rdBean.getType())) {
                    holder.img_cover.setImageResource(R.mipmap.serial_image);
                } else if ("question".equals(rdBean.getType())) {
                    holder.img_cover.setImageResource(R.mipmap.question_image);
                }

                break;
            case 2:
                MusicBean.DataBean mcBean = (MusicBean.DataBean) t;
                holder.tv_title.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, 0, 1));
                holder.tv_content.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, 0, 1));
                holder.tv_title.setText(mcBean.getTitle());
                holder.tv_title.setTextColor(Color.parseColor("#99878787"));
                holder.tv_content.setText(mcBean.getAuthor().getUser_name());
                holder.tv_content.setVisibility(View.VISIBLE);
                holder.tv_content.setTextColor(Color.parseColor("#00ffff"));
                holder.img_circle_cover.setVisibility(View.GONE);
                holder.img_cover.setVisibility(View.VISIBLE);
                Picasso.with(context).load(mcBean.getAuthor().getWeb_url())
                        .placeholder(R.mipmap.head)
                        .config(Bitmap.Config.RGB_565)
                        .memoryPolicy(MemoryPolicy.NO_CACHE)
                        .into(holder.img_cover);
                break;
            case 3:
                MovieBean.DataBean mvBean = (MovieBean.DataBean) t;
                holder.tv_title.setText(mvBean.getTitle());
                holder.tv_content.setVisibility(View.GONE);
                holder.tv_title.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, 0, 1));
                holder.tv_content.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0));
                holder.tv_title.setTextColor(Color.parseColor("#99878787"));
                holder.img_circle_cover.setVisibility(View.GONE);
                holder.img_cover.setVisibility(View.VISIBLE);
                holder.img_cover.setImageResource(R.mipmap.search_movie);
                break;
            case 4:
                AuthorBean.DataBean arBean = (AuthorBean.DataBean) t;
                holder.tv_title.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, 0, 1));
                holder.tv_content.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, 0, 1));
                holder.tv_title.setText(arBean.getUser_name());
                holder.tv_title.setTextColor(Color.parseColor("#00ffff"));
                holder.tv_content.setText(arBean.getDesc());
                holder.tv_content.setVisibility(View.VISIBLE);
                holder.tv_content.setTextColor(Color.parseColor("#99878787"));
                holder.img_circle_cover.setVisibility(View.VISIBLE);
                holder.img_cover.setVisibility(View.GONE);
                holder.layout.setPadding(DpTransformSpUtils.dip2px(context,70),0, 0,0);
                Picasso.with(context).load(arBean.getWeb_url())
                        .placeholder(R.mipmap.head)
                        .config(Bitmap.Config.RGB_565)
                        .memoryPolicy(MemoryPolicy.NO_CACHE)
                        .into(holder.img_circle_cover);
                break;
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchItemClickCallBack!=null){
                    searchItemClickCallBack.setSearchItemClickCallBack(t,holder.getLayoutPosition(),type);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class SearchViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_cover)
        ImageView img_cover;
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.img_right)
        ImageView img_right;
        @BindView(R.id.tv_content)
        TextView tv_content;
        @BindView(R.id.img_circle_cover)
        ImageView img_circle_cover;
        @BindView(R.id.lll)
        LinearLayout layout;

        public SearchViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
