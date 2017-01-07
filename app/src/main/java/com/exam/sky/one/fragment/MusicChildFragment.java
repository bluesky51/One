package com.exam.sky.one.fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.exam.sky.one.R;
import com.exam.sky.one.adapter.MusicCommentAdapter;
import com.exam.sky.one.bean.MusicComment;
import com.exam.sky.one.bean.MusicDetailData;
import com.exam.sky.one.callback.DataCallback;
import com.exam.sky.one.constants.Constants;
import com.exam.sky.one.http.HttpUtils;
import com.exam.sky.one.utils.DisplayUtils;
import com.exam.sky.one.view.CustomListView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.alibaba.fastjson.JSON.parseObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicChildFragment extends BaseFragment implements DataCallback,
        RadioGroup.OnCheckedChangeListener {

    String music_id;
    Context ctx;
    Handler handler = new Handler();
    @BindView(R.id.music_cover)
    ImageView img_music_cover;
    @BindView(R.id.tv_story_title)
    TextView tv_story_title;
    @BindView(R.id.tv_story_author)
    TextView tv_story_author;
    @BindView(R.id.tv_content1)
    TextView tv_content;
    @BindView(R.id.tv_tip)
    TextView tv_tip;

    @BindView(R.id.music_head)
    CircleImageView music_head;
    @BindView(R.id.tv_author_userName)
    TextView tv_author_userName;
    @BindView(R.id.tv_author_desc)
    TextView tv_author_desc;
    @BindView(R.id.tv_story_title1)
    TextView tv_story_title1;
    @BindView(R.id.time)
    TextView tv_make_time;
    @BindView(R.id.rg_content)
    RadioGroup rg_content;
    MusicDetailData musicDetailData;
    @BindView(R.id.comment_Listview)
    CustomListView comment_Listview;

    @BindView(R.id.music_scrollView)
    ScrollView music_scrollView;
    // 标志位，标志已经初始化完成。
    private boolean isPrepared;

    public MusicChildFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        music_id = getArguments().getString("music_id");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ctx = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music_child, container, false);
        ButterKnife.bind(this, view);
        music_scrollView.smoothScrollTo(0, 0);
        rg_content.setOnCheckedChangeListener(this);
        //XXX初始化view的各控件
        isPrepared = true;
        lazyLoad();

        return view;
    }


    @Override
    public void setDataCallback(int type, String s) {
        switch (type) {
            case 0:
                musicDetailData = parseObject(s, MusicDetailData.class);
                if (musicDetailData != null) {
                    MusicDetailData.DataBean dataBean = musicDetailData.getData();
                    Picasso.with(ctx).load(dataBean.getCover())
                            .placeholder(R.mipmap.default_hp_image)
                            .memoryPolicy(MemoryPolicy.NO_CACHE)
                            .resize(DisplayUtils.getWindowWidth(getActivity()), DisplayUtils.getWindowHeight(getActivity()) / 2 - 100)
                            .centerCrop()
                            .into(img_music_cover);

                    tv_story_title.setText(dataBean.getStory_title());
                    tv_story_author.setText(dataBean.getStory_author().getUser_name());
                    tv_content.setText(Html.fromHtml(dataBean.getStory()));
                    tv_tip.setText(dataBean.getCharge_edt());
                    Picasso.with(ctx).load(dataBean.getAuthor().getWeb_url())
                            .placeholder(R.mipmap.default_hp_image)
                            .memoryPolicy(MemoryPolicy.NO_CACHE)
                            .resize(DisplayUtils.getWindowWidth(getActivity()), DisplayUtils.getWindowHeight(getActivity()) / 2 - 100)
                            .centerCrop()
                            .into(music_head);

                    tv_author_userName.setText(dataBean.getAuthor().getUser_name());
                    tv_author_desc.setText(dataBean.getAuthor().getDesc());
                    tv_story_title1.setText(dataBean.getTitle());
                    tv_make_time.setText(dataBean.getMaketime());
                }
                break;
            case 1:
                MusicComment musicComment = JSON.parseObject(s, MusicComment.class);
                List<MusicComment.DataBean.DataBeans> beanList = musicComment.getData().getData();
                MusicCommentAdapter adapter =
                        new MusicCommentAdapter(beanList, ctx);
                comment_Listview.setAdapter(adapter);

                break;
        }


    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.getStrByNetWork(0, String.format(Constants.MUSIC.MUSIC_DETAIL_PATH, music_id), handler);
        httpUtils.getStrByNetWork(1, String.format(Constants.MUSIC.MUSIC_COMMENT_PATH, music_id), handler);
        httpUtils.setDataCallback(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb1:
                ((RadioButton) group.getChildAt(0)).setChecked(true);
                if (musicDetailData != null) {
                    tv_content.setText(Html.fromHtml(musicDetailData.getData().getStory()));
                }
                break;
            case R.id.rb2:
                ((RadioButton) group.getChildAt(1)).setChecked(true);
                if (musicDetailData != null) {
                    String lyric = musicDetailData.getData().getLyric();
                    Log.e("===", "==lyric==" + lyric);
                    tv_content.setText(lyric);
                }
                break;
            case R.id.rb3:
                ((RadioButton) group.getChildAt(2)).setChecked(true);
                if (musicDetailData != null) {
                    String info = musicDetailData.getData().getInfo();
                    Log.e("===", "==info==" + info);
                    tv_content.setText(info);
                }
                break;
        }
    }
}
