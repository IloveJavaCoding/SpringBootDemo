package com.example.sbdemo.util;

/**
 * @author Virgo
 * @version 1.0
 * @data 2021/11/19 10:38
 * @usage
 */
public class TextUtil {
    /**
     * 判断字符非空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str == null || ("").equals(str);
    }
}
