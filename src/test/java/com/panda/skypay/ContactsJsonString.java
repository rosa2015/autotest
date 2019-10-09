package com.panda.skypay;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haihong on 2019/8/13.
 */
@SpringBootApplication
@Data
public class ContactsJsonString implements Serializable { //
    private List<ContactData> contacts;  //定义一个集合仓库，contacts指所需的参数，ContactData仓库要装的具体类 List是接口，不能实例化，ArrayList()可实例化
    public String Json_String(){
        DataConfig dc=new DataConfig();
        List list=new ArrayList<ContactData>(); //定义一个list，声明装哪个类
        ContactsJsonString js=new ContactsJsonString();  //实例化当前类
        ContactData cd=null;  //初始化元素类
        for(int i=0;i<10;i++){
            cd=new ContactData(); //实例化元素类
            if(i==0){
                cd.setContactId(RandomStringUtils.randomNumeric(2));  //给元素赋值
                cd.setDisplayName(dc.contact1_name);
                cd.setMobile(dc.contact1_mobile);
            }else if(i==1){
                cd.setContactId(RandomStringUtils.randomNumeric(2));
                cd.setDisplayName(dc.contact2_name);
                cd.setMobile(dc.contact2_mobile);
            }else{
                cd.setContactId(RandomStringUtils.randomNumeric(2));
                cd.setDisplayName(RandomStringUtils.randomAlphanumeric(6));
                cd.setMobile("0"+RandomStringUtils.randomNumeric(9));
            }
            list.add(cd); //添加元素至lisi集合
        }
        js.setContacts(list);//给当前类的集合元素赋值


        return JSON.toJSONString(js); //转成json字符串返回

    }

    public static void main(String[] args){
          ContactsJsonString js=new ContactsJsonString();
        System.out.println(js.Json_String());

    }
}
