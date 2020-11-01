package com.youzhong.dao;

import com.youzhong.entity.RoleResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    RoleResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleResource record);

    int updateByPrimaryKey(RoleResource record);

    List<Integer> selectByRoleID(Integer id);

    void deleteByRoleID(Integer id);
}