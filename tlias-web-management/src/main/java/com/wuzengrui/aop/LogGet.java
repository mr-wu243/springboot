package com.wuzengrui.aop;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuzengrui.mapper.OperateLogMapper;
import com.wuzengrui.pojo.OperateLog;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Base64;

@Slf4j
@Aspect
@Component
@Data
@ConfigurationProperties(prefix = "jwt")
public class LogGet {

    @Autowired
    private HttpServletRequest request;

    private String secret;

    @Resource(name = "operateLogMapper")
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.wuzengrui.annotaion.MyLog)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        byte[] base64Key= Base64.getDecoder().decode(secret);
        SecretKey key= Keys.hmacShaKeyFor(base64Key);

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(request.getHeader("token"))
                .getBody();

        long begin = System.currentTimeMillis();

        OperateLog operateLog = new OperateLog();

        operateLog.setOperateUser((String) claims.get("username"));

        log.info("操作时间:{}", LocalDateTime.now());
        operateLog.setOperateTime(LocalDateTime.now());

        log.info("执行方法的全类名：{}", joinPoint.getTarget().getClass().getName());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());

        log.info("执行的方法名：{}", joinPoint.getSignature().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());

        log.info("方法运行的参数：{}", joinPoint.getArgs());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));

        Object result = joinPoint.proceed();
        log.info("运行的返回值为：{}", result);
        operateLog.setReturnValue(new ObjectMapper().writeValueAsString(result));

        long end = System.currentTimeMillis();
        log.info("方法的运行时间是：{}", end - begin);
        operateLog.setCostTime(end - begin);
        operateLogMapper.insert(operateLog);
        return result;
    }
}
