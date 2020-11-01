package com.youzhong.controller;

import com.youzhong.entity.Resource;
import com.youzhong.entity.Role;
import com.youzhong.entity.RoleBO;
import com.youzhong.service.IResource;
import com.youzhong.service.IRoleResource;
import com.youzhong.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IRoleResource roleResource;

    @Autowired
    private IResource resource;


    @GetMapping("roleList")
    public List<Role> roleList() {
        List<Role> roles = roleService.selectAll();
        System.out.println("roles = " + roles);
        return roles;
    }

    @GetMapping("getAllResource")
    public List<Resource> getAllResource() {
        List<Resource> resourceList = resource.selectByPidIsNull();
        return resourceList;
    }

    @GetMapping("getRoleResource")
    public List<Integer> getRoleResource(Integer roleId) {
        List<Integer> integerList = roleResource.selectByRoleID(roleId);
        return integerList;
    }

    @PostMapping("addRole")
    public int addRole(@RequestBody Role role) {

        roleService.insert(role);
        return 0;
    }

    @PostMapping("updateRole")
    public int updateRole(@RequestBody Role role) {

        roleService.updateByPrimaryKey(role);
        return 0;
    }

    @PostMapping("deleteRole")
    public int deleteRole(@RequestBody Role role) {

        return roleService.deleteByFlag(role);
    }


    @PostMapping("updateResourcesByRoleID")
    public int updateResourcesByRoleID(@RequestBody RoleBO roleBO) {
        System.out.println("roleBO = " + roleBO);
        return roleResource.updateResourceByRoleID(roleBO);
    }

}
