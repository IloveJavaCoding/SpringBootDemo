package com.example.sbdemo.controller;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author Virgo
 * @version 1.0
 * @data 2021/11/18 15:26
 * @usage 控制器基础类
 */
public class BaseController {
    /**
     * 简单日志
     * @param tag
     * @param msg 信息
     */
    protected void log(String tag, String msg){
        System.out.println(tag + " --- " + msg);
    }

    /**
     * 跳转到错误页面
     * @param model
     * @param error
     * @return
     */
    protected String go404Page(Model model, String error){
        //会自动更新对应页面里变量为"title"的值
        model.addAttribute("msg", error);
        return "error";// 返回的为 /templates/xxx.html 前缀和后缀已在配置里标注
    }

    /**
     * http 请求回应
     * @param response
     * @param outputObj 回应内容
     */
    protected void sendJsonResponse(HttpServletResponse response, Object outputObj) {
        PrintWriter out = null;
        response.setContentType("text/json;charset=utf-8");
        try {
            out = response.getWriter();
            out.print(outputObj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(out!=null){
                out.flush();
                out.close();
            }
        }
    }
}
