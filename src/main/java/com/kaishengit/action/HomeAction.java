package com.kaishengit.action;

import com.kaishengit.service.AccountService;
import org.apache.struts2.convention.annotation.Action;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

public class HomeAction extends BaseAction {

    private String loginName;
    private String password;

    @Inject
    private AccountService accountService;



    @Action("index")
    public String index(){
        return SUCCESS;
    }


    @Action("/home")
    public String Home(){
        //获取登录ip
        HttpServletRequest request = getHttpRequest();
        String ip = request.getRemoteAddr();
        accountService.findAccountByLoginName(loginName,password,ip);
        return null;
    }




    //get set

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
