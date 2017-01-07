package com.exam.sky.one.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.exam.sky.one.R;
import com.exam.sky.one.fragment.HomeFragment;
import com.exam.sky.one.fragment.MovieFragment;
import com.exam.sky.one.fragment.MusicFragment;
import com.exam.sky.one.fragment.ReadingFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    HomeFragment homeFragment;
    ReadingFragment readingFragment;
    MusicFragment musicFragment;
    MovieFragment movieFragment;

    FragmentManager fragmentManager;
    RadioGroup radioGroup;

    ImageView img_home_title;
    TextView tv_base_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        img_home_title = (ImageView) findViewById(R.id.img_base_title);
        tv_base_title = (TextView) findViewById(R.id.tv_base_title);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)==-1){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE},100);
        }else{
            init();
        }

    }

    public void init(){
        radioGroup.setOnCheckedChangeListener(this);

        fragmentManager = getSupportFragmentManager();
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
        }
        fragmentManager.beginTransaction().add(R.id.rl__main_container, homeFragment).commit();
    }

    public void loginOrLookSelfInfo(View view) {
        startActivity(new Intent(MainActivity.this,PersonalCenterActivity.class));
    }

    public void search(View view) {
        startActivity(new Intent(MainActivity.this,SearchActivity.class));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        hide(ft);
        switch (checkedId) {
            case R.id.rb_home:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    ft.add(R.id.rl__main_container, homeFragment);
                } else {
                    ft.show(homeFragment);
                }
                img_home_title.setVisibility(View.VISIBLE);
                tv_base_title.setVisibility(View.GONE);
                break;
            case R.id.rb_reading:
                if (readingFragment == null) {
                    readingFragment = new ReadingFragment();
                    ft.add(R.id.rl__main_container, readingFragment);
                } else {
                    ft.show(readingFragment);
                }
                tv_base_title.setText("阅读");
                img_home_title.setVisibility(View.GONE);
                tv_base_title.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_music:
                if (musicFragment == null) {
                    musicFragment = new MusicFragment();
                    ft.add(R.id.rl__main_container, musicFragment);
                } else {
                    ft.show(musicFragment);
                }
                tv_base_title.setText("音乐");
                img_home_title.setVisibility(View.GONE);
                tv_base_title.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_movie:
                if (movieFragment == null) {
                    movieFragment = new MovieFragment();
                    ft.add(R.id.rl__main_container, movieFragment);
                } else {
                    ft.show(movieFragment);
                }
                tv_base_title.setText("电影");
                img_home_title.setVisibility(View.GONE);
                tv_base_title.setVisibility(View.VISIBLE);
                break;
        }
        ft.commit();
    }

    public void hide(FragmentTransaction ft) {
        if (homeFragment != null) {
            ft.hide(homeFragment);
        }
        if (readingFragment != null) {
            ft.hide(readingFragment);
        }
        if (musicFragment != null) {
            ft.hide(musicFragment);
        }
        if (movieFragment != null) {
            ft.hide(movieFragment);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==100){
            if (grantResults[0]==0&&grantResults[1]==0){
                init();
            }

        }
    }
}
