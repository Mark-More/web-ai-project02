package com.itheima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * JWT 工具类
 */
public class JwtUtils {

    // 秘钥（与测试类保持一致）
    private static final String SECRET = "aXRoZWltYQ==";

    // 过期时间：12小时（单位：毫秒）
    private static final long EXPIRATION = 12 * 60 * 60 * 1000; // 43200000 ms

    /**
     * 生成 JWT 令牌
     *
     * @param claims 要存入令牌的自定义信息（如用户ID、用户名等）
     * @return 生成的 JWT 字符串
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .compact();
    }

    /**
     * 解析 JWT 令牌
     *
     * @param token JWT 令牌字符串
     * @return Claims 对象，包含令牌中的信息
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}