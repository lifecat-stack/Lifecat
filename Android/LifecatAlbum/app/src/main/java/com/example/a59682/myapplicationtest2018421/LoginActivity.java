package com.example.a59682.myapplicationtest2018421;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author 59682
 * @name LoginActivity
 * @description 登录界面
 */
public class LoginActivity extends AppCompatActivity {
    /* 广播信息 */
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    /* 组件ID */
    private EditText _emailText;
    private EditText _passwordText;
    private Button _loginButton;
    private TextView _signupLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* 隐藏标题栏 */
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        assignViews();
        initListener();
    }

    /**
     * @description 获取组件
     */
    private void assignViews() {
        _emailText = findViewById(R.id.input_email);
        _passwordText = findViewById(R.id.input_password);
        _loginButton = findViewById(R.id.btn_login);
        _signupLink = findViewById(R.id.link_signup);
    }

    /**
     * @description button点击事件
     */
    private void initListener() {
        /* 登录button */
        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        /* 注册button */
        _signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
            }
        });
    }

    /**
     * @description 登录button事件
     */
    public void login() {
        Log.d(TAG, "Login");

        /* 表单验证-->若失败，直接return */
        if (!validate()) {
            onLoginFailed();
            return;
        }

        /* 锁定登录按钮直至验证完成 */
        _loginButton.setEnabled(false);

        /* 验证时:弹出框 */
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        /* 获取用户登录信息 */
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.
        /*------ 验证逻辑 ------*/

        /* 认证成功 */
        if (User.validateUser(email,password)) {
            /* 启动成功线程-->延时三秒动画 */
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            // On complete call either onLoginSuccess or onLoginFailed
                            onLoginSuccess();
                            progressDialog.dismiss();
                        }
                    }, 1000);
        }
        /* 认证失败 */
        else {
            /* 启动失败线程-->延时三秒动画 */
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            // On complete call either onLoginSuccess or onLoginFailed
                            onLoginFailed();
                            progressDialog.dismiss();
                        }
                    }, 1000);
        }
    }

    /*---------- Activity方法 ----------*/

    /**
     * @description 登录成功-->MainActivity
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                /*------ 登录成功 ------*/
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, BackgroundActivity.class);
                startActivity(intent);

                this.finish();
            }
        }
    }

    /**
     * @description 返回键
     */
    @Override
    public void onBackPressed() {
        // Disable going back to the WelcomeActivity
        moveTaskToBack(true);
    }

    /**
     * @description 登录成功-->跳转 + finish Activity
     */
    public void onLoginSuccess() {
        _loginButton.setEnabled(true);

        /* 跳转到MainActivity */
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this, BackgroundActivity.class);
        startActivity(intent);

        /* 关闭LoginActivity */
        finish();
    }

    /**
     * @description 登录失败-->广播
     */
    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    /**
     * @return 表单合格-->true  表单不合格-->false
     * @description 表单验证
     */
    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        /* email=null 或 email不符合格式 */
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }
        /* password==null 或 password小于4字符 或 password大于10字符 */
        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}
