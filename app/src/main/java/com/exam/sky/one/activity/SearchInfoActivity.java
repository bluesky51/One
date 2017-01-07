package com.exam.sky.one.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.exam.sky.one.R;
import com.exam.sky.one.fragment.HomeChildFragment;
import com.exam.sky.one.fragment.MusicChildFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchInfoActivity extends AppCompatActivity {

    @BindView(R.id.tv_detail_title)
    TextView tv_detail_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_info);
        ButterKnife.bind(this);
        int type = getIntent().getIntExtra("type", 0);
        String id = getIntent().getStringExtra("id");
        switch (type) {
            case 0:
                tv_detail_title.setText("图文");
                HomeChildFragment homeChildFragment = new HomeChildFragment();
                Bundle b = new Bundle();
                b.putString("hp_id", id);
                homeChildFragment.setArguments(b);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.activity_search_info, homeChildFragment).commit();
                break;
            case 2:
                tv_detail_title.setText("单曲");
                MusicChildFragment musicChildFragment = new MusicChildFragment();
                Bundle b1 = new Bundle();
                b1.putString("music_id", id);
                musicChildFragment.setArguments(b1);
                getSupportFragmentManager().beginTransaction()

                        .add(R.id.activity_search_info, musicChildFragment).commit();
                break;
        }
    }

    public void back(View view) {
        finish();
    }

}
