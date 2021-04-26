package com.ssm.entity;

public class User {
    /**
     * id
     */
    private int id;

    /**
     * 密码
     */
    private String pwd;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 类型
     */
    private int type;
    /**
     * 名称
     */
    private String name;
    /**
     * 创建时间
     */
    private java.util.Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
}
