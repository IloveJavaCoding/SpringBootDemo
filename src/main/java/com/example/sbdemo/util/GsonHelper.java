package com.example.sbdemo.util;

import com.example.sbdemo.bean.IntTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class GsonHelper {
    /**
     * json数据模型化
     *
     * @param json
     * @return
     */
    public static Object getObject(String json, Type class1) {
        try {
//            Gson gson = new Gson();
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .registerTypeAdapter(int.class, new IntTypeAdapter())
                    .registerTypeAdapter(Integer.class, new IntTypeAdapter())
                    .create();//just for date
            Object object = gson.fromJson(json.trim(), class1);
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * json数据模型化
     *
     * @return
     */
    public static String toJson(Object object) {
        try {
            Gson gson = new GsonBuilder()
                    .disableHtmlEscaping()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .registerTypeAdapter(int.class, new IntTypeAdapter())
                    .registerTypeAdapter(Integer.class, new IntTypeAdapter())
                    .create();
            return gson.toJson(object);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Object getObject(String json, TypeToken token) {
        try {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .registerTypeAdapter(int.class, new IntTypeAdapter())
                    .registerTypeAdapter(Integer.class, new IntTypeAdapter())
                    .create();
            Object object = gson.fromJson(json.trim(), token.getType());
            return object;
        } catch (Exception e) {
            return "";
        }
    }
//    /**
//     * json数据模型化
//     *
//     * @param json
//     * @return
//     */
//    public static String getParseValue(String json, String key) {
//        try{
//            JSONObject jsonObject = JSONObject.parseObject(json);
//            return jsonObject.getString(key);
//        }catch (Exception e){
//            return "";
//        }
//    }
//    /**
//     * json数据模型化
//     *
//     * @param json
//     * @return
//     */
//    public static String getParseValue(String json,String contentKey, String key) {
//        try{
//            JSONObject jsonObject = JSONObject.parseObject(json);
//            String returnObject = jsonObject.getString(contentKey);
//            return JSONObject.parseObject(returnObject).getString(key);
//        }catch (Exception e){
//            return "";
//        }
//    }

}
