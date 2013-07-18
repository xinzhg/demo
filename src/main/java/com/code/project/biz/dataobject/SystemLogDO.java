package com.code.project.biz.dataobject;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 13-8-3
 * Time: 下午9:22
 * To change this template use File | Settings | File Templates.
 */
public class SystemLogDO {
    private Integer id;

    private Date systemTime;

    private String serverName;

    private String content;

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

    public Date getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
