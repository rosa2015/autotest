package com.panda.skypay;

import com.panda.common.GlobalString;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by haihong on 2019/9/23.
 */
@SpringBootApplication
public class ContactsCommit {
    public void Contacts_Commit(){
        GlobalString gs=new GlobalString();
        //登录接口，获取token和uid
        Login login=new Login();
        login.Login();
//        //接口路径
//        String path="/api/auth/contact_info";
//        String url=gs.url_vn+path;
//
//        //设置请求方法
//        HttpPost post=new HttpPost(url);
//        post.setHeader("token",login.token);
//        post.setHeader("uid",login.uid);
//
//        //准备参数
//        List<BasicNameValuePair> paras=new ArrayList<BasicNameValuePair>();

    }
}
