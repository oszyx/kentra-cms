package com.kentrasoft.cms.service;


import com.kentrasoft.base.plugin.PageForm;
import com.kentrasoft.base.service.BaseService;
import com.kentrasoft.cms.model.Menu;

import java.util.List;

/**
 * 描述：MenuService
 *
 * @author : zmk
 * @date : 2018-09-07
 */
public interface MenuService extends BaseService<Menu> {

    public List<Menu> getAllRightsTree(List<Menu> menus);

    public List<Menu> findByIdsStrNormal(String ids);

    public List<Menu> getMenuTree(List<Menu> menus);

    public List<Menu> getButtonRights(List<Menu> menus);

    /**
     * 描述：获取角色权限菜单
     *
     * @param roleRights
     * @return
     */
    List<Menu> findByRoleRights(String roleRights);
}