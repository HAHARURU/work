package com.jz.xd.interceptors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Alexander on 15/12/14.
 * Modify by atlas on 16/6/20
 */
@Component
@Aspect
public class AspectControllerTools {
    private static Logger logger = LogManager.getLogger(AspectControllerTools.class);

    private static final Long OUTTIME_CONTROLLER = 500L;

    @Around("execution (* com.jz.xd.controller.*.*(..))")
    public Object around_jz_controller_rest(ProceedingJoinPoint point) throws Throwable {
        /* 统计查询时间超过500毫秒 */
        try {
            Long start = System.currentTimeMillis();
            Object[] args = point.getArgs();
            Object o = point.proceed();
            Long end = System.currentTimeMillis();
            if(end-start > OUTTIME_CONTROLLER){
                StringBuilder sb = new StringBuilder("++++++++++ ***** controller ***** ++++++++++");
                sb.append(point.getSignature()+" has cost:" + (end-start) + "ms");
                sb.append(" controller method args:");
                for(Object object : args) {
                    sb.append(object).append(" ");
                }
                logger.debug(sb.toString());
            }
            return o;
        } catch (Throwable e) {
            throw e;
        }
    }

}
