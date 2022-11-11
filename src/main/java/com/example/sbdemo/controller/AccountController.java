package com.example.sbdemo.controller;

import com.example.sbdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Virgo
 * @version 1.0
 * @data 2021/11/18 14:06
 * @usage 账号管理
 */
@Controller
public class AccountController extends BaseController{
    private static final String TAG = "AccountController";

    @Autowired
    protected AccountService accountService;

    @RequestMapping("/mobile/login")
    public void login(HttpServletRequest request, HttpServletResponse response){
        if(request!=null){
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if(username==null || password==null){
                return;
            }
            log(TAG, username + ", " + password);
            //用户校验
            String back;
            if(username.equals("admin")){
                back = "管理员 登入！";
            }else{
                back = username + " 登入！";
            }
            sendJsonResponse(response, back);
        }
    }

    @RequestMapping("/login")
    public String login_pc(HttpServletRequest request, Model model){
        if(request!=null){
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if(username==null || password==null){
                return null;
            }

            //
            String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
            log(TAG, username + ", " + password + ", md5: " + passwordMd5);

            //用户校验
            if(accountService.checkLogin(username, password)){
//            if(username.equals("admin") && password.equals("123")){
                HttpSession session = request.getSession();
//                session.setMaxInactiveInterval(Constants.LOGIN_VALID);//过期时间 s 默认30min
                session.setAttribute("username", username);
                return "redirect:/home";
            }else{
                log(TAG, "该用户不存在或密码错误");
                return go404Page(model, "该用户不存在或密码错误！");
            }
        }
        return null;
    }
}