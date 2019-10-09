package com.panda.skypay;

import com.alibaba.fastjson.JSONObject;
import com.panda.common.GlobalString;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
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
 * Created by haihong on 2019/8/12.
 */
@SpringBootApplication
@Data
public class BaseInfoCommit {
    String code;
    public void Commit(){
        GlobalString gc=new GlobalString();
        DataConfig dc=new DataConfig();
        GetDicInfo gdi=new GetDicInfo();
        Login cl=new Login();
        cl.Login();

        String path="/api/auth/base_info";
        String url=gc.url_vn+path;
        //获取请求方法
        HttpPost post=new HttpPost(url);
        post.setHeader("uid",cl.uid);
        post.setHeader("token",cl.token);
        //准备参数
        List<BasicNameValuePair> para=new ArrayList<BasicNameValuePair>();
        BasicNameValuePair real_name=new BasicNameValuePair("real_name",dc.real_name);
        BasicNameValuePair id_no=new BasicNameValuePair("id_no", RandomStringUtils.randomNumeric(9));
        BasicNameValuePair birthday=new BasicNameValuePair("birthday",dc.birthday);
        BasicNameValuePair job=new BasicNameValuePair("job",gdi.industry);
        BasicNameValuePair gender=new BasicNameValuePair("gender",gdi.gender);
        BasicNameValuePair wages=new BasicNameValuePair("wages",gdi.work_wages);
        BasicNameValuePair pay_day=new BasicNameValuePair("pay_day",dc.random_day.toString());
        BasicNameValuePair co_worker_mobile=new BasicNameValuePair("co_worker_mobile","0"+RandomStringUtils.random(9,"123456789"));
        BasicNameValuePair province=new BasicNameValuePair("province",RandomStringUtils.randomAlphanumeric(10));
        BasicNameValuePair city=new BasicNameValuePair("city",RandomStringUtils.randomAlphanumeric(5));
        BasicNameValuePair district=new BasicNameValuePair("district",RandomStringUtils.randomAlphanumeric(10));
        BasicNameValuePair address=new BasicNameValuePair("address",RandomStringUtils.randomAlphanumeric(20));
        BasicNameValuePair uid=new BasicNameValuePair("uid",cl.uid);
        para.add(real_name);
        para.add(id_no);
        para.add(birthday);
        para.add(job);
        para.add(gender);
        para.add(wages);
        para.add(pay_day);
        para.add(co_worker_mobile);
        para.add(province);
        para.add(city);
        para.add(district);
        para.add(address);
        para.add(uid);

        try{
            //把参数写入请求体
            post.setEntity(new UrlEncodedFormEntity(para,"utf-8"));
            //创建客户端
            HttpClient client= HttpClients.createDefault();
            //发送请求
            HttpResponse response=client.execute(post);
            //响应信息转成string
           String result= EntityUtils.toString(response.getEntity(),"utf-8");
            JSONObject js= JSONObject.parseObject(result);
            code=js.getString("code");
            if(code.equals("1000")){
                System.out.println("请求成功");
            }else{
                System.out.println("请求失败"+code);
            }

        }catch (Exception e){
            System.out.println("error");
        }


    }
    public static void main(String[] args){
        BaseInfoCommit ic=new BaseInfoCommit();
        System.out.println(ic.code);


    }
}
