package com.panda.skypay;

import com.panda.supercash.RequestData;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by haihong on 2019/8/9.
 */
@Data
public class DataConfig {
    public  String request_method = "POST";
    public  String userAgent = "Mozilla/5.0 (Linux; U; Android 8.1.0; zh-cn; Nexus 5X Build/OPM4.171019.016.A1) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    public  String ContentType = "application/x-www-form-urlencoded"; //application/x-www-form-urlencoded application/json

    public  String packageName = "com.ynsky.android";
    public  String channelKey = "16";
    public  String version = "1";
    public  String platform = "android";
    public  String deviceToken = "f3d96a07-1d92-4534-84fa-f4688e8da4ae";
    public  String deviceId = "99e0139b67a64ad288972c5844254026";
    public String appName = "SkyPay";
    public String app_market="googleplay";
//    public int num = (int) (Math.random() * 999999999 + 1);
//    public String mobile = "0" + Integer.toString(num);
    public String countryCode="62";
    public String deviceInfo="{\"test\":true}";

    //信息提交
    public String real_name="rosa"+ RandomStringUtils.randomAlphanumeric(6);
//    Integer random_num=(int)(Math.random()*999999999+1); //9位随机数

    //生成随机生日
    RequestData rd=new RequestData();
    private String yearBefore = "19";
    private Integer yearRound = (int) (Math.random() * 90 + 10);//随机产生两位数，10-99之间；Math.random()产生（0，1）之间数字
    private String year = yearBefore + yearRound.toString();
    private int monthRound = (int) (Math.random() * 12 + 1);
    private int dayRound = (int) (Math.random() * 30 + 1);
    public String birthday =rd.getRamdomNum(dayRound)+"."+rd.getRamdomNum(monthRound)+  "."+year;
    //发薪日1-31日
    Integer random_day=(int)(Math.random()*31+1);

    //联系人
    public String contact1_name="java"+RandomStringUtils.randomAlphabetic(10);
    public String contact1_mobile="052"+RandomStringUtils.random(7,"1234567890");
    public String contact2_name="JAVA"+RandomStringUtils.randomAlphabetic(10);
    public String contact2_mobile="086"+RandomStringUtils.random(7,"1234567890");

    //applist上传
    String file_type="applist";


}
