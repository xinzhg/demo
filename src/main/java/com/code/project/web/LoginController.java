package com.code.project.web;

import com.code.project.biz.constants.Constants;
import com.code.project.biz.dao.UserInfoDAO;
import com.code.project.biz.dataobject.UserInfoDO;
import com.code.project.biz.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LoginController {
    private static final Log log = LogFactory.getLog(LoginController.class);

    @Autowired
    UserInfoDAO userInfoDAO;

    public boolean checkLogin(HttpServletRequest request) {
        String usernameCookie = null;
        String passwordCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("SESSION_LOGIN_USERNAME".equals(cookie.getName())) {
                    usernameCookie = cookie.getValue();
                    if (!StringUtils.isNotBlank(usernameCookie))
                        return false;
                }
                if ("SESSION_LOGIN_PASSWORD".equals(cookie.getName())) {
                    passwordCookie = cookie.getValue();
                    if (!StringUtils.isNotBlank(passwordCookie))
                        return false;
                }
            }
            if (usernameCookie != null && passwordCookie != null) {
                try {
                    UserInfoDO userInfoDO = new UserInfoDO();
                    userInfoDO.setUserName(usernameCookie);
                    userInfoDO.setPassWord(MD5Util.code(passwordCookie));
                    if(userInfoDAO.select(userInfoDO) != null){
                        return true;
                    } else {
                        return false;
                    }
                } catch (Exception e) {
                        return false;
                }
            }
        }
        return false;
    }
}
