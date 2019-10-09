package com.panda.customer;

import com.alibaba.fastjson.JSONObject;
import com.panda.common.GlobalString;
import com.panda.supercash.RequestData;
import com.panda.supercash.LogUtil;
import com.panda.supercash.PostJsonRequest;
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
public class CustomerCenterTest {

    public static void main(String[] args) throws InterruptedException {
//        getImageCode git=new getImageCode();
//        int num = (int) (Math.random() * 999999999 + 1) ;
//        String mobile = "188" + Integer.toString(num);
//        System.out.println(mobile);
        String path = "/customer/v1/customers";
        RequestData data = new RequestData();
        GlobalString  str=new GlobalString();
        String url = str.url_ind + path;
        LogUtil.log(url);


        JSONObject json = new JSONObject();
        json.put("id_card_no", data.cardNo);
        json.put("name", data.getName());
        json.put("country_code", data.getCountry_code());
        json.put("sex", data.getSex());
        json.put("birthday", data.getBirthday());
        json.put("real_name_status", data.getReal_name_status());

        String jsonStr = json.toString();
        PostJsonRequest gi = new PostJsonRequest();

        LogUtil.log(jsonStr);
        LogUtil.log(gi.sendPost(url, jsonStr));


    }
}
