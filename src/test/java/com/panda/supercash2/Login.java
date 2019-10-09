package com.panda.supercash2;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haihong on 2019/8/22.
 */
public class Login {
    String uid2;
    String access_token;

    public void login(){
        GetImageCode gic=new GetImageCode();
        gic.getCode();

        String phone=RandomStringUtils.randomNumeric(7,12);//RandomStringUtils.randomNumeric(7,12);
        String lastNum=phone.substring(phone.length()-1,phone.length());
        String code="100"+lastNum;
        System.out.println("captcha:"+code);
        String deviceInfo="eyJzeXN0ZW0iOiJpb3MifQ%3D%3D";  //必须是有效值
        CommonParas cp=new CommonParas();
        String path="/api/v1/user/login";
        String url=cp.ip_ind+path;
        //请求方法
        HttpPost post=new HttpPost(url);
        //准备参数
        List<BasicNameValuePair> para=new ArrayList<BasicNameValuePair>();
        BasicNameValuePair bundle_id=new BasicNameValuePair("bundle_id",cp.bundle_id);
        BasicNameValuePair country_code=new BasicNameValuePair("country_code",cp.country_code);
        BasicNameValuePair terminal_name=new BasicNameValuePair("terminal_name",cp.terminal_name);
        BasicNameValuePair channel_code=new BasicNameValuePair("channel_code",cp.channel_code);
        BasicNameValuePair version=new BasicNameValuePair("version",cp.version);
        BasicNameValuePair platform=new BasicNameValuePair("platform",cp.platform);
        BasicNameValuePair product_code=new BasicNameValuePair("product_code",cp.product_code);
        BasicNameValuePair api_track_id=new BasicNameValuePair("api_track_id",cp.api_track_id);

        BasicNameValuePair mobile=new BasicNameValuePair("mobile",phone);
        BasicNameValuePair captcha=new BasicNameValuePair("captcha",code);
        BasicNameValuePair captcha_key=new BasicNameValuePair("captcha_key",gic.id);
        BasicNameValuePair device_info=new BasicNameValuePair("device_info",deviceInfo);
        //BasicNameValuePair uid=new BasicNameValuePair("uid","");

        para.add(bundle_id);
        para.add(country_code);
        para.add(terminal_name);
        para.add(channel_code);
        para.add(version);
        para.add(platform);
        para.add(product_code);
        para.add(api_track_id);

        para.add(mobile);
        para.add(captcha);
        para.add(captcha_key);
        para.add(device_info);
       // para.add(uid);
        try{
            //参数封装至请求体中
            post.setEntity(new UrlEncodedFormEntity(para,"utf-8"));
            //创建客户端
            HttpClient client= HttpClients.createDefault();
            //发送请求
            HttpResponse response=client.execute(post);
            //响应信息转换str
            String result= EntityUtils.toString(response.getEntity(),"utf-8");

            JSONObject jsonObject=JSONObject.parseObject(result);
            uid2=jsonObject.getJSONObject("data").getString("uid");
            String secret=jsonObject.getJSONObject("data").getString("secret");
            JSONObject json=JSONObject.parseObject(secret);
            access_token=json.getString("access_token");
        }catch(Exception e){
            System.out.println("请求失败");
        }

    }
}
