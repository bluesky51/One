package com.exam.sky.one.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.exam.sky.one.R;
import com.exam.sky.one.bean.movie.Movie;
import com.exam.sky.one.view.RotateTextView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BlueSky on 16/12/24.
 */

public class MovieAdapter extends BaseAdapter {
    List<Movie.DataBean> dataBeenList = new ArrayList<>();
    Context context;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public void setDataBeenList(List<Movie.DataBean> dataBeenList1) {
        this.dataBeenList.addAll(dataBeenList1);
    }

    @Override
    public int getCount() {
        return dataBeenList.size();
    }

    @Override
    public Movie.DataBean getItem(int position) {
        return dataBeenList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieViewHolder movieViewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.adapter_movie,parent,false);
            movieViewHolder=new MovieViewHolder(convertView);
            convertView.setTag(movieViewHolder);
        }else{
            movieViewHolder = (MovieViewHolder) convertView.getTag();
        }
        movieViewHolder.textView.setDegrees(330);
        movieViewHolder.textView.setText(dataBeenList.get(position).getScore());
        movieViewHolder.textView.setTypeface(Typeface.createFromAsset(
                context.getAssets(),"BradBold.ttf"
        ));
        movieViewHolder.textView.getPaint().setFlags(TextPaint.UNDERLINE_TEXT_FLAG);
        Picasso.with(context).load(dataBeenList.get(position).getCover())
                .placeholder(R.mipmap.default_hp_image)
                .config(Bitmap.Config.RGB_565)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(movieViewHolder.imageView);
        return convertView;
    }

    static class MovieViewHolder {
        @BindView(R.id.imageView3)
        ImageView imageView;
        @BindView(R.id.score)
        RotateTextView textView;
        View itemView;

        public MovieViewHolder(View itemView) {
            this.itemView = itemView;
            ButterKnife.bind(this,itemView);
        }
    }
}
