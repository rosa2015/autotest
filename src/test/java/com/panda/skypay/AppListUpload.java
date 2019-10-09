package com.panda.skypay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.panda.common.GlobalString;
import lombok.Data;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haihong on 2019/8/15.
 */
@SpringBootApplication
@Data
public class AppListUpload {
    String code;
    public void AppList_Upload(){
        GlobalString gc=new GlobalString();
        DataConfig dc=new DataConfig();
        AppListJson alj=new AppListJson();
        Login cl=new Login();
        cl.Login();
        String path="/api/file/upload_str";
        String url=gc.url_vn+path;
        //设置请求方法
        HttpPost post=new HttpPost(url);
        post.setHeader("uid",cl.uid);
        post.setHeader("token",cl.token);
        //准备参数
        List<BasicNameValuePair> para=new ArrayList<BasicNameValuePair>();
        BasicNameValuePair file_type=new BasicNameValuePair("file_type",dc.file_type);
        BasicNameValuePair content=new BasicNameValuePair("content",alj.App_List());
        BasicNameValuePair package_name=new BasicNameValuePair("package_name",dc.packageName);
        BasicNameValuePair channel_key=new BasicNameValuePair("channel_key",dc.channelKey);
        BasicNameValuePair version=new BasicNameValuePair("version",dc.version);
        BasicNameValuePair platform=new BasicNameValuePair("platform",dc.platform);
        BasicNameValuePair deviceToken=new BasicNameValuePair("deviceToken",dc.deviceToken);
        BasicNameValuePair deviceId=new BasicNameValuePair("deviceId",dc.deviceId);
        BasicNameValuePair app_market=new BasicNameValuePair("app_market",dc.app_market);
        BasicNameValuePair appName=new BasicNameValuePair("appName",dc.appName);
        BasicNameValuePair uid=new BasicNameValuePair("uid",cl.uid);
        para.add(file_type);
        para.add(content);
        para.add(package_name);
        para.add(channel_key);
        para.add(version);
        para.add(platform);
        para.add(deviceToken);
        para.add(deviceId);
        para.add(app_market);
        para.add(uid);
        para.add(appName);
        try{
            //把参数封装至请求体
            post.setEntity(new UrlEncodedFormEntity(para,"utf-8"));
            //准备客户端
            HttpClient client= HttpClients.createDefault();
            //发送请求
            HttpResponse response=client.execute(post);
            //响应信息转成json串返回
            String result=EntityUtils.toString(response.getEntity(),"utf-8");

            JSONObject js= JSON.parseObject(result);
         code=js.getString("code");
        }catch (Exception e){
            System.out.println("applist上传失败，"+code);
        }

    }
//    public static void main(String[] args){
//        Login cl=new Login();
//        System.out.println(cl.token);
////        AppListUpload ic=new AppListUpload();
////        System.out.println(ic.AppList_Upload());
//
//
//    }
}
