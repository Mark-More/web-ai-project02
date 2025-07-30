package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.jdom2.output.Format.compact;

public class JwtTest {

    /**
     * 测试生成JWT令牌
     */
    @Test
    public void testGenerateJwt(){
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id",1);
        dataMap.put("username","admin");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"aXRoZWltYQ==")//指定加密算法，秘钥
                .addClaims(dataMap)//添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置令牌过期时间为一小时
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJWT(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc1Mzg4Nzk3Nn0.P1AWqfuPl9b3UEH4X1A_pzDqcNZSZDnzIPoebug5WJg";
         Claims claims = Jwts.parser()
                .setSigningKey("aXRoZWltYQ==")//指定秘钥
                .parseClaimsJws(token)//解析JWT
                .getBody();//获取自定义信息
        System.out.println( claims);
    }
}
