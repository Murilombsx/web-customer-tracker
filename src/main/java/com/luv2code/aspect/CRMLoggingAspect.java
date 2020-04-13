package com.luv2code.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	private static Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());
	
	@Before("com.luv2code.aspect.AopExpressions.pointcutForAppFlow()")
	public void before(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("======> in @Before: calling method: " + method);
		
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			logger.info("======> argument: " + arg);
		}
	}
	
	@AfterReturning(
			pointcut = "com.luv2code.aspect.AopExpressions.pointcutForAppFlow()",
			returning = "result"
			)
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("======> in @AfterReturning: calling method: " + method);
		
		logger.info("======> result: " + result);
	}
	
}
