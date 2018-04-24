package com.example.a59682.myapplicationtest2018421;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;

/**
 * @name UploadActivity
 * @description 图片上传
 * @author 59682
 */
public class UploadActivity extends AppCompatActivity {

    private Button Browse;//上传按钮
    private ImageView Images;//图片显示区域

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        init();//初始化
        //点击事件
        Browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();

                intent.setType("image:/*");//获取图片
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,1);
            }
        });
    }
    //获取ID
    private void init(){
        Browse= (Button) findViewById(R.id.browse);
        Images= (ImageView) findViewById(R.id.camera_image);
    }
    //
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode==RESULT_OK){
            Uri uri=data.getData();
            ContentResolver cr=this.getContentResolver();
            try{//压缩图片
                Bitmap mBitmap= BitmapFactory.decodeStream(cr.openInputStream(uri));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode,resultCode,data);
    }
}
