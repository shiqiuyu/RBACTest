package com.youzhong.service;

import com.youzhong.entity.RoleBO;
import com.youzhong.entity.UserBO;

import java.util.List;

public interface IRoleResource {

    List<Integer> selectByRoleID(Integer id);

    void deleteByRoleID(Integer id);

    int updateResourceByRoleID(RoleBO roleBO);

}
