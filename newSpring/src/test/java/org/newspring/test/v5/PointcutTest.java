package org.newspring.test.v5;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.aop.MethodMatcher;
import org.litespring.aop.aspectj.AspectJExpressionPointcut;
import org.newspring.service.v5.PetStoreService;


import java.lang.reflect.Method;


public class PointcutTest {
	@Test
	public void testPointcut() throws Exception {
		
		String expression = "execution(* org.newspring.service.v5.*.placeOrder(..))";
		
		AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
		pc.setExpression(expression);
		
		MethodMatcher mm = pc.getMethodMatcher();
		
		{
			Class<?> targetClass = PetStoreService.class;
			
			Method method1 = targetClass.getMethod("placeOrder");
			Assert.assertTrue(mm.matches(method1));
			
			Method method2 = targetClass.getMethod("getAccountDao");
			Assert.assertFalse(mm.matches(method2));
		}
		
		{
			Class<?> targetClass = org.newspring.service.v4.PetStoreService.class;
		
			Method method = targetClass.getMethod("getAccountDao");
			Assert.assertFalse(mm.matches(method));
		}
		
	}
}
