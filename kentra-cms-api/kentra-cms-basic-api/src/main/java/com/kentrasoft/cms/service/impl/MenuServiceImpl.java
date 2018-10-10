package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.base.dao.BaseDao;
import com.kentrasoft.cms.base.service.impl.BaseServiceImpl;
import com.kentrasoft.cms.dao.MenuDao;
import com.kentrasoft.cms.model.Menu;
import com.kentrasoft.cms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：MenuServiceImpl
 *
 * @author : zmk
 * @date : 2018-09-07
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public BaseDao getModelDao() {
        return this.menuDao;
    }


    /**
     * 描述：根据ids获取菜单
     *
     * @param ids 菜单id字符串
     * @return menus
     */
    @Override
    public List<Menu> findByIdsStrNormal(String ids) {
        // 获取menu
        List<Menu> menus = menuDao.findByIdsStr(ids);
        // 获取可用的menu
        List<Menu> menusAvailable = new ArrayList<>();
        for (Menu menu : menus) {
            if (menu.getMenuStatus() == 1) {
                menusAvailable.add(menu);
            }
        }
        return menusAvailable;
    }


    /**
     * 描述：获取角色权限菜单
     *
     * @param roleRights
     * @return
     */
    @Override
    public List<Menu> findByRoleRights(String roleRights) {

        return null;
    }

    /**
     * 描述：获取所有可用权限
     *
     * @return menus
     */
    @Override
    public List<Menu> getAllRightsTree(List<Menu> menus) {
        //获取菜单
        Map<Long, Menu> menuMap = new HashMap<>();
        for (Menu menu : menus) {
            menuMap.put(menu.getId(), menu);
        }

        // 组装树形菜单
        Menu root = null;
        for (Menu menu : menuMap.values()) {
            if (menu.getMenuPid() == null || menu.getMenuPid() == 0) {
                root = menu;
            } else {
                menuMap.get(menu.getMenuPid()).addChildMenu(menu);
            }
        }

        // 4.菜单排序
        root.sameLevelSort();
        return root.getChildMenus();
    }


    /**
     * 描述：获取树形菜单
     *
     * @return menus
     */
    @Override
    public List<Menu> getMenuTree(List<Menu> menus) {
        //获取菜单
        Map<Long, Menu> menuMap = new HashMap<>();
        for (Menu menu : menus) {
            // 如果是叶子节点就不添加
            if (menu.getMenuLeaf() == 0) {
                menuMap.put(menu.getId(), menu);
            }
        }

        // 组装树形菜单
        Menu root = null;
        for (Menu menu : menuMap.values()) {
            if (menu.getMenuPid() == null || menu.getMenuPid() == 0) {
                root = menu;
            } else {
                menuMap.get(menu.getMenuPid()).addChildMenu(menu);
            }
        }

        // 4.菜单排序
        root.sameLevelSort();
        return root.getChildMenus();
    }



    /**
     * 描述：获取按钮权限
     *
     * @return menus
     */
    @Override
    public List<Menu> getButtonRights(List<Menu> menus) {
        //获取菜单
        List<Menu> buttonRights = new ArrayList<>();
        for (Menu menu : menus) {
            // 添加所有可用叶子节点
            if (menu.getMenuLeaf() == 1) {
                buttonRights.add(menu);
            }
        }
        return buttonRights;
    }

}
