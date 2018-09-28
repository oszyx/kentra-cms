package com.kentrasoft.cms.service;

import com.kentrasoft.cms.entity.RoleMenu;

import java.util.List;

public interface RoleMenuService {
    
	List<String> findByID(Long id);
	
	void add(RoleMenu roleMenu);
	
	void dele(RoleMenu roleMenu);
	
}
