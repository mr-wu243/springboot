package com.wuzengrui.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.wuzengrui.pojo.Result;
import com.wuzengrui.service.EmpService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@Data
@RequestMapping("/login")
@Slf4j
@ConfigurationProperties(prefix = "jwt")
public class LoginController {

    @Autowired
    private EmpService empService;
    private String secret;


    @PostMapping
    public Result login(@RequestBody JsonNode node) {
        String username = node.get("username").asText();
        String password = node.get("password").asText();
        log.info("输入的用户名是：{},输入的密码是：{}",username,password);
        if(empService.login(username,password) != 0) {

//            SecretKey key= Keys.secretKeyFor(SignatureAlgorithm.HS256);
//            byte[] keyBytes = key.getEncoded();
//            String base64Key = Base64.getEncoder().encodeToString(keyBytes);
//            log.info("秘钥为：{}",base64Key);
            byte[] keyBytes=Base64.getDecoder().decode(secret);
            SecretKey key = Keys.hmacShaKeyFor(keyBytes);
            Map<String,Object> map = new HashMap<>();
            map.put("username",username);

            String jwt= Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256,key)
                    .setClaims(map)
                    .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                    .compact();
            return Result.success(jwt);
        }
        else return Result.error("NOT_LOGIN");
    }
}
