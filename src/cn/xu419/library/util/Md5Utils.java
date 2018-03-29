package cn.xu419.library.util;

import java.security.MessageDigest;

/**
 * 用于MD5 加密和验证密码的类
 * @author bsz
 * Created on 2018/3/29
 */
public class Md5Utils {
    public static String transToMd5(String s){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            return toHex(bytes);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean isSame(String s,String MD5){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            return toHex(bytes).equals(MD5);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    private static String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (byte aByte : bytes) {
            ret.append(HEX_DIGITS[(aByte >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[aByte & 0x0f]);
        }
        return ret.toString();
    }
}
