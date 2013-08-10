package com.code.project.web;

import com.code.project.biz.constants.Constants;
import com.code.project.biz.dao.CameraDAO;
import com.code.project.biz.dao.UserInfoDAO;
import com.code.project.biz.dataobject.CameraDO;
import com.code.project.biz.dataobject.UserInfoDO;
import com.code.project.biz.util.MD5Util;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CameraController extends LoginController {
    private static final Log log = LogFactory.getLog(CameraController.class);

    @Autowired
    CameraDAO cameraDAO;

    @RequestMapping(value = "/camera_index", method = {RequestMethod.GET})
    public ModelAndView execute(HttpServletRequest request, HttpServletResponse response ) throws Exception {
        if(!checkLogin(request)) {
            response.sendRedirect("/login");
            return null;
        }

        List<CameraDO> list = cameraDAO.select(new CameraDO());
        response.setContentType("text/html; charset=utf-8");
        ModelAndView modelAndView = new ModelAndView("screen/camera_index");
        modelAndView.addObject("list", list);
        return modelAndView;
    }


    @RequestMapping(value = "/add_camera", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response ) {
        ModelAndView modelAndView = new ModelAndView("screen/json");
        try {
            response.setContentType("application/json; charset=utf-8");
            String cameraIP = request.getParameter("ziduan2");
            String cameraName = request.getParameter("ziduan3");
            String cameraStatus = request.getParameter("ziduan4");
            String cameraMaster = request.getParameter("ziduan5");
            CameraDO cameraDO = new CameraDO();
            cameraDO.setCameraIP(cameraIP);
            cameraDO.setCameraMaster(cameraMaster);
            cameraDO.setCameraName(cameraName);
            cameraDO.setCameraStatus(Integer.parseInt(cameraStatus));
            cameraDAO.add(cameraDO);
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

    @RequestMapping(value = "/delete_camera", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response ) {
        ModelAndView modelAndView = new ModelAndView("screen/json");
        try {
            String id = request.getParameter("id");
            cameraDAO.delete(Integer.parseInt(id));
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
