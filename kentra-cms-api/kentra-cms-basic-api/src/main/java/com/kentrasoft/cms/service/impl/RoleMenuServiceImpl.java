package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.dao.RoleMenuMapper;
import com.kentrasoft.cms.entity.RoleMenu;
import com.kentrasoft.cms.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenuServiceImpl implements RoleMenuService{
	
	@Autowired
	private RoleMenuMapper roleMenuMapper;

	@Override
	public List<String> findByID(Long id) {
		return roleMenuMapper.findByRoleID(id);
	}

	@Override
	public void add(RoleMenu roleMenu) {
		roleMenuMapper.addRoleMenu(roleMenu);
	}

	@Override
	public void dele(RoleMenu roleMenu) {
		roleMenuMapper.deleRoleMenu(roleMenu);
		
	}

}
