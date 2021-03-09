package com.ssm.utils;

import com.ssm.model.MenuTree;

import java.util.Comparator;

public class OrderUtils {

    /*
     * 排序,根据order排序
     */
    public static Comparator<MenuTree>  order(){
        Comparator<MenuTree> comparator = new Comparator<MenuTree>() {
            @Override
            public int compare(MenuTree o1, MenuTree o2) {
                if (o1.getOrder() != o2.getOrder()){
                    return o1.getOrder() - o2.getOrder();
                }
                return 0 ;
            }
        };
        return comparator;
    }
}
