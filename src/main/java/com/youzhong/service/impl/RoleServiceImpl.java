package com.youzhong.service.impl;

import com.youzhong.dao.RoleMapper;
import com.youzhong.entity.Role;
import com.youzhong.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByFlag(Role record) {
        if (record.getFlag()==0){
            record.setFlag(1);
        }else {
            record.setFlag(0);
        }

        return roleMapper.updateByPrimaryKey(record);
    }
}
