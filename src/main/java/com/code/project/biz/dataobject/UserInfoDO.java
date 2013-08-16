package com.code.project.biz.dataobject;


import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxin
 * Date: 13-6-18
 * Time: 下午2:24
 * To change this template use File | Settings | File Templates.
 */
public class UserInfoDO {
    private Integer id;

    private String userName;

    private String passWord;

    private Integer type;

    private String email;

    private Integer readOrignal;

    private Integer onOff;

    private Integer deFog;

    private Integer readDeFog;

    private Integer registerCamera;

    private Date createTime;

    private Date modifyTime;

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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getReadOrignal() {
        return readOrignal;
    }

    public void setReadOrignal(Integer readOrignal) {
        this.readOrignal = readOrignal;
    }

    public Integer getOnOff() {
        return onOff;
    }

    public void setOnOff(Integer onOff) {
        this.onOff = onOff;
    }

    public Integer getDeFog() {
        return deFog;
    }

    public void setDeFog(Integer deFog) {
        this.deFog = deFog;
    }

    public Integer getReadDeFog() {
        return readDeFog;
    }

    public void setReadDeFog(Integer readDeFog) {
        this.readDeFog = readDeFog;
    }

    public Integer getRegisterCamera() {
        return registerCamera;
    }

    public void setRegisterCamera(Integer registerCamera) {
        this.registerCamera = registerCamera;
    }
}
