package com.yscoco.myframe.util;

/**
 * @author：ZhongM on 2019/6/18 17:08
 */
public class StringUtil {
    public static Boolean isEmpty(String s){
        if (s==null||s.equals("")){
            return true;
        }else {
            return false;
        }
    }
}
