package com.kentrasoft.cms.basic.webListener;

import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.dao.DictMapper;
import com.kentrasoft.cms.dao.MenuMapper;
import com.kentrasoft.cms.dao.RoleMapper;
import com.kentrasoft.cms.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 项目启动完成加载数据
 * @author 赵参谋
 *
 */
@Component
public class WebListenerLoad implements CommandLineRunner {
	
	private Logger log=LoggerFactory.getLogger(WebListenerLoad.class);

	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
    private DictMapper dictMapper;
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public void run(String... args) throws Exception {
		log.info("-----------服务启动完毕，redis加载数据----------------");
		//数据字典
		DictExample dictExample=new DictExample();
        DictExample.Criteria crit = dictExample.createCriteria();
        List<Dict> dictList=dictMapper.selectByExample(dictExample);
        for(Dict dict:dictList) {
			redisUtil.set(dict.getDictCode(), dict.getDictName());
        }
        //菜单
        MenuExample menuExample=new MenuExample();
        MenuExample.Criteria menucrit=menuExample.createCriteria();
        List<Menu> menuList=menuMapper.selectByExample(menuExample);
		for(Menu menu:menuList) {
			redisUtil.set(menu.getMenuCode(), menu.getMenuName());
		}
		//角色
		RoleExample roleExample=new RoleExample();
		List<Role> roleList=roleMapper.selectByExample(roleExample);
		for(Role role:roleList) {
			redisUtil.set(role.getRoleCode(), role.getRoleName());
		}
		
		log.info("-------------redis数据加载完毕----------------");
	}

}
