package com.panda.supercash;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by haihong on 2019/7/26.
 */
@SpringBootApplication
/***
 * 请求类
 */
public class PostJsonRequest {
    public static String sendPost(String url, String param) {
        RequestData data= new RequestData();
        OutputStream outputStream = null;
        BufferedReader bufferedReader = null;
        String result = "";

        try {
            //打开url
            URL postUrl = new URL(url);
            HttpURLConnection conn = null;
            conn = (HttpURLConnection) postUrl.openConnection();
            //发送post请求必须设置如下两行
            conn.setDoInput(true);
            conn.setDoOutput(true);
            //conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestMethod(data.getRequest_method());

            //设置通用的属性
            conn.setRequestProperty("user-agent", data.userAgent);
            conn.setRequestProperty("Content-Type", data.ContentType);
//            conn.setRequestProperty("packageName", cn.getPackageName());
//            conn.setRequestProperty("channelKey", cn.getChannelKey());
//            conn.setRequestProperty("version", cn.getVersion());
//            conn.setRequestProperty("platform", cn.getPlatform());
//            conn.setRequestProperty("deviceToken", cn.getDeviceToken());
//            conn.setRequestProperty("appName", cn.getAppName());
//            conn.setRequestProperty("productCode", cn.getProductCode());

            conn.connect();
            //获取URLconnection对象对应的输出流
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            //发送请求参数
            out.write(param);//json对象转string
            //flush输出流的缓冲
            out.flush();//数据停留在缓冲区无法发送或数据长度不满缓冲区大小时，需要在write()方法后，使用flush（）方法，强制刷出缓冲区的数据
            //定义BufferedReader输入流来读取url的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result = result + line;
            }
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }

        } catch (Exception e) {
            LogUtil.log("发送post请求异常" + e);
            e.printStackTrace();
        }
        //使用finally来关闭输入和输出流  --debug
//        finally{
//            try{
//                if(out!=null){
//                    out.close();
//                }if(in!=null){
//                    in.close();
//                }
//            }catch (IOException ex){
//                ex.printStackTrace();
//            }
//        }
        return result;

    }

}
