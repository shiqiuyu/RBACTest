package com.youzhong.service;

import com.youzhong.entity.Resource;

import java.util.List;

public interface IResource {
    List<Resource> selectByPidIsNull();

    int insert(Resource record);

    int updateByPrimaryKey(Resource record);

    int deleteFlag(Resource record);

    List<Resource> selectMenu(int i, Integer id);
}
