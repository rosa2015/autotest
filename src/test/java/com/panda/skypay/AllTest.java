package com.panda.skypay;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by haihong on 2019/8/10.
 */
@SpringBootApplication
public class AllTest {
    public static void main(String [] args){
        BaseInfoCommit ic=new BaseInfoCommit();
        ContactsUpload cu=new ContactsUpload();
        AppListUpload alu=new AppListUpload();

//        Login login=new Login();
//        login.Login();
//        System.out.println("登录code"+login.code);

//        //信息提交
//        ic.Commit();
//        //通讯录上传
//        cu.ContactList();
//        //applist上传
//        alu.AppList_Upload();
//        System.out.println("信息提交，"+ic.code+"通讯录上传，"+cu.code+"applist,"+alu.code);
//        System.out.println(RandomStringUtils.randomAlphanumeric(6));  //包含数字大小写
//        System.out.println(RandomStringUtils.random(6,"qaz123456")); //指定范围内
//        System.out.println(RandomStringUtils.randomAlphabetic(6));//没有数字
//        System.out.println(RandomStringUtils.randomNumeric(6));//纯数字
//        System.out.println(RandomStringUtils.random(6));  //乱码显示
//        System.out.println("0"+RandomStringUtils.randomNumeric(9));








    }
}
