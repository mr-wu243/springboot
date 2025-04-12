package com.wuzengrui.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuzengrui.pojo.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.crypto.SecretKey;
import java.util.Base64;


@Slf4j
@Component
@Data
@ConfigurationProperties(prefix = "jwt")
public class LoginCheckInterceptor implements HandlerInterceptor {
    private String secret;

    @Override//目标资源方法运行前运行，返回true：放行，反之
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwt = request.getHeader("token");
        if (!StringUtils.hasLength(jwt)) {
            log.info("令牌不存在，返回登录页面");
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(Result.error("NOT_LOGIN")));
            return false;
        }
        try {
            byte[] base64Key = Base64.getDecoder().decode(secret);
            SecretKey key = Keys.hmacShaKeyFor(base64Key);
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt).getBody();
        } catch (Exception e) {
            log.info("令牌验证失败，返回登录页");
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(Result.error("NOT_LOGIN")));
            return false;
        }
        log.info("令牌验证成功");
        return true;
    }

    @Override//目标资源运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
