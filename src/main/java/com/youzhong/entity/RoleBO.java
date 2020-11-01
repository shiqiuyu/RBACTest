package com.youzhong.entity;

import java.util.List;

//此类用于接收前端资源分配参数 一个rID 多个ResID
public class RoleBO {

    private Integer roleId;

    private List<Integer> resourcesID;

    public List<Integer> getResourcesID() {
        return resourcesID;
    }

    public void setResourcesID(List<Integer> resourcesID) {
        this.resourcesID = resourcesID;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "RoleBO{" +
                "roleId=" + roleId +
                ", resourcesID=" + resourcesID +
                '}';
    }
}
