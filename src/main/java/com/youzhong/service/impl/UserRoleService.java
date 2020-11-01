package com.youzhong.service.impl;

import com.youzhong.dao.UserRoleMapper;
import com.youzhong.entity.UserBO;
import com.youzhong.entity.UserRole;
import com.youzhong.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserRoleService implements IUserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public List<Integer> selectByUID(Integer id) {
        return userRoleMapper.selectByUID(id);
    }

    @Override
    public int updateRoleByUID(UserBO userBO) {
        //先根据UID删除角色
        userRoleMapper.deleteByUID(userBO.getUid());
        //在根据前端获取角色List集合获取角色
        for(Integer roleID  : userBO.getRoleID()){
            UserRole userRole = new UserRole();
            //添加用户id
            userRole.setUid(userBO.getUid());
            //添加角色ID
            userRole.setRoleid(roleID);
            //userRole表中添加
            userRoleMapper.insert(userRole);

        }

        return 0;
    }

    @Override
    public void deleteByUID(Integer id) {
        userRoleMapper.deleteByUID(id);
    }
}
