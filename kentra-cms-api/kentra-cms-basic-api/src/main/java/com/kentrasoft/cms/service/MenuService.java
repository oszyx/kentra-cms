package com.kentrasoft.cms.service;


import com.kentrasoft.cms.base.service.BaseService;
import com.kentrasoft.cms.model.Menu;

import java.util.List;

/**
 * 描述：MenuService
 *
 * @author : zmk
 * @date : 2018-09-07
 */
public interface MenuService extends BaseService<Menu> {

    public List<Menu> findByIdsStrNormal(String ids);

    /**
     * 描述：获取树形菜单
     *
     * @return menus
     */
    public List<Menu> getMenuTree(List<Menu> menus);

    /**
     * 描述：获取按钮权限
     *
     * @return menus
     */
    public List<Menu> getButtonRights(List<Menu> menus);

    /**
     * 描述：根据角色权限 获得菜单
     *
     * @param roleRights
     * @return
     */
    List<Menu> getMenuByRoleRights(String roleRights);
}