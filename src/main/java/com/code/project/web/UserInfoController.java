package com.code.project.web;

import com.code.project.biz.dao.CameraDAO;
import com.code.project.biz.dao.UserInfoDAO;
import com.code.project.biz.dataobject.CameraDO;
import com.code.project.biz.dataobject.UserInfoDO;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserInfoController extends LoginController {
    private static final Log log = LogFactory.getLog(UserInfoController.class);

    @Autowired
    UserInfoDAO userInfoDAO;

    @RequestMapping(value = "/userinfo_index", method = {RequestMethod.GET})
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response ) throws Exception {
        if(!checkLogin(request)) {
            response.sendRedirect("/login?rurl=userinfo_index");
            return null;
        }

        List<UserInfoDO> list = userInfoDAO.select(new UserInfoDO());
        response.setContentType("text/html; charset=utf-8");
        ModelAndView modelAndView = new ModelAndView("screen/userinfo_index");
        modelAndView.addObject("list", list);
        return modelAndView;
    }


    @RequestMapping(value = "/add_userinfo", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response ) {
        ModelAndView modelAndView = new ModelAndView("screen/json");
        try {
            response.setContentType("application/json; charset=utf-8");
            String userName = request.getParameter("ziduan2");
            String passWord = request.getParameter("ziduan3");
            String type = request.getParameter("ziduan4");
            String email = request.getParameter("ziduan5");
            String readOrignal = request.getParameter("ziduan6");
            String onOff = request.getParameter("ziduan7");
            String defog = request.getParameter("ziduan8");
            String readDefog = request.getParameter("ziduan9");
            String registerCamera = request.getParameter("ziduan10");
            UserInfoDO userInfoDO = new UserInfoDO();
            userInfoDO.setOnOff(Integer.parseInt(onOff));
            userInfoDO.setEmail(email);
            userInfoDO.setUserName(userName);
            userInfoDO.setDeFog(Integer.parseInt(defog));
            userInfoDO.setReadDeFog(Integer.parseInt(readDefog));
            userInfoDO.setReadOrignal(Integer.parseInt(readOrignal));
            userInfoDO.setRegisterCamera(Integer.parseInt(registerCamera));
            userInfoDO.setType(Integer.parseInt(type));
            userInfoDAO.update(userInfoDO);
        }catch (Exception e) {
            log.error("error in add camera",e);
            Gson gson = new Gson();
            Map map = new HashMap();
            map.put("status" , "fail");
            map.put("message" , "args error");
            return modelAndView.addObject("msg",gson.toJson(map));
        }
        Gson gson = new Gson();
        Map map = new HashMap();
        map.put("status" , "success");
        return modelAndView.addObject("msg",gson.toJson(map));
    }

    @RequestMapping(value = "/delete_userinfo", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response ) {
        ModelAndView modelAndView = new ModelAndView("screen/json");
        try {
            String id = request.getParameter("id");
            userInfoDAO.delete(Integer.parseInt(id));
        } catch (Exception e) {
            log.error("error in rootcontroller :" ,e);
            Gson gson = new Gson();
            Map map = new HashMap();
            map.put("status" , "fail");
            return modelAndView.addObject("msg",gson.toJson(map));
        }
        Gson gson = new Gson();
        Map map = new HashMap();
        map.put("status" , "success");
        return modelAndView.addObject("msg",gson.toJson(map));
    }


    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ModelAndView handleException(ModelAndView modelAndView) {
        modelAndView.addObject("error", "true");
        return modelAndView;
    }

}
