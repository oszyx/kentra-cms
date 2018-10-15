package com.kentrasoft.cms.basic.webListener;

import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.dao.MenuDao;
import com.kentrasoft.cms.dao.RoleDao;
import com.kentrasoft.cms.model.Menu;
import com.kentrasoft.cms.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 项目启动完成加载数据
 *
 * @author 赵参谋
 */
@Component
public class WebListenerLoad implements CommandLineRunner {

    private Logger log = LoggerFactory.getLogger(WebListenerLoad.class);

    @Autowired
    private MenuDao menuDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void run(String... args) throws Exception {
        log.info("-----------将role和menu 加载进redis中 --开始----------------");
        List<Menu> allMenu = menuDao.findAll();
        List<Role> allRole = roleDao.findAll();
        redisUtil.set("allMenu", allMenu);
        redisUtil.set("allRole", allRole);
        log.info("-----------将role和menu 加载进redis中 --结束----------------");
    }


}
