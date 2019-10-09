package com.panda.supercash;

import com.alibaba.fastjson.JSONObject;
import com.panda.common.GlobalString;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by haihong on 2019/7/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootApplication
public class PostJsonRequestTest {
    static Logger logger = Logger.getLogger(PostJsonRequest.class);
    public static void main(String[] args)throws InterruptedException{
//        getImageCode git=new getImageCode();
//        int num = (int) (Math.random() * 999999999 + 1) ;
//        String mobile = "188" + Integer.toString(num);
//        System.out.println(mobile);
        String path="/appserver/api/query/captcha";
        RequestData data=new RequestData();
        GlobalString str=new GlobalString();
        String url= str.url_vn+path;
        System.out.println(url);
        JSONObject json = new JSONObject();
        json.put("packageName", data.packageName);
        json.put("channelKey", data.channelKey);
        json.put("version", data.version);
        json.put("platform", data.platform);
        json.put("deviceToken", data.deviceToken);
        json.put("appName", data.appName);
        json.put("mobile", data.mobile);
        json.put("productCode", data.productCode);

        String jsonStr=json.toString();
        PostJsonRequest git=new PostJsonRequest();
        git.sendPost(url,jsonStr);
        LogUtil.log(git.sendPost(url,jsonStr));
        LogUtil.log(jsonStr);
        LogUtil.log(data.mobile);
        LogUtil.log(git.sendPost(url,jsonStr));

    }
}
