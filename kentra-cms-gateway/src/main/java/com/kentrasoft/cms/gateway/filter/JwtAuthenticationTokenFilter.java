package com.kentrasoft.cms.gateway.filter;


import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.common.util.JwtUtil;
import com.kentrasoft.cms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Token过滤器
 *
 * @author hackyo
 * Created on 2018/09/05 9:28.
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String token = "";
        for (Cookie cookie : cookies) {
            if ("KentrasoftToken".equals(cookie.getName())) {
                token = cookie.getValue();
            }
        }
        //判断token是否为空
        if (!StringUtils.isEmpty(token)) {
            //验证token是否过期
            if (!JwtUtil.isTokenExpired(token, "123456")) {
                //判断redis中是否存在此token
                if (redisUtil.exists(token)) {
                    //获取token中的用户名
                    String username = JwtUtil.getUsernameFromToken(token, "123456");
                    User user = (User) redisUtil.get(token);
                    if (username != null && username.equals(user.getUsername()) && token.equals(user.getExt1())) {
                        if (SecurityContextHolder.getContext().getAuthentication() == null) {
                            //验证token
                            UserDetails userDetails = this.userDetailsService.loadUserByUsername(token);
                            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext().setAuthentication(authentication);
                        }
                    }
                }
            }
        }
        chain.doFilter(request, response);
//        String authHeader = request.getHeader("Authorization");
//        String tokenHead = "Bearer ";
//        if (authHeader != null && authHeader.startsWith(tokenHead)) {
//            String authToken = authHeader.substring(tokenHead.length());
//            String username = jwtTokenUtil.getUsernameFromToken(authToken);
//            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
//                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            }
//        }
//        chain.doFilter(request, response);
    }
}
