package com.kentrasoft.cms.controller.menu;

import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.dao.MenuMapper;
import com.kentrasoft.utils.plugin.BaseResult;
import com.kentrasoft.utils.plugin.PageForm;
import com.kentrasoft.cms.entity.Menu;
import com.kentrasoft.cms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * 描述：菜单管理Controller
 *
 * @author zhangmengkang
 * @date 2018/5/25 17:32
 */
@RequestMapping(value = "/menu")
@Controller
@SuppressWarnings("unchecked")
public class MenuController {

    @Autowired
    private MenuService menuService;
    
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
	private RedisUtil redisUtil;

    @RequestMapping(value = "/getTreeList")
    @ResponseBody
    public List<Menu> getTreeList(){
    	List<Menu> menuList = menuService.queryMenuList();
        for(Menu menu:menuList) {
        	menu.setMenuUrl("javascript:zTreeOnClick("+menu.getId()+")");//显示节点下信息
        }
        return menuList;
    }
    
    /**
     * 分页查询
     * @param page
     * @return
     */
    @RequestMapping(value = "/getPageList")
    @ResponseBody
    public PageForm<Menu> getPageList(PageForm<Menu> page , String menuName, String id){
    	PageForm<Menu> pageList = menuService.getPageList(page,menuName,id);
        return pageList;
    }

    /**
     * 描述：新增菜单
     * @param menu
     */
	@RequestMapping(value = "/goAdd")
    @ResponseBody
    public BaseResult<Menu> add(Menu menu) {
		try {
			//查询menucode是否存在
			List<Menu> menulist=menuMapper.querybyMenuCode(menu.getMenuCode(),"");
			if(menulist!=null && menulist.size()>0) {
				return BaseResult.faild("菜单编号已存在");
			}
	    	if("".equals(menu.getMenuParentId()) || null==menu.getMenuParentId()) {
	    		menu.setMenuParentId(Long.parseLong("1"));
	    	}
            redisUtil.set(menu.getMenuCode(), menu.getMenuName());
	        menuService.add(menu);
	        return BaseResult.success("新增成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return BaseResult.faild("新增失败！");
		}
		
    }

    /**
     * 根据菜单名查询菜单
     *
     * @param menuName
     * @return
     */
    @RequestMapping(value = "/findMenuByName")
    @ResponseBody
    public Menu findMenuByName(String menuName) {
        Menu menu = menuService.findMenuByName(menuName);
        return menu;
    }

    /**
     * 根据菜单Id查询菜单
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById")
    @ResponseBody
    public Menu findById(Long id) {
        Menu menu = menuService.findById(id);
        return menu;
    }

    /**
     * 描述：修改菜单信息
     *
     * @param menu
     */
    @RequestMapping(value="/goEdit")
    @ResponseBody
    public BaseResult<Menu> edit(Menu menu) {
    	try {
    		//查询menucode是否存在
        	List<Menu> menulist=menuMapper.querybyMenuCode(menu.getMenuCode(),menu.getId().toString());
        	if(menulist!=null && menulist.size()>0) {
        		return BaseResult.faild("菜单编号已存在");
        	}
        	//删除redis数据
        	Menu menu_index=menuMapper.selectByPrimaryKey(menu.getId());
            redisUtil.remove(menu_index.getMenuCode());
        	//新增redis数据
            redisUtil.set(menu.getMenuCode(), menu.getMenuName());
        	//删除数据
            menuService.edit(menu);
            return BaseResult.success("修改成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return BaseResult.faild("修改失败！");
		}
    	
    }

    /**
     * 描述：删除菜单
     *
     * @param ids
     */
    @RequestMapping(value="/delete")
    @ResponseBody
    public BaseResult<Menu> delete(String ids) {
    	try {
    		List<Menu> childrenMenu=menuMapper.findChildrenMenu(ids);//查询子菜单
    		if(childrenMenu!=null && childrenMenu.size()==0) {
    			//删除缓存
    			List<String> menuId=Arrays.asList(ids.split(","));
    			for(String id:menuId) {
    				Menu menu=menuMapper.selectByPrimaryKey(Long.parseLong(id));
                    redisUtil.remove(menu.getMenuCode());
    			}
    			menuMapper.delete(ids);
    			menuMapper.deletRoleMenu(ids);
    			return BaseResult.success("删除成功!");
    		}else {
    			return BaseResult.faild("请先删除子菜单！");
    		}
			
    		/*String status = menuService.delete(ids);
            if ("200".equals(status)) {
            	return BaseResult.success("删除成功!");
            }else if("300".equals(status)) {
            	return BaseResult.faild("请先删除子菜单！");
            }else {
            	return BaseResult.faild("删除失败！");
            }*/
		} catch (Exception e) {
			e.printStackTrace();
			return BaseResult.faild("删除失败！");
		}
        
        
    }

}
