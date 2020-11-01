package com.youzhong.entity;


import java.util.List;

//此类用于接收前端角色分配参数 一个UID 多个RoleID
public class UserBO {

    private Integer uid;

    private List<Integer> roleID;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public List<Integer> getRoleID() {
        return roleID;
    }

    public void setRoleID(List<Integer> roleID) {
        this.roleID = roleID;
    }

    public UserBO(Integer uid, List<Integer> roleID) {
        this.uid = uid;
        this.roleID = roleID;
    }

    public UserBO() {
    }
}
