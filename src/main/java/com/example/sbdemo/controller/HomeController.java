package com.example.sbdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Virgo
 * @version 1.0
 * @data 2021/11/18 14:19
 * @usage
 */
@Controller
public class HomeController {
    @GetMapping("/home")
    public String initData(HttpServletRequest request, Model model){
        //判断是否已登入
        String name = (String) request.getSession().getAttribute("username");
        if(name==null || name.equals("null")){
            //未登入
            return "login";
        }

        //会自动更新对应页面里变量为"title"的值
        model.addAttribute("title", "测试");
        model.addAttribute("msg", "欢迎：" + name);
        return "home";// 返回的为 /templates/xxx.html 前缀和后缀已在配置里标注
    }

    @GetMapping("/main")
    public String goMain(Model model){
        //会自动更新对应页面里变量为"title"的值
//        model.addAttribute("title", "测试");
        return "framework";//
    }

    @GetMapping("/table")
    public String getTbale(Model model){
        //会自动更新对应页面里变量为"title"的值
//        model.addAttribute("title", "测试");
        return "table";//
    }
}