package com.ssm.controller;

import com.ssm.model.Children;
import com.ssm.model.MenuTree;
import com.ssm.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/***
 * 菜单信息
 */
@Controller
@RequestMapping("/menu")
public class MenuController {


    @Autowired
    private IMenuService menuService;

    /***
     *   菜单信息查询
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/showMenu.do")
    @ResponseBody
    public List<MenuTree> showMenu(HttpServletRequest request, HttpServletResponse response){
        return menuService.MenuTreeList();
    }

}
