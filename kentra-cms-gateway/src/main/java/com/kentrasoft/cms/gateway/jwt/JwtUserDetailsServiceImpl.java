package com.kentrasoft.cms.gateway.jwt;

import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户验证方法
 *
 * @author hackyo
 * Created on 2017/12/8 9:18.
 */
@Service("userDetailsService")
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private RedisUtil redisTemplate;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        User user = (User) redisTemplate.get(token);
        if (user == null) {
            return null;
        } else {
            List<String> roles = new ArrayList<String>();
            return new JwtUser(user.getUsername(), user.getPassword(), roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        }
    }
}
