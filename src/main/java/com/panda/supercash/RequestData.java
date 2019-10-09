package com.panda.supercash;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by haihong on 2019/7/26.
 */
@Data
public class RequestData {
   public  String request_method = "POST";
   public  String userAgent = "Mozilla/5.0 (Linux; U; Android 8.1.0; zh-cn; Nexus 5X Build/OPM4.171019.016.A1) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
   public  String ContentType = "application/x-www-form-urlencoded"; //application/x-www-form-urlencoded application/json
   public  String platform = "android";
   public  String packageName = "com.supercs.android";
   public  String version = "1";
   public  String channelKey = "16";
   public  String countryCode = "086";
   public  String deviceToken = "f3d96a07-1d92-4534-84fa-f4688e8da4ae";
   public  String deviceInfo = "{\"test\":true}";
   public  String deviceId = "99e0139b67a64ad288972c5844254026";
   public String appName = "Supercash";
   public String productCode = "SUPERCASH";
   public int num = (int) (Math.random() * 999999999 + 1);
   public String mobile = "188" + Integer.toString(num);

   //客户中心入参
   //生成随机生日
   private String yearBefore = "19";
   private Integer yearRound = (int) (Math.random() * 90 + 10);//随机产生两位数，10-99之间；Math.random()产生（0，1）之间数字
   private String year = yearBefore + yearRound.toString();
   private int monthRound = (int) (Math.random() * 12 + 1);
   private int dayRound = (int) (Math.random() * 30 + 1);
   public String birthday = year + "-" + getRamdomNum(monthRound) + "-" + getRamdomNum(dayRound);
   //性别，实名认证、国家码
   String[] str_sex = {"MALE", "FEMALE", "NON-BINARY"};//性别,MALE=男性,FEMALE=女性,NON-BINARY=其他
   String[] str_auth = {"UNREAL", "SUCCESS", "FAILURE"}; //实名状态,UNREAL=未实名,SUCCESS=实名认证成功,FAILURE=实名认证失败
   Integer random = (int) (Math.random() * 3);
   Integer random2 = (int) (Math.random() * 20 + 1);//获取随机客户id使用
   public String sex = str_sex[random];
   public String real_name_status = str_auth[random];
   //国家码
   public String country_code = "+62";
   //随机生成16位身份证号
   Integer cardNo1 = (int) (Math.random() * 99999999 + 1);
   Integer cardNo2 = (int) (Math.random() * 99999999 + 1);
   public String cardNo = cardNo1.toString() + cardNo2.toString();
   //随机生成姓名
   public String name = "rosa" + RandomStringUtils.randomAlphanumeric(6);


   public String getRamdomNum(Integer b) {
      if (b < 10) {
         String str = "0" + b.toString();
         return str;
      } else {
         String str = b.toString();
         return str;
      }
   }
}
