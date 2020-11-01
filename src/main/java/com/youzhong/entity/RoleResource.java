package com.youzhong.entity;

public class RoleResource {
    private Integer id;

    private Integer roleid;

    private Integer resid;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getResid() {
        return resid;
    }

    public void setResid(Integer resid) {
        this.resid = resid;
    }

    @Override
    public String toString() {
        return "RoleResource{" +
                "id=" + id +
                ", roleid=" + roleid +
                ", resid=" + resid +
                '}';
    }
}