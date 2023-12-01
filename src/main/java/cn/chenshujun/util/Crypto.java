package cn.chenshujun.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 通用加密类
 *
 * @author XiaoChenClassmates
 * @version 1.0.0 2023/10/13
 */
public class Crypto {

    /**
     * md5加密
     *
     * @param data 加密信息
     * @return 加密后的信息
     */
    public static String md5(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5 = md.digest(data.getBytes(StandardCharsets.UTF_8));

        // 将处理后的字节转成 16 进制，得到最终 32 个字符
        StringBuilder sb = new StringBuilder();
        for (byte b : md5) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
}
