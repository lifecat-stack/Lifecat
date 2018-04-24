package com.example.a59682.myapplicationtest2018421;

import java.util.HashMap;
/**
 * @name User
 * @description 用户账号默认数据库
 * @author 59682
 */
public class User {

    private static HashMap<String, String> USER;
    private static String[] EMAIL;
    private static String[] PASSWORD;

    /* 设置默认密码库 */
    static {
        USER = new HashMap<>();
        EMAIL = new String[]{
                "wsh@qq.com",
                "admin@gmail.com",
                "wangshihao@gmail.com",
                "zhuzhenyu@gmail.com",
                "ouyangchun@gmail.com",
                "chenjiahui@gmail.com",
                "lijuhang@gmail.com"
        };
        PASSWORD = new String[]{
                "wang",
                "123456",
                "123456",
                "123456",
                "123456",
                "123456",
                "123456"
        };
        for (int i = 0; i < EMAIL.length; i++) {
            USER.put(EMAIL[i],PASSWORD[i]);
        }
    }
    /**
     * @description 验证账号和密码
     */
    public static boolean validateUser(String email,String password){
        if (containEmail(email)&&containPassword(email,password)){
            return true;
        }else {
            return false;
        }
    }
    /* 检查是否包含用户账号 */
    private static boolean containEmail(String email) {
        if (USER.containsKey(email)){
            return true;
        }else {
            return false;
        }
    }
    /* 检查密码是否正确 */
    private static boolean containPassword(String email,String password) {
        if (USER.get(email).equals(password)){
            return true;
        }else {
            return false;
        }
    }
}
