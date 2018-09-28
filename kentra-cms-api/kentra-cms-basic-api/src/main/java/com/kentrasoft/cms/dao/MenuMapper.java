package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.entity.Menu;
import com.kentrasoft.cms.entity.MenuExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "menuMapper")
public interface MenuMapper {
	
	public List<Menu> findAllMenus();
	
	public List<Menu> findUserMenu(String id);
	
	int countByExample(MenuExample example);
	
	int deleteByExample(MenuExample example);

    /**
     *
     * @mbg.generated 2018-05-25
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-05-25
     */
    int insert(Menu record);

    /**
     *
     * @mbg.generated 2018-05-25
     */
    int insertSelective(Menu record);
    
    /**
     *
     * @mbg.generated 2018-05-25
     */
    List<Menu> selectByExample(MenuExample example);

    /**
     *
     * @mbg.generated 2018-05-25
     */
    Menu selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2018-05-25
     */
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     *
     * @mbg.generated 2018-05-25
     */
    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     *
     * @mbg.generated 2018-05-25
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     *
     * @mbg.generated 2018-05-25
     */
    int updateByPrimaryKey(Menu record);

    /**
     * 查询菜单树数据
     * @return
     */
    List<Menu> getTreeList();

    /**
     * 获取子菜单数据
     */
    List<Menu> getChildTreeList();

    /**
     * 删除菜单
      * @param ids
     * @return
     */
    void delete(String ids);
    
    void deletRoleMenu(String dis);
    /**
     * 查询菜单下子菜单
     *author:赵参谋
     * @param ids
     * @return
     */
    List<Menu> findChildrenMenu(String ids);

    /**
     * 查询菜单树数据总数
     */
    int countTreeData();
    
    /**
     * 根据机构code查询
     */
    List<Menu> querybyMenuCode(@Param("menuCode") String menuCode, @Param("menuId") String menuId);
}
