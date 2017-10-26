package org.hospital.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by pismery on 2017-10-25.
 */
public class Md5Util {
    public static String getMd5(String pwd){
        try {
            MessageDigest md=MessageDigest.getInstance("md5");
            md.update(pwd.getBytes());
            byte[] data=md.digest();
            StringBuffer sb=new StringBuffer();
            for(int i=0,lens=data.length;i<lens;i++){
                sb.append(Integer.toHexString(data[i]&0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
