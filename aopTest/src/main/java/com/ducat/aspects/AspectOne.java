package com.ducat.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectOne {

	// pointcut to represent a() method of ABC
	@Pointcut("execution(* com.ducat.beans.ABC.a(..))")
	public void pc1() {}
	
	// pointcut to represent b() method of ABC
	@Pointcut("execution(* com.ducat.beans.ABC.b(..))")
	public void pc2() {}
	
	// pointcut to represent c() method of ABC
	@Pointcut("execution(* com.ducat.beans.ABC.c(..))")
	public void pc3() {}
	
	// Before advice
	@Before("pc1() || pc3()")
	public void preProcessing(JoinPoint jp) {
		String method = jp.getSignature().getName()+"()";
		System.out.println("Before Advice is applied on "+method);
	}
	
	// Throws advice
	@AfterThrowing(pointcut="pc3()",throwing="ex")
	public void errorHandler(JoinPoint jp, Exception ex) {
	String method = jp.getSignature().getName()+"()";
	System.out.print("Throws Advice is applied on "+method);
	System.out.println(" because of "+ex);
	}
	// After advice
	/*@AfterReturning(pointcut="pc2()",returning="rs")
	public void postProcessing(JoinPoint jp,String rs) {
		String method = jp.getSignature().getName()+"()";
		System.out.println("After Advice is applied on "+method);
		System.out.println(rs+" is returned by "+method);
		rs = "failure";
		System.out.println("Return value is changed to failure by the advice.");
	}*/
	
	@Around("pc2()")
	public Object aroundProcessing(ProceedingJoinPoint pjp) {
		// pre processing if any
		Object rs = null;
		String method = pjp.getSignature().getName()+"()";
		System.out.println("Around Advice is applied on "+method);
		try
		{
		// Invoke the target method with the help of proceeding joinpoint object
		/*rs = pjp.proceed();
		// post processing if any
		System.out.println(rs+" is returned by "+method);
		rs = "failure";
		System.out.println("Return value is changed to failure by the advice.");
		*/
		} catch (Throwable e)
		{
			System.out.println(e);
		}
		return rs;
	}
	
	
}
