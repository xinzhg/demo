package com.code.project.biz.dataobject;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 13-8-3
 * Time: 下午5:58
 * To change this template use File | Settings | File Templates.
 */
public class CameraDO {
    private Integer id;

    private String cameraIP;

    private String cameraName = null;

    private Integer cameraStatus;

    private String cameraMaster = null;

    private Date createTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCameraIP() {
        return cameraIP;
    }

    public void setCameraIP(String cameraIP) {
        this.cameraIP = cameraIP;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    public Integer getCameraStatus() {
        return cameraStatus;
    }

    public void setCameraStatus(Integer cameraStatus) {
        this.cameraStatus = cameraStatus;
    }

    public String getCameraMaster() {
        return cameraMaster;
    }

    public void setCameraMaster(String cameraMaster) {
        this.cameraMaster = cameraMaster;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
