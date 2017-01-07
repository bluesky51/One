package com.exam.sky.one.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.exam.sky.one.R;
import com.exam.sky.one.activity.ShareActivity;
import com.exam.sky.one.bean.MainHomeDetailData;
import com.exam.sky.one.callback.DataCallback;
import com.exam.sky.one.constants.Constants;
import com.exam.sky.one.http.HttpUtils;
import com.exam.sky.one.utils.BitmapUtils;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeChildFragment extends BaseFragment implements DataCallback, View.OnClickListener {


    String hp_id = "";

    TextView tv_title;
    TextView tv_date;
    ImageView imageView;
    TextView tv_content;
    TextView tv_author;
    TextView tv_like;
    TextView tv_share;
    //图片的网络路径
    String imgPath = "";
    //保存图片的文件名称
    String fileName = "";
    //保存图片的本地路径
    String LocalPath = "";
    // 标志位，标志已经初始化完成。
    private boolean isPrepared;
    Handler handler = new Handler();

    public HomeChildFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hp_id = getArguments().getString("hp_id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_child, container, false);
        findView(view);
        //XXX初始化view的各控件
        isPrepared = true;
        lazyLoad();
        return view;
    }


    public void findView(View view) {
        tv_title = (TextView) view.findViewById(R.id.tv_author);
        tv_date = (TextView) view.findViewById(R.id.tv_date);
        tv_content = (TextView) view.findViewById(R.id.tv_content1);
        tv_author = (TextView) view.findViewById(R.id.tv_date);
        tv_like = (TextView) view.findViewById(R.id.tv_like1);
        tv_share = (TextView) view.findViewById(R.id.tv_share);
        tv_share.setOnClickListener(this);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_img, null);
                ImageView imageView = (ImageView) view.findViewById(R.id.imageView2);
                imageView.setImageBitmap(BitmapFactory.decodeFile(LocalPath));
                builder.setView(view);
                AlertDialog dialog = builder.create();
                dialog.show();

                Window win = dialog.getWindow();
                win.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams lp = win.getAttributes();
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                win.setAttributes(lp);

                win.setBackgroundDrawableResource(android.R.color.transparent);
                win.setWindowAnimations(R.style.HomeImgAnimations);
                imageView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(final View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setTitle("更多操作");
                        builder.setItems(new CharSequence[]{"保存到图库", "取消"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        //保存文件到图库
                                        BitmapUtils.insertImgStore(getActivity(), LocalPath, fileName);
                                        Toast.makeText(getActivity(), "保存路径为：" + LocalPath, Toast.LENGTH_SHORT).show();
                                        break;
                                    case 1:
                                        dialog.dismiss();
                                        break;
                                }
                            }
                        });
                        builder.create().show();
                        return true;
                    }
                });

            }
        });
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }

            //填充各控件的数据
            HttpUtils httpUtils = HttpUtils.getHttpUtils();
            httpUtils.getStrByNetWork(0, String.format(Constants.HOME.HOME_DETAIL_PATH, hp_id), handler);
            httpUtils.setDataCallback(this);

    }

    @Override
    public void setDataCallback(int type, String s) {

        MainHomeDetailData mainHomeDetailData = JSON.parseObject(s, MainHomeDetailData.class);
        setData(mainHomeDetailData.getData());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_share:
                Intent intent = new Intent(getActivity(), ShareActivity.class);
                intent.putExtra("path", String.format(Constants.HOME.HOME_DETAIL_PATH, hp_id));
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.up_in, 0);
                break;
        }
    }


    public void setData(MainHomeDetailData.DataBean dataBean) {
        imgPath = dataBean.getHp_img_original_url();
        fileName = BitmapUtils.getFileName(imgPath);
        Picasso.with(getActivity()).load(imgPath)
                .transform(new Transformation() {
                    @Override
                    public Bitmap transform(Bitmap source) {
                        //保存文件到本地
                        String path = BitmapUtils.saveImageToSDCard(source, fileName);
                        Bitmap bmp = BitmapUtils.getBitmapByPath(path);
                        LocalPath = BitmapUtils.saveImageToSDCard(bmp, fileName);
                        if (bmp != source) {
                            source.recycle();
                            source = null;
                        }
                        return bmp;
                    }

                    @Override
                    public String key() {
                        return imgPath;
                    }
                })
                .config(Bitmap.Config.RGB_565).memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(imageView);
        tv_title.setText(dataBean.getHp_title());
        tv_author.setText(dataBean.getHp_author());
        String date = dataBean.getHp_makettime();
        tv_date.setText(date);
        tv_content.setText(dataBean.getHp_content());
        tv_like.setText(String.valueOf(dataBean.getPraisenum()));
    }

}
