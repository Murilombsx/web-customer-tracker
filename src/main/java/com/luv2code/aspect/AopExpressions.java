package com.luv2code.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* com.luv2code.controller.*.*(..))")
	public void pointcutForControllerPackage() {}

	@Pointcut("execution(* com.luv2code.service.*.*(..))")
	public void pointcutForServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.dao.*.*(..))")
	public void pointcutForDaoPackage() {}
	
	@Pointcut("pointcutForControllerPackage() || pointcutForServicePackage() || pointcutForDaoPackage()")
	public void pointcutForAppFlow() {}
	
}
