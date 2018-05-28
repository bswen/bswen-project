package com.bswen;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * Date: 15-9-15
 * Time: 下午2:57
 * To change this template use File | Settings | File Templates.
 */
public class EncryptUtils {
    public static String hmac(String key,String data) throws Exception {
        final Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        final SecretKeySpec secret_key = new javax.crypto.spec.SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        final byte[] mac_data = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        String result = "";
        for (final byte element : mac_data)
        {
            result += Integer.toString((element & 0xff) + 0x100, 16).substring(1);
        }
        System.out.println("Result:[" + result + "]");
        return result;
    }
}
