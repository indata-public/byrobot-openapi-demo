package com.indata.openapi.utils;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * Created on 2016/09/28
 *
 * @author annpeter.it@gmail.com
 */
public class EncryptUtils {
    public static String AES_KEY = "TaOXLwfQgDhFrqDC"; // AES 加解密使用的key，16位

    /**
     * 加密
     *
     * @param plainPassword
     * @return
     */
    public static String encryptPassword(String plainPassword) {
        byte[] x = EncryptUtils.aesEncrypt(plainPassword, AES_KEY);
        return new String(x);
    }

    /**
     * 解密
     *
     * @param encryptedPassword
     * @return
     */
    public static String decryptPassword(String encryptedPassword) {
        byte[] y = EncryptUtils.aesDecrypt(encryptedPassword.getBytes(), AES_KEY.getBytes());
        return new String(y);
    }

    public static String MD5_16(String data) {
        return MD5_16(data.getBytes());
    }

    public static String MD5_16(byte[] data) {
        return MD5(data).substring(8, 24);
    }

    public static String MD5(String data) {
        return MD5(data.getBytes());
    }

    public static String MD5(byte[] data) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(data);
            return new BigInteger(messageDigest.digest()).toString(16).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] aesEncrypt(String data, String key) {
        return aesEncrypt(data.getBytes(), key.getBytes());
    }

    public static byte[] aesEncrypt(byte[] data, byte[] key) {
        try {
            String iv = EncryptUtils.MD5_16(key);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();

            int plaintextLength = data.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }

            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(data, 0, plaintext, 0, data.length);

            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            byte[] encrypted = cipher.doFinal(plaintext);

            return Base64.getEncoder().encode(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] aesDecrypt(String data, String key) {
        return aesEncrypt(data.getBytes(), key.getBytes());
    }

    public static byte[] aesDecrypt(byte[] data, byte[] key) {
        try {
            String iv = EncryptUtils.MD5_16(key);

            byte[] encrypted = Base64.getDecoder().decode(data);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

            return removieZeroSuffix(cipher.doFinal(encrypted));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] removieZeroSuffix(byte[] arr) {
        int idxEnd;
        for (idxEnd = arr.length; idxEnd > 0; --idxEnd) {
            if (arr[idxEnd - 1] == 0) {
                continue;
            }
            break;
        }
        if (idxEnd == arr.length) {
            return arr;
        }
        byte[] dest = new byte[idxEnd];
        System.arraycopy(arr, 0, dest, 0, idxEnd);
        return dest;
    }
}
