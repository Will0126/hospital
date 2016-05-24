package com.kaishengit.service;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.pojo.Account;

import javax.inject.Inject;

public class AccountService {

    @Inject
    private AccountDao accountDao;

    public void findAccountByLoginName(String loginName, String password, String ip) {
        Account account =  accountDao.findByProperty("loginName",loginName);
        if(account != null){
            //判断是否是禁用状态
            if("禁用".equals(account.getState())){
                
            }
        }
    }
}
