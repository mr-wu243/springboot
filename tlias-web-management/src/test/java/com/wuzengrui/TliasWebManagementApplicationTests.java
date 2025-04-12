package com.wuzengrui;

import com.wuzengrui.pojo.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
        int j= Integer.parseInt(null);
    }

    @Test
    public void testUuid(){
        for (int i=0;i<1000;i++){
            String uuid=UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    @Test
    public void testJwt(){
        Map<String,Object> claims1=new HashMap<>();
        claims1.put("id",1);
        claims1.put("name","Tom");

        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,key)//设置签名算法
                .setClaims(claims1)//自定义内容
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置jwt的有效期
                .compact();
        System.out.println(jwt);
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        System.out.println(claims);
    }



}
