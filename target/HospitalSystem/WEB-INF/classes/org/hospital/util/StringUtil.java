package org.hospital.util;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by pismery on 2017-10-25.
 */
public class StringUtil {
    public static String setResult(int code, String msg, String result) {
        JSONObject jo = new JSONObject();
        jo.put("code", code);
        jo.put("msg", msg);
        jo.put("result", result);
        return jo.toJSONString();
    }
}
