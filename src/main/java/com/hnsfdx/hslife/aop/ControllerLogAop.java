package com.hnsfdx.hslife.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ControllerLogAop {
    //slf4j logger
    private static final Logger logger = LoggerFactory.getLogger(ControllerLogAop.class);
    //优化并发
    private static final ThreadLocal<Long> startTime = new ThreadLocal<>();
    @Pointcut("execution(* com.hnsfdx.hslife.controller.*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void doBeforeController(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        startTime.set(System.currentTimeMillis());
        logger.info("==========================Before========================");
        //获得请求的url
        logger.info("Request Url: {}", request.getRequestURI());
        //获得请求的方式（get/post）
        logger.info("Request Method: {}", request.getMethod());
        //获得请求的ip
        logger.info("Request IP: {}", request.getRemoteAddr());
        //获得请求的类与方法
        logger.info("Request Class_Method: {}",
                joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName());
        //获得请求的方法的参数
        logger.info("Request Method_Args: {}", joinPoint.getArgs());
        logger.info("==========================End==========================");
    }

    @AfterReturning(pointcut = "pointCut()", returning = "object")
    public void doAfterController(Object object) {
        logger.info("====================AfterReturning=====================");
        logger.info("Time Consuming: {}", System.currentTimeMillis() - startTime.get());
        logger.info("Response Data: {}", object.toString());
        startTime.remove();
        logger.info("==========================End==========================");
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "ex")
    public void doThrowingException(Exception ex) {
        logger.info("====================ThrowException=====================");
        logger.info("Exception Ocuured In Class: {}", ex.getClass());
        startTime.remove();
        logger.info("==========================End==========================");
    }
}
