package com.makercheckerapp.model.service.aspect;

import com.makercheckerapp.model.service.CustomerServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

    @Around("@annotation(CustomAnnotation)")
    public Object loggingAround(ProceedingJoinPoint point) throws Throwable{
        long start = System.currentTimeMillis();
        Object object = point.proceed();
        long end = System.currentTimeMillis();
        logger.info("time take to call " + point.getSignature().getName() + " is " + (end-start) + " ms!");
        return object;
    }
}
