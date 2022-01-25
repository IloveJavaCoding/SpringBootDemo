package com.example.sbdemo.service;

import com.example.sbdemo.dao.Account;

/**
 * @author Virgo
 * @version 1.0
 * @data 2021/11/19 10:29
 * @usage 用户接口
 */
public interface AccountService extends CommonService<Account> {
    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    boolean isExist(String username);

    /**
     * 判断用户密码是否匹配
     * @param username
     * @param password
     * @return
     */
    boolean checkLogin(String username, String password);
}
