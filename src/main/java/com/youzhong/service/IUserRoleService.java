package com.youzhong.service;

import com.youzhong.entity.UserBO;
import com.youzhong.entity.UserRole;

import java.util.List;

public interface IUserRoleService {

    List<Integer> selectByUID(Integer id);

    int updateRoleByUID(UserBO userBO);

    void deleteByUID(Integer id);
}
