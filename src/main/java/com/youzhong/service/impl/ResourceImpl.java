package com.youzhong.service.impl;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.youzhong.dao.ResourceMapper;
import com.youzhong.entity.Resource;
import com.youzhong.service.IResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ResourceImpl implements IResource {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> selectByPidIsNull() {
        return resourceMapper.selectByPidIsNull();
    }

    @Override
    public int insert(Resource record) {
        return resourceMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Resource record) {
        if (record.getFlag() == null) {
            record.setFlag(0);
        }

        return resourceMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteFlag(Resource record) {
        if (record.getFlag() == 0) {
            record.setFlag(1);
        } else {
            record.setFlag(0);
        }

        return resourceMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Resource> selectMenu(int type, Integer uid) {
        Map<String, Integer> map = new HashMap<>();

        map.put("type", type);
        map.put("uid", uid);
        return resourceMapper.selectMenuByUid(map);
    }
}
