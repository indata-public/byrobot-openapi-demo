package com.indata.openapi.utils;

import com.indata.openapi.utils.IndataHttpUtils;

/**
 * 计算签名的工具类
 * @author indata
 * @create 2018/2/5
 **/
public class IndataSignUtils {

    public static String generateSign(String date, String appKey, String appSecret) {
        String stringToSign = appKey + "\n" + date;
        return IndataHttpUtils.HMACSha1(stringToSign, appSecret);
    }
}
