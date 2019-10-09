package com.panda.supercash2;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by haihong on 2019/8/22.
 */
@SpringBootApplication
public class AllTest {
    public static void main(String[] args){
//        GetImageCode gic=new GetImageCode();
//
//        gic.getCode();
//        System.out.println(gic.id);
        //        System.out.println(RandomStringUtils.randomAlphanumeric(6));  //包含数字大小写
//        System.out.println(RandomStringUtils.random(6,"qaz123456")); //指定范围内
//        System.out.println(RandomStringUtils.randomAlphabetic(6));//没有数字
//        System.out.println(RandomStringUtils.randomNumeric(6));//纯数字
//        System.out.println(RandomStringUtils.random(6));  //乱码显示
//        System.out.println("0"+RandomStringUtils.randomNumeric(9));
//        for (int i = 0; i <5 ; i++) {
//            String mobile= RandomStringUtils.randomNumeric(7,12);
//            System.out.println(mobile);
//        }
        Login  login=new Login();
        login.login();
        System.out.println(login.uid2);

    }
}
