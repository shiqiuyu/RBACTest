package com.youzhong.service.impl;

import com.youzhong.dao.RoleResourceMapper;
import com.youzhong.entity.RoleBO;
import com.youzhong.entity.RoleResource;
import com.youzhong.entity.UserBO;
import com.youzhong.service.IRoleResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleResourceImpl implements IRoleResource {

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public List<Integer> selectByRoleID(Integer id) {
        return roleResourceMapper.selectByRoleID(id);
    }

    @Override
    public void deleteByRoleID(Integer id) {
        roleResourceMapper.deleteByRoleID(id);
    }

    @Override
    public int updateResourceByRoleID(RoleBO roleBO) {
        roleResourceMapper.deleteByRoleID(roleBO.getRoleId());


        for (Integer resourcesID : roleBO.getResourcesID()){
            RoleResource roleResource = new RoleResource();
            roleResource.setRoleid(roleBO.getRoleId());
            roleResource.setResid(resourcesID);

            roleResourceMapper.insert(roleResource);

        }

        return 0;
    }
}
