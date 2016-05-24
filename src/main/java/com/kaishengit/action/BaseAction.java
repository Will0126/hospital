package com.kaishengit.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class BaseAction extends ActionSupport {
    public Map<String,Object> getSession() {
        return ActionContext.getContext().getSession();
    }

    public Map<String,Object> getApplication() {
        return ActionContext.getContext().getApplication();
    }

    public HttpServletRequest getHttpRequest() {
        return ServletActionContext.getRequest();
    }

    public HttpServletResponse getHttpResponse() {
        return ServletActionContext.getResponse();
    }

    public HttpSession getHttpSession() {
        return getHttpRequest().getSession();
    }

    public ServletContext getServletContext() {
        return getHttpSession().getServletContext();
    }

    public void readerJson(Object object) throws IOException {
        String json = new Gson().toJson(object);
        HttpServletResponse response = getHttpResponse();
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }

}
