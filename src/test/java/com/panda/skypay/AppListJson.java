package com.panda.skypay;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haihong on 2019/8/15.
 */
@SpringBootApplication
public class AppListJson implements Serializable{
    public String App_List(){
        List list=new ArrayList<AppListData>();
        AppListJson al=new AppListJson();
        AppListData apj=null;
        for (int i = 0; i <4 ; i++) {
            apj=new AppListData();
           if(i==0){
               apj.setAppName("i 管家");
               apj.setPackageName("com.iqoo.secure");
           }else if(i==1){
               apj.setAppName("SkyPay");
               apj.setPackageName("com.mudah.uang");
           }else{
               apj.setAppName("vivo钱包");
               apj.setPackageName("com.vivo.wallet");
           }
            list.add(apj);
        }
        return JSON.toJSONString(list);
    }
    public static void main(String[] args){
        AppListJson js=new AppListJson();
        System.out.println(js.App_List());

    }
}
