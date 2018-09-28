package com.kentrasoft.cms.service;

import com.kentrasoft.utils.plugin.PageForm;
import com.kentrasoft.cms.entity.Menu;

import java.util.List;

/**
 * 描述：
 *
 * @author zhangmengkang
 * @date 2018/5/28 10:27
 */
public interface MenuService {
	/**
	 * 查询导航展示项
	 * @return
	 */
	public List<Menu> findAllMenu();
	
	/**
	 * 查询用户显示项
	 */
	public List<Menu> findUserMenu(String id);
	
	/**
     * 获取菜单树数据
     */
    List<Menu> queryMenuList();

    /**
     * 描述：条件分页查询
     * @param page
     * @return
     */
    PageForm<Menu> getPageList(PageForm<Menu> page, String menuName, String id);

    /**
     * 描述：新增菜单
     * @param menu
     */
    void add(Menu menu);

    /**
     * 描述：根据菜单名查找菜单
     * @param menuName
     * @return
     */
    Menu findMenuByName(String menuName);

    /**
     * 描述：根据菜单Id查找菜单
     * @param id
     * @return
     */
    Menu findById(Long id);

    /**
     * 描述：修改菜单信息
     * @param menu
     */
    void edit(Menu menu);

    /**
     * 描述：删除菜单
     * @param ids
     */
    String delete(String ids);

    /**
     * 统计菜单树节点数量
     */
    int countTreeData();
	
}
