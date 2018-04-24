package com.example.a59682.myapplicationtest2018421;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
/**
 * @name BackgroundActivity
 * @description 背景界面操作
 * @author 59682
 */
public class BackgroundActivity extends AppCompatActivity {

    private Button button_one;
    private Button button_two;
    private Button button_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* 隐藏标题栏 */
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_background);

        assignViews();
        initListener();
    }
    /**
     * @description: 获取组件
     */
    private void assignViews(){
        button_one=findViewById(R.id.button_one);
        button_two=findViewById(R.id.button_two);
        button_three=findViewById(R.id.button_three);
    }
    /**
     * @description: 设置点击事件-->对应不同的activity
     */
    private void initListener(){
        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建Intent对象
                Intent intent = new Intent();
                // 设置要跳转的页面
                intent.setClass(BackgroundActivity.this, UploadActivity.class);
                // 开始Activity
                startActivity(intent);
            }
        });
        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建Intent对象
                Intent intent = new Intent();
                // 设置要跳转的页面
                intent.setClass(BackgroundActivity.this, PhotoActivity.class);
                // 开始Activity
                startActivity(intent);
            }
        });
        button_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建Intent对象
                Intent intent = new Intent();
                // 设置要跳转的页面
                intent.setClass(BackgroundActivity.this, DynamicActivity.class);
                // 开始Activity
                startActivity(intent);
            }
        });
    }
}
