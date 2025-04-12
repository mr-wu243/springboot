package com.wuzengrui.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuzengrui.pojo.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Base64;

@Slf4j
//@WebFilter("/*")
//@Component
@Data
@ConfigurationProperties(prefix = "jwt")
public class LoginCheckFilter implements Filter {
    private String secret;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取请求的url,如果url中包含login关键字则放行
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURL().toString();
        log.info("url:{}", url);
        if (url.substring(url.lastIndexOf("/") + 1).equals("login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //获取请求头中的token
        String jwt = request.getHeader("token");
        if (!StringUtils.hasLength(jwt)) {
            log.info("令牌不存在，返回登录界面");
            Result err = Result.error("NOT_LOGIN");
            //手动将数据转化为Json格式
            ObjectMapper objectMapper = new ObjectMapper();
            String notLogin = objectMapper.writeValueAsString(err);
            //将数据返回给浏览器
            response.getWriter().write(notLogin);
            return;
        }

        try {
            byte[] base64Key= Base64.getDecoder().decode(secret);
            SecretKey key= Keys.hmacShaKeyFor(base64Key);
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录的信息");
            Result err = Result.error("NOT_LOGIN");
            //手动将数据转化为Json格式
            ObjectMapper objectMapper = new ObjectMapper();
            String notLogin = objectMapper.writeValueAsString(err);
            //将数据返回给浏览器
            response.getWriter().write(notLogin);
            return;
        }
        log.info("令牌解析成功，访问页面");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
