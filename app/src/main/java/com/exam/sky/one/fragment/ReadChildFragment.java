package com.exam.sky.one.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.exam.sky.one.R;
import com.exam.sky.one.activity.EssayDetailActivity;
import com.exam.sky.one.activity.QuestionActivity;
import com.exam.sky.one.activity.SerialDetailActivity;
import com.exam.sky.one.adapter.ReadContentAdapter;
import com.exam.sky.one.bean.MainReadBean;
import com.exam.sky.one.bean.MainReadContentData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadChildFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    // 标志位，标志已经初始化完成。
    private boolean isPrepared;

    MainReadContentData contentData;
    int pos;

    ListView listView;
    ReadContentAdapter readContentAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos = getArguments().getInt("pos");
        contentData = getArguments().getParcelable("contentData");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_read_child, null);
        listView = (ListView) view.findViewById(R.id.read_listview);
        listView.setOnItemClickListener(this);
        isPrepared = true;
        lazyLoad();
        return view;
    }


    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        MainReadContentData.DataBean.SerialBean serialBean = contentData.getData().getSerial().get(pos);
        MainReadContentData.DataBean.QuestionBean questionBean = contentData.getData().getQuestion().get(pos);
        MainReadContentData.DataBean.EssayBean essayBean = contentData.getData().getEssay().get(pos);

        List<MainReadBean> objList = new ArrayList<>();

        MainReadBean readBean = new MainReadBean();
        readBean.setType(0);
        readBean.setObject(essayBean);
        objList.add(readBean);

        MainReadBean readBean2 = new MainReadBean();
        readBean2.setType(1);
        readBean2.setObject(serialBean);
        objList.add(readBean2);

        MainReadBean readBean3 = new MainReadBean();
        readBean3.setType(2);
        readBean3.setObject(questionBean);
        objList.add(readBean3);

        readContentAdapter = new ReadContentAdapter(objList, getActivity());
        listView.setAdapter(readContentAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent =new Intent();
        int type = readContentAdapter.getItem(position).getType();
        Object object = readContentAdapter.getItem(position).getObject();
        switch (type) {
            case 0:
                MainReadContentData.DataBean.EssayBean essay = (MainReadContentData.DataBean.EssayBean) object;
                String   content_id =   essay.getContent_id();
                intent.putExtra("id",content_id);
                intent.setClass(getActivity(), EssayDetailActivity.class);
                break;
            case 1:
                MainReadContentData.DataBean.SerialBean serial = (MainReadContentData.DataBean.SerialBean) object;
                String  serialId = serial.getId();
                intent.putExtra("id",serialId);
                intent.setClass(getActivity(), SerialDetailActivity.class);
                break;
            case 2:
                MainReadContentData.DataBean.QuestionBean question = (MainReadContentData.DataBean.QuestionBean) object;
                String question_id = question.getQuestion_id();
                intent.putExtra("id",question_id);
                intent.setClass(getActivity(), QuestionActivity.class);
                break;
        }
        startActivity(intent);


    }
}
