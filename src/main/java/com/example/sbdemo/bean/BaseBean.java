package com.example.sbdemo.bean;

import com.example.sbdemo.util.GsonHelper;

import java.io.Serializable;

/**
 * @author Virgo
 * @version 1.0
 * @data 2022/5/26 15:39
 * @usage
 */
public class BaseBean implements Serializable {
    public String toJson(){
        return GsonHelper.toJson(this);
    }
}
