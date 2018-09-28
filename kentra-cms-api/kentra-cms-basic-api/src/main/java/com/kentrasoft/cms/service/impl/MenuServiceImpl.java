package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.dao.MenuMapper;
import com.kentrasoft.cms.entity.Menu;
import com.kentrasoft.cms.entity.MenuExample;
import com.kentrasoft.cms.service.MenuService;
import com.kentrasoft.utils.plugin.PageForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：
 *
 * @author zhangmengkang
 * @date 2018/5/28 10:28
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询导航展示项
     */
    @Override
    public List<Menu> findAllMenu() {
        List<Menu> menu = menuMapper.findAllMenus();
        return menu;

    }

    @Override
    public List<Menu> findUserMenu(String id) {
        List<Menu> menu = menuMapper.findUserMenu(id);
        return menu;
    }


    //查询菜单树数据列表
    @Override
    public List<Menu> queryMenuList() {
        List<Menu> list = menuMapper.getTreeList();
        return list;
    }

    @Override
    public PageForm<Menu> getPageList(PageForm<Menu> page, String menuName, String id) {

        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criteria = menuExample.createCriteria();
        if (menuName != "" && menuName != null) {
            criteria.andMenuNameLike("%"+menuName+"%");
        }
        if (id != "" && id != null) {
            criteria.andMenuParentIdEqualTo(Long.parseLong(id));
        }
        //查询所有菜单数量
        Integer menuCount = menuMapper.countByExample(menuExample);
        //分页查询所有菜单数据
        menuExample.setLimitStart((page.getPage() - 1) * page.getLimit());
        menuExample.setLimitEnd(page.getLimit());
        List<Menu> menus = menuMapper.selectByExample(menuExample);
        page.setCount(menuCount);
        page.setData(menus);
        return page;
    }

    @Override
    public void add(Menu menu) {
        menuMapper.insertSelective(menu);
    }

    @Override
    public Menu findMenuByName(String menuName) {
        if (menuName == null || menuName == "") {
            return null;
        }
        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criteria = menuExample.createCriteria();
        List<Menu> menus = menuMapper.selectByExample(menuExample);
        if (menus == null || menus.size() < 1) {
            return null;
        } else {
            return menus.get(0);
        }
    }

    @Override
    public Menu findById(Long id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public void edit(Menu menu) {
        menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public String delete(String ids) {
    	try {
    		List<Menu> childrenMenu=menuMapper.findChildrenMenu(ids);//查询子菜单
    		if(childrenMenu!=null && childrenMenu.size()==0) {
    			menuMapper.delete(ids);
    			menuMapper.deletRoleMenu(ids);
                return "200";
    		}else {
    			return "300";
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
			return "400";
		}
        
    }

    @Override
    public int countTreeData() {
        return menuMapper.countTreeData();
    }

}
