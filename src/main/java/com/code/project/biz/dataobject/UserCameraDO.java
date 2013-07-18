package com.code.project.biz.dataobject;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 13-8-3
 * Time: 下午11:44
 * To change this template use File | Settings | File Templates.
 */
public class UserCameraDO {
    private Integer id;

    private String userName;

    private String cameraName;

    private Integer cameraId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public Integer getCameraId() {
        return cameraId;
    }

    public void setCameraId(Integer cameraId) {
        this.cameraId = cameraId;
    }
}
