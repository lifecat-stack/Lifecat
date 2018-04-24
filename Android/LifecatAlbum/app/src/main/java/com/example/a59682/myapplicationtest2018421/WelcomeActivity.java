package com.example.a59682.myapplicationtest2018421;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * @name: WelcomeActivity
 * @description: 欢迎动画界面
 * @author: 59682
 */
public class WelcomeActivity extends AppCompatActivity {

    private ViewPager vp;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private Button bt_start;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* 隐藏标题栏 */
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        /* 隐藏状态栏 */
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        assignViews();
        initListener();
        initData();
        initView();
    }
    /**
     * @description: 获取组件
     */
    private void assignViews() {
        vp = (ViewPager) findViewById(R.id.vp);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv3 = (ImageView) findViewById(R.id.iv3);
        bt_start = (Button) findViewById(R.id.bt_start);
    }
    /**
     * @description: 设置点击事件-->进入LoginActivity
     */
    private void initListener(){
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建Intent对象
                Intent intent = new Intent();
                // 设置要跳转的页面
                intent.setClass(WelcomeActivity.this, LoginActivity.class);
                // 开始Activity
                startActivity(intent);
            }
        });
    }
    /**
     * @description: 初始化数据,添加三个Fragment
     */
    private void initData() {
        fragments = new ArrayList<>();

        Fragment fragment1 = new GuildFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("index", 1);
        fragment1.setArguments(bundle1);
        fragments.add(fragment1);

        Fragment fragment2 = new GuildFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("index", 2);
        fragment2.setArguments(bundle2);
        fragments.add(fragment2);

        Fragment fragment3 = new GuildFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putInt("index", 3);
        fragment3.setArguments(bundle3);
        fragments.add(fragment3);
    }
    /**
     * @description: 设置ViewPager的适配器和滑动监听
     */
    private void initView() {
        vp.setOffscreenPageLimit(3);
        vp.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        vp.addOnPageChangeListener(new MyPageChangeListener());
    }
    /**
     * @description: ViewPager适配器
     */
    private class MyPageAdapter extends FragmentPagerAdapter {


        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
    /**
     * @description: ViewPager滑动页面监听器
     */
    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
        /**
         * 根据页面不同动态改变红点和在最后一页显示立即体验按钮
         *
         * @param position
         */
        @Override
        public void onPageSelected(int position) {
            bt_start.setVisibility(View.GONE);
            iv1.setImageResource(R.mipmap.dot_normal);
            iv2.setImageResource(R.mipmap.dot_normal);
            iv3.setImageResource(R.mipmap.dot_normal);
            if (position == 0) {
                iv1.setImageResource(R.mipmap.dot_focus);
            } else if (position == 1) {
                iv2.setImageResource(R.mipmap.dot_focus);
            } else {
                iv3.setImageResource(R.mipmap.dot_focus);
                bt_start.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
