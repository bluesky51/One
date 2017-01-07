package com.exam.sky.one.fragment;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.exam.sky.one.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlotFragment extends Fragment {

    ArrayList<String> photoList;

    @BindView(R.id.horizontalScrollView_content)
    LinearLayout horizontalScrollView_content;

    Context ctx;
    public PlotFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ctx =context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photoList = getArguments().getStringArrayList("photoList");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plot, container, false);
        ButterKnife.bind(this,view);

        for (int i = 0; i < photoList.size(); i++) {
            ImageView img = new ImageView(ctx);
            img.setLayoutParams(new LinearLayout.LayoutParams(260,260));
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.with(ctx).load(photoList.get(i))
                    .placeholder(R.mipmap.ic_launcher)
                    .config(Bitmap.Config.RGB_565)
                    .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .resize(260,260)
                    .centerCrop()
                    .into(img);
            horizontalScrollView_content.addView(img);
        }

        return view;
    }

}
