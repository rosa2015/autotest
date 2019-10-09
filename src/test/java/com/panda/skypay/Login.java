package com.panda.skypay;

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
 * Created by haihong on 2019/8/9.
 */
@Data
@SpringBootApplication
public class Login {
    DataConfig dc=new DataConfig();
    GlobalString str=new GlobalString();
    String uid;
    String token;
    String code;
    public void Login(){
        GetCode gc=new GetCode();
        gc.GetLoginCode();
        String path="/api/user/login_by_captcha";
        String url=str.url_vn+path;
        //准备请求方法
        HttpPost httpPost=new HttpPost(url);
        //准备参数
        String imageCode="100"+gc.mobile.substring(gc.mobile.length()-1,gc.mobile.length());  //截取手机号最后一位

        List<BasicNameValuePair> para=new ArrayList<BasicNameValuePair>();
        BasicNameValuePair package_name=new BasicNameValuePair("package_name",dc.packageName);
        BasicNameValuePair channel_key=new BasicNameValuePair("channel_key",dc.channelKey);
        BasicNameValuePair version=new BasicNameValuePair("version",dc.version);
        BasicNameValuePair platform=new BasicNameValuePair("platform",dc.platform);
        BasicNameValuePair deviceToken=new BasicNameValuePair("deviceToken",dc.deviceToken);
        BasicNameValuePair mobile=new BasicNameValuePair("mobile",gc.mobile);
        BasicNameValuePair countryCode=new BasicNameValuePair("countryCode",dc.countryCode);
        BasicNameValuePair captcha_id=new BasicNameValuePair("captcha_id",gc.image_id);
        BasicNameValuePair digits=new BasicNameValuePair("digits",imageCode);
        BasicNameValuePair device_info=new BasicNameValuePair("device_info",dc.deviceInfo);
        para.add(package_name);
        para.add(channel_key);
        para.add(version);
        para.add(platform);
        para.add(deviceToken);
        para.add(mobile);
        para.add(countryCode);
        para.add(captcha_id);
        para.add(digits);
        para.add(device_info);

        try{
            //封装参数至请求体
            httpPost.setEntity(new UrlEncodedFormEntity(para,"utf-8"));
            //准备客户端
            HttpClient client=HttpClients.createDefault();
            //发送请求
            HttpResponse response=HttpClients.createDefault().execute(httpPost);
            //取出接口响应信息，转成string类型
            String login_result= EntityUtils.toString(response.getEntity(),"UTF-8");
            JSONObject jsonObject=JSONObject.parseObject(login_result);
             uid=jsonObject.getJSONObject("data").getString("uid");
             token=jsonObject.getJSONObject("data").getString("token");
             code=jsonObject.getString("code");

            //return uid+";"+token+";"+code;
        }catch (Exception e){
            System.out.println("请求出错");
           // return "";
        }

    }

}
