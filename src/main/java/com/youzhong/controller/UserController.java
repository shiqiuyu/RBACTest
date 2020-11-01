package com.youzhong.controller;

import com.github.pagehelper.PageInfo;
import com.youzhong.entity.Resource;
import com.youzhong.entity.Role;
import com.youzhong.entity.User;
import com.youzhong.entity.UserBO;
import com.youzhong.service.IResource;
import com.youzhong.service.IRoleService;
import com.youzhong.service.IUserRoleService;
import com.youzhong.service.IUserService;
import com.youzhong.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private IUserRoleService iUserRoleService;

    @Autowired
    private IResource iResource;


    @GetMapping("userList")
    public PageInfo<User> userList(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        PageInfo<User> userPageInfo = iUserService.selectAll(pageNum, pageSize);
        return userPageInfo;
    }

    @PostMapping("add")
    public int add(@RequestBody User user) {
        return iUserService.insert(user);

    }

    @PostMapping("update")
    public int update(@RequestBody User user) {
        return iUserService.updateByPrimaryKey(user);
    }

    @GetMapping("selectById")
    public User selectById(@RequestParam Integer id) {
        return iUserService.selectByPrimaryKey(id);
    }

    @PostMapping("updateFlag")
    public int updateFlag(@RequestBody User user) {
        if (user.getFlag() == 0) {
            user.setFlag(1);
        } else {
            user.setFlag(0);
        }
        return iUserService.updateByPrimaryKey(user);
    }

    @GetMapping("getRole")
    public Map<String, Object> getRole(Integer id) {
        System.out.println("id = " + id);
        Map<String, Object> Map = new HashMap<>();
        //所有角色
        List<Role> roleList = iRoleService.selectAll();
        //根据UID查询角色RoleID
        List<Integer> UIDList = iUserRoleService.selectByUID(id);
        System.out.println(UIDList);
        Map.put("roleList", roleList);
        Map.put("UIDList", UIDList);
        return Map;
    }

    @PostMapping("updateRoleByUid")
    public int updateRoleByUid(@RequestBody UserBO userBO) {
        return iUserRoleService.updateRoleByUID(userBO);

    }


    @PostMapping("login")
    public Map<String, Object> login(@RequestBody User user, HttpSession session) {
        User u = iUserService.selectByUserName(user.getUsername());
        Map<String, Object> map = new HashMap<>();
        if (u == null) {
            map.put("status", 0);
            map.put("message", "登录失败:用户名错误");
        } else if (u.getPassword().equals(MD5.md5(user.getPassword()))) {
            map.put("status", 1);
            map.put("message", "登录成功");

            //登陆成功用户存入session
            session.setAttribute("user", u);
            //存入map集合 方便前端使用
            map.put("user", u);
            //根据用户id获取菜单资源
            List<Resource> menuList = iResource.selectMenu(0, u.getId());
            System.out.println("menuList = " + menuList);
            //根据用户id获取按钮资源
            List<Resource> butList = iResource.selectMenu(1, u.getId());
            map.put("menuList", menuList);
            map.put("butList", butList);


        } else {
            map.put("status", 0);
            map.put("message", "登录失败:密码错误");
        }
        return map;

    }

}
