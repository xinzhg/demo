package com.code.project.web;

import com.code.project.biz.constants.Constants;
import com.code.project.biz.dao.TestDAO;
import com.code.project.biz.dao.UserInfoDAO;
import com.code.project.biz.dataobject.TestDO;
import com.code.project.biz.dataobject.UserInfoDO;
import com.code.project.biz.util.MD5Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.MD5;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class RootController {
    private static final Log log = LogFactory.getLog(RootController.class);

    @Autowired
    UserInfoDAO userInfoDAO;

    @RequestMapping(value = "/index", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response ) throws Exception {
        if(!checkLogin(request)) {
            response.sendRedirect("/login");
            return null;
        }
        response.setContentType("application/json; charset=utf-8");
        ModelAndView modelAndView = new ModelAndView("screen/test");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username == null || password == null) {
            modelAndView.addObject("msg", "less arg");
            log.info("less arg");
            return  modelAndView;
        }
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setDeFog(1);
        userInfoDO.setEmail("123");
        userInfoDO.setOnOff(1);
        userInfoDO.setReadDeFog(1);
        userInfoDO.setUserName(username);
        userInfoDO.setPassWord(password);
        Integer bl = userInfoDAO.add(userInfoDO);
        if(bl > 0) {
            modelAndView.addObject("msg", "success");
            log.info("success");
        } else {
            modelAndView.addObject("msg", "fail");
            log.info("fail");
        }
        return modelAndView;
    }


    @RequestMapping(value = "/reg", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView reg(HttpServletRequest request, HttpServletResponse response ) {
        ModelAndView modelAndView = new ModelAndView("screen/reg");
        try {
            response.setContentType("text/html; charset=utf-8");
            String username = request.getParameter("username");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            String email = request.getParameter("email");
            if((username == null) && (password1 == null) && (password2 == null)) {
                modelAndView.addObject("blank", "true");;
                return  modelAndView;
            } else if ((username == null) || (password1 == null) || (password2 == null)){
                modelAndView.addObject("blank", "false");;
                return  modelAndView;
            } else if ((username != null) && (password1 != null) && (password2 != null)) {
                if (password1.trim().equals(password2.trim())) {
                    UserInfoDO userInfoDO = new UserInfoDO();
                    userInfoDO.setDeFog(Constants.NO_RIGHT);
                    userInfoDO.setEmail("123");
                    userInfoDO.setOnOff(Constants.NO_RIGHT);
                    userInfoDO.setReadDeFog(Constants.NO_RIGHT);
                    userInfoDO.setUserName(username);
                    userInfoDO.setPassWord(MD5Util.code(password1));
                    Integer bl = userInfoDAO.add(userInfoDO);
                    response.sendRedirect("/login");
                    return  modelAndView;
                } else {
                    modelAndView.addObject("blank", "false");
                    return  modelAndView;
                }
            }
        } catch (Exception e) {
            log.error("error in rootcontroller :" ,e);
            return handleException(modelAndView);
        }
           return modelAndView;
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response ) {
        ModelAndView modelAndView = new ModelAndView("screen/login");
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String host = request.getServerName();
            Cookie cookie = new Cookie("SESSION_LOGIN_USERNAME", username); // 保存用户名到Cookie
            cookie.setPath("/");
            cookie.setDomain(host);
            cookie.setMaxAge(99999999);
            response.addCookie(cookie);
            cookie = new Cookie("SESSION_LOGIN_PASSWORD", MD5Util.code(password));
            cookie.setPath("/");
            cookie.setDomain(host);
            cookie.setMaxAge(99999999);
            response.addCookie(cookie);
            UserInfoDO userInfoDO = new UserInfoDO();
            userInfoDO.setUserName(username);
            userInfoDO.setPassWord(MD5Util.code(password));
            List<UserInfoDO> list = userInfoDAO.select(userInfoDO);
            if(list == null || list.isEmpty()) {

            } else {
                response.sendRedirect("/index");
            }
        } catch (Exception e) {
            log.error("error in rootcontroller :" ,e);
            return handleException(modelAndView);
        }
        return modelAndView;
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ModelAndView handleException(ModelAndView modelAndView) {
        modelAndView.addObject("error", "true");
        return modelAndView;
    }

    public boolean checkLogin(HttpServletRequest request) {
        String usernameCookie = null;
        String passwordCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("SESSION_LOGIN_USERNAME".equals(cookie.getName())) {
                    usernameCookie = cookie.getValue();
                }
                if ("SESSION_LOGIN_PASSWORD".equals(cookie.getName())) {
                    passwordCookie = cookie.getValue();
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
