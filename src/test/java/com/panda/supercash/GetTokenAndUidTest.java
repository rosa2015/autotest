package com.panda.supercash;

import com.panda.common.GlobalString;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haihong on 2019/8/8.
 */
@SpringBootApplication
public class GetTokenAndUidTest {
    private Logger logger=Logger.getLogger(GetTokenAndUidTest.class);
    GlobalString str=new GlobalString();
    RequestData data = new RequestData();
    @Test()
    public void testPost(){
        String path = "/appserver/api/fblogin/sitApiLogin";

        String url = str.url_vn + path;
        //选择请求方法
        HttpPost httpPost=new HttpPost(url);
        //准备参数
        List<BasicNameValuePair> para=new ArrayList<BasicNameValuePair>();
        BasicNameValuePair mobile = new BasicNameValuePair("mobile",data.mobile);
        para.add(mobile);
        try{
            //把参数封装到请求体
            httpPost.setEntity(new UrlEncodedFormEntity(para ,"utf-8"));
            //准备客户端
            HttpClient httpClient= HttpClients.createDefault();
            //发送请求，接受响应信息
            HttpResponse response=httpClient.execute(httpPost);
            //取出接口响应数据，并转成字符串
            String result= EntityUtils.toString(response.getEntity());
            LogUtil.log(result);
        }catch (Exception e){
            logger.error("post请求出错");
        }
    }
    public void testGet(){
        String path = "/skypay/api/product/info";
        String url = str.url_vn + path;
        //选择请求方法
        HttpGet httpGet=new HttpGet(url);
        //准备参数
        List<BasicNameValuePair> para=new ArrayList<BasicNameValuePair>();
        BasicNameValuePair sub_product_code=new BasicNameValuePair("sub_product_code","CODE_DGN");
        para.add(sub_product_code);
        String paramers= URLEncodedUtils.format(para,"utf-8");
        //参数拼接在？后面
        String full_url=url+"?"+paramers;
        try{
            httpGet.setURI(new URI(full_url));
            //准备客户端、
            HttpClient httpClient=HttpClients.createDefault();
            //发送请求，接收响应信息
            HttpResponse response=httpClient.execute(httpGet);
            String result=EntityUtils.toString(response.getEntity());
        }
        catch (Exception e){
          logger.error("get请求错误");
        }

    }
    public static void main(String[] args)throws InterruptedException {
        GetTokenAndUidTest aa=new GetTokenAndUidTest();
        aa.testPost();
        aa.testGet();
   }
}
