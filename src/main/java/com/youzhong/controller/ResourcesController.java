package com.youzhong.controller;

import com.youzhong.entity.Resource;
import com.youzhong.service.IResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("resources")
public class ResourcesController {

    @Autowired
    private IResource iResource;

    @GetMapping("getResource")
    @ResponseBody
    public List<Resource> getResource() {
        System.out.println("---------------");

        List<Resource> resources = iResource.selectByPidIsNull();
        System.out.println("resources = " + resources);

        return iResource.selectByPidIsNull();
    }

    @PostMapping("add")
    public int add(@RequestBody Resource resource) {
        return iResource.insert(resource);
    }

    @PostMapping("update")
    public int update(@RequestBody Resource resource) {
        return iResource.updateByPrimaryKey(resource);
    }

    @PostMapping("deleteResources")
    public int deleteResources(@RequestBody Resource resource) {
        return iResource.deleteFlag(resource);
    }

}
