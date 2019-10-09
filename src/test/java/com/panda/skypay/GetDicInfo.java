package com.panda.skypay;

import com.alibaba.fastjson.JSONObject;
import com.panda.common.GlobalString;
import lombok.Data;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haihong on 2019/8/12.
 */
@Data
public class GetDicInfo {
    GlobalString gc=new GlobalString();
    public String dicInfo(String type){
        String path="/api/query/dict_list";
        String url=gc.url_vn+path;
        //准备请求方法
        HttpGet httpGet=new HttpGet(url);
        //准备参数
        List<BasicNameValuePair> para=new ArrayList<BasicNameValuePair>();
        BasicNameValuePair dict=new BasicNameValuePair("dict_type_code",type);
        para.add(dict);
        String paras= URLEncodedUtils.format(para,"utf-8");
        String full_url=url+"?"+paras;
        try{
            //获取带参数的url
            httpGet.setURI(new URI(full_url));
            //准备客户端
            HttpClient client= HttpClients.createDefault();
            //发送请求
            HttpResponse response=client.execute(httpGet);
            //响应信息转成字符串
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            //提取参数
            JSONObject jsonObject=JSONObject.parseObject(result);
            String dic_list=jsonObject.getJSONObject("data").getJSONArray("dict_list").getString(0);
            JSONObject json=JSONObject.parseObject(dic_list);
            String type_code=json.getString("dict_data_code");
            return type_code;
        }catch (Exception e){
            return "error";
        }
    }
    public String gender=dicInfo("gender");
    public String r_relation=dicInfo("r_relation");
    public String relation2=dicInfo("relation2");
    public String liveTime=dicInfo("liveTime");
    public String industry=dicInfo("industry");
    public String bank_code=dicInfo("bank_code");
    public String work_year=dicInfo("work_year");
    public String work_wages=dicInfo("work_wages");



}
