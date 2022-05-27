package com.example.sbdemo.controller;

import com.example.sbdemo.util.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Virgo
 * @version 1.0
 * @data 2021/11/18 14:19
 * @usage
 */
@Controller
public class HomeController extends BaseController {
    @GetMapping("/home")
    public String initData(HttpServletRequest request, Model model) {
        //判断是否已登入
        String name = (String) request.getSession().getAttribute("username");
        if (name == null || name.equals("null")) {
            //未登入
            return "login";
        }

        //会自动更新对应页面里变量为"title"的值
        model.addAttribute("title", "测试");
        model.addAttribute("msg", "欢迎：" + name);
        return "page/home";// 返回的为 /templates/xxx.html 前缀和后缀已在配置里标注
    }

    @GetMapping("/main")
    public String goMain(Model model){
        //会自动更新对应页面里变量为"title"的值
//        model.addAttribute("title", "测试");
        return "framework";//
    }

    @GetMapping("/table")
    public String getTbale(Model model) {
        //会自动更新对应页面里变量为"title"的值
//        model.addAttribute("title", "测试");
        return "table";//
    }

    @RequestMapping(value = "/export", method = {RequestMethod.GET, RequestMethod.POST})
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
        sendJsonResponse(response, ExcelUtil.MakeData());
    }

    @GetMapping("/test")
    public String goTest(Model model) {
        //会自动更新对应页面里变量为"title"的值
        model.addAttribute("data", ExcelUtil.MakeData());
        return "learn/excel_io";//
    }
}