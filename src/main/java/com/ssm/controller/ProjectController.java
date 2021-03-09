package com.ssm.controller;

import com.ssm.model.ProjectCreate;
import com.ssm.service.IProjectCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private IProjectCreateService projectCreateService;

    /***
     *  分页查询项目立项数据
     * @param key
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("/pageProjectApproval.do")
    @ResponseBody
    public Map pageProjectApproval(String key, int pageIndex, int pageSize) {
        ProjectCreate create = new ProjectCreate();
        create.setProName(key);
        create.setPageIndex(pageIndex * pageSize);
        create.setPageSize(pageSize);
        Map<String, Object> map = projectCreateService.pageProjectApproval(create);
        return map;
    }

    @RequestMapping("/deleteProjectApproval.do")
    @ResponseBody
    public Map deleteProjectApproval(String ids) {

        String[] arr = ids.split(",");
        List<String> listId = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            listId.add(arr[i]);
        }
        Map<String, Object> map = new HashMap<>();
        if (projectCreateService.deleteProjectCreate(listId) > 0) {
            map.put("SUCCESS", "1");
        } else {
            map.put("EROOR", "0");
        }
        return map;
    }

    @RequestMapping(value = "/saveProjectCreate.do", method = RequestMethod.POST)
    @ResponseBody
    public Map saveProjectCreate(@RequestBody ProjectCreate create) {
        Map<String, Object> map = new HashMap<>();
        if (projectCreateService.insertProjectCreate(create) > 0) {
            map.put("SUCCESS", "1");
        } else {
            map.put("EROOR", "0");
        }
        return map;
    }

    @RequestMapping(value = "/findIdProjectCreate.do")
    @ResponseBody
    public ProjectCreate findIdProjectCreate(String id) {
        return projectCreateService.findIdProjectCreate(id);
    }
}
