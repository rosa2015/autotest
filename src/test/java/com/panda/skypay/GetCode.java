package com.panda.skypay;

import com.alibaba.fastjson.JSONObject;
import com.panda.common.GlobalString;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haihong on 2019/8/15.
 */
@Data
public class GetCode {
    private Logger logger= Logger.getLogger(GetCode.class);
    DataConfig dc=new DataConfig();
    GlobalString str=new GlobalString();
    String code;
    String image_id;
    String mobile="0"+RandomStringUtils.random(9,"123456789");
    public void GetLoginCode(){
        String path="/api/query/captcha";
        String url=str.url_vn+path;
        //准备请求方法
        HttpGet httpGet=new HttpGet(url);
        //准备参数
        List<BasicNameValuePair> para=new ArrayList<BasicNameValuePair>();
        BasicNameValuePair package_name=new BasicNameValuePair("package_name",dc.packageName);
        BasicNameValuePair appName=new BasicNameValuePair("appName",dc.appName);
        BasicNameValuePair channel_key=new BasicNameValuePair("channel_key",dc.channelKey);
        BasicNameValuePair version=new BasicNameValuePair("version",dc.version);
        BasicNameValuePair platform=new BasicNameValuePair("platform",dc.platform);
        BasicNameValuePair deviceToken=new BasicNameValuePair("deviceToken",dc.deviceToken);
        BasicNameValuePair deviceId=new BasicNameValuePair("deviceId",dc.deviceId);
        BasicNameValuePair app_market=new BasicNameValuePair("app_market",dc.app_market);
        BasicNameValuePair mobile=new BasicNameValuePair("mobile",getMobile());
        para.add(package_name);
        para.add(channel_key);
        para.add(version);
        para.add(platform);
        para.add(deviceToken);
        para.add(deviceId);
        para.add(app_market);
        para.add(mobile);
        para.add(appName);
        String paras= URLEncodedUtils.format(para,"utf-8");
        String full_url=url+"?"+paras;
        try{
            httpGet.setURI(new URI(full_url));
            //httpGet.setHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
            //准备客户端
            HttpClient client= HttpClients.createDefault();
            //发送请求\
            HttpResponse response=HttpClients.createDefault().execute(httpGet);
            //取出接口响应信息，转成string类型
            String result= EntityUtils.toString(response.getEntity(),"UTF-8").trim();
            //提取响应值
            //提取数组里面的字段
            JSONObject jsonObject=JSONObject.parseObject(result);
            code=jsonObject.getString("code");
            image_id=jsonObject.getJSONObject("data").getString("id");

        }catch (Exception e){
            System.out.println("请求出错");
        }


    }
}
