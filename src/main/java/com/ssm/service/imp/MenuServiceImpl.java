package com.ssm.service.imp;

import com.ssm.dao.IMenuDao;
import com.ssm.model.Children;
import com.ssm.model.MenuTree;
import com.ssm.service.IMenuService;
import com.ssm.utils.OrderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private IMenuDao menuDao;

    @Override
    public List<MenuTree> MenuTreeList() {

        List<MenuTree> list = menuDao.MenuTreeList();
        //根节点
        List<MenuTree> rootMenu = new ArrayList<MenuTree>();
        for (MenuTree nav : list) {
            if (nav.getPid()==null){ //父节点是0的，为根节点。
                rootMenu.add(nav);
            }
        }
        Collections.sort(rootMenu, OrderUtils.order());
        for (MenuTree nav : rootMenu) {
            /* 获取根节点下的所有子节点 使用getChild方法*/
            List<MenuTree> childList = getChild(nav.getId(), list);
            nav.setChildren(childList);//给根节点设置子节点
        }

        return rootMenu;
    }
    /**
     * 获取子节点
     * @param id 父节点id
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    public List<MenuTree> getChild(String id,List<MenuTree> allMenu){
        //子菜单
        List<MenuTree> childList = new ArrayList<MenuTree>();
        for (MenuTree nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if (id.equals(nav.getPid())){
                childList.add(nav);
            }
        }
        //递归
        for (MenuTree nav : childList) {
            nav.setChildren(getChild(nav.getId(), allMenu));
        }
        Collections.sort(childList,OrderUtils.order()); //排序
        //如果节点下没有子节点，返回一个空List（递归退出）
        if (childList.size() == 0 ){
            return new ArrayList<MenuTree>();
        }
        return childList;
    }
}
