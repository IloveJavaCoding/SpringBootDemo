package com.example.sbdemo.serviceimp;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.sbdemo.dao.Account;
import com.example.sbdemo.mapper.AccountMapper;
import com.example.sbdemo.service.AccountService;
import com.example.sbdemo.util.TextUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Virgo
 * @version 1.0
 * @data 2021/11/19 10:33
 * @usage 用户实现类
 */
//注册服务
@Transactional
@Service("accountService")
public class AccountServiceImp extends CommonServiceImp<AccountMapper, Account> implements AccountService {
    @Override
    public boolean isExist(String username) {
        if (TextUtil.isEmpty(username)) {
            return false;
        }
        EntityWrapper<Account> wrapper = new EntityWrapper<>();
        wrapper.eq("username", username);
        return selectOne(wrapper)!=null;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        if (TextUtil.isEmpty(username)) {
            return false;
        }

        return baseMapper.checkLogin(username, password)>0;
//        EntityWrapper<Account> wrapper = new EntityWrapper<>();
//        wrapper.eq("username", username);
//        wrapper.and();
//        wrapper.eq("password", password);
//
//        Account account = selectOne(wrapper);//baseMapper.checkLogin(username, password);
//        return account!=null;

    }
}
