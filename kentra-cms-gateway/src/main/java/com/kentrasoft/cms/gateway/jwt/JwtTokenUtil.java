package com.kentrasoft.cms.gateway.jwt;

import com.kentrasoft.cms.common.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt工具类
 */
@Component
public class JwtTokenUtil implements Serializable {
    /**
     * 生成令牌
     * @param userDetails 用户
     * @return 令牌
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", userDetails.getUsername());
        claims.put("created", new Date());
        return JwtUtil.generateToken(claims,"123456",2592000L * 1000);
    }


    /**
     * 验证令牌
     * @param token       令牌
     * @param userDetails 用户
     * @return 是否有效
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        JwtUser user = (JwtUser) userDetails;
        String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername()) && !JwtUtil.isTokenExpired(token,"123456"));
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public static String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = JwtUtil.getClaimsFromToken(token,"123456");
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
}
