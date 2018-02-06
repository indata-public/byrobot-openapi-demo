package com.indata.openapi.utils;

import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 发送请求的工具类
 * @author indata
 * @create 2018/2/5
 **/
public class IndataHttpUtils {

    public static String sendGet(String url, String ak_id, String ak_secret) {
        HttpURLConnection conn = null;
        PrintWriter out = null;
        InputStream in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            /*
             * http header 参数
             */
            String method = "GET";
            String accept = "application/json";
            String content_type = "application/json";
            String date = toGMTString(new Date());
            String sign = IndataSignUtils.generateSign(date, ak_id, ak_secret);
            // 打开和URL之间的连接
            conn = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestMethod(method);
            conn.setRequestProperty("accept", accept);
            conn.setRequestProperty("content-type", content_type);
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("contentType", "utf-8");
            conn.setRequestProperty("datetime", date);
            conn.setRequestProperty("appkey", ak_id);
            conn.setRequestProperty("sign", sign);

            // 建立实际的连接
            conn.connect();
            int rc = conn.getResponseCode();
            if (rc == 200) {
                in = conn.getInputStream();
            } else {
                in = conn.getErrorStream();
            }
            result = changeInputStream(in, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            closeConnection(conn, out, in);
        }
        return result;
    }


    public static String sendPost(String url, String body, String ak_id, String ak_secret) {
        HttpURLConnection conn = null;
        Writer out = null;
        InputStream in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            /*
             * http header 参数
             */
            String method = "POST";
            String accept = "application/json";
            String content_type = "application/json";
            String date = toGMTString(new Date());
            String sign = IndataSignUtils.generateSign(date, ak_id, ak_secret);

            // 打开和URL之间的连接
            conn = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestMethod(method);
            conn.setRequestProperty("accept", accept);
            conn.setRequestProperty("content-type", content_type);
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("contentType", "utf-8");
            conn.setRequestProperty("datetime", date);
            conn.setRequestProperty("appkey", ak_id);
            conn.setRequestProperty("sign", sign);

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            // 发送请求参数
            out.write(body);
            // flush输出流的缓冲
            out.flush();
            int rc = conn.getResponseCode();
            if (rc == 200) {
                in = conn.getInputStream();
            } else {
                in = conn.getErrorStream();
            }
            result = changeInputStream(in, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 使用finally块来关闭输出流、输入流
        finally {
            closeConnection(conn, out, in);
        }
        return result;
    }

    private static void closeConnection(HttpURLConnection conn, Writer out, InputStream in) {
        try {
            if (conn != null) {
                conn.disconnect();
            }
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String changeInputStream(InputStream inputStream,
                                            String encode) {
        // ByteArrayOutputStream 一般叫做内存流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        String result = "";
        if (inputStream != null) {
            try {
                while ((len = inputStream.read(data)) != -1) {
                    byteArrayOutputStream.write(data, 0, len);
                }
                result = new String(byteArrayOutputStream.toByteArray(), encode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String HMACSha1(String data, String key) {
        String result;
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(data.getBytes());
            result = (new BASE64Encoder()).encode(rawHmac);
        } catch (Exception e) {
            throw new Error("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }

    public static String toGMTString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.UK);
        df.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        return df.format(date);
    }
}
