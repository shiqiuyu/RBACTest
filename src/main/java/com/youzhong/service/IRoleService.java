package com.youzhong.service;

import com.youzhong.entity.Role;

import java.util.List;

public interface IRoleService {

    List<Role> selectAll();
    int insert(Role record);
    int updateByPrimaryKey(Role record);
    int deleteByFlag(Role record);
}
