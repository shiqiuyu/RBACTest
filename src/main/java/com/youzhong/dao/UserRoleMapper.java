package com.youzhong.dao;

import com.youzhong.entity.UserBO;
import com.youzhong.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserBO userBO);

    List<Integer> selectByUID(Integer id);

    void deleteByUID(Integer id);
}