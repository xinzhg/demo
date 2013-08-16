package com.code.project.web;

import com.code.project.biz.dao.SystemLogDAO;
import com.code.project.biz.dao.UserLogDAO;
import com.code.project.biz.dataobject.SystemLogDO;
import com.code.project.biz.dataobject.UserLogDO;
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
public class UserLogController extends LoginController {
    private static final Log log = LogFactory.getLog(UserLogController.class);

    @Autowired
    UserLogDAO userLogDAO;

    @RequestMapping(value = "/userlog_index", method = {RequestMethod.GET})
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response ) throws Exception {
        if(!checkLogin(request)) {
            response.sendRedirect("/login?rurl=userlog_index");
            return null;
        }

        List<UserLogDO> list = userLogDAO.select(new UserLogDO());
        response.setContentType("text/html; charset=utf-8");
        ModelAndView modelAndView = new ModelAndView("screen/userlog_index");
        modelAndView.addObject("list", list);
        return modelAndView;
    }


    @RequestMapping(value = "/add_userlog", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response ) {
        ModelAndView modelAndView = new ModelAndView("screen/json");
        try {

        }catch (Exception e) {
            log.error("error in add camera",e);
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

    @RequestMapping(value = "/delete_userlog", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response ) {
        ModelAndView modelAndView = new ModelAndView("screen/json");
        try {
            String id = request.getParameter("id");
            userLogDAO.delete(Integer.parseInt(id));
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
