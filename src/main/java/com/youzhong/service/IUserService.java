package com.youzhong.service;

import com.github.pagehelper.PageInfo;
import com.youzhong.entity.User;

import java.util.List;

public interface IUserService {

    PageInfo<User> selectAll(Integer pageNum, Integer pageSize);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(User record);

    User selectByUserName(String string);

}
