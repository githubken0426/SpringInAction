package org.ken.fsd.entity;

import java.util.Date;

public class Apimapping {
    private String id;

    private String apiid;

    private String urldown;

    private String urlup;

    private String apitype;

    private String memo;

    private String deleteFlag;

    private String createid;

    private Date createDate;

    private String modifyid;

    private Date modifyDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getApiid() {
        return apiid;
    }

    public void setApiid(String apiid) {
        this.apiid = apiid == null ? null : apiid.trim();
    }

    public String getUrldown() {
        return urldown;
    }

    public void setUrldown(String urldown) {
        this.urldown = urldown == null ? null : urldown.trim();
    }

    public String getUrlup() {
        return urlup;
    }

    public void setUrlup(String urlup) {
        this.urlup = urlup == null ? null : urlup.trim();
    }

    public String getApitype() {
        return apitype;
    }

    public void setApitype(String apitype) {
        this.apitype = apitype == null ? null : apitype.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public String getCreateid() {
        return createid;
    }

    public void setCreateid(String createid) {
        this.createid = createid == null ? null : createid.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModifyid() {
        return modifyid;
    }

    public void setModifyid(String modifyid) {
        this.modifyid = modifyid == null ? null : modifyid.trim();
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}