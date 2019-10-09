package com.panda.supercash2;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by haihong on 2019/8/22.
 */
public class GetImageCode {
    String id;
    public void getCode(){
        CommonParas cp=new CommonParas();
        String path="/captcha";
        String url=cp.getIp_captcha()+path;
        System.out.println(url);
        //准备参数  无
        //请求方法
        HttpGet get=new HttpGet(url);
        try{
            //创建客户端
            HttpClient client= HttpClients.createDefault();
            //发送请求
            HttpResponse response=client.execute(get);
            //响应信息转字符串
            String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject jsonObject=JSONObject.parseObject(result);
             id=jsonObject.getString("id");
        }catch (Exception e){
        }
    }
}
