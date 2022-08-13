package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import ex05.Calculator;

public class MainAspect {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Calculator c = ctx.getBean("calculator", Calculator.class);
		long result = c.factorial(10);
		System.out.println("10 factorial = " + result);
		System.out.println(c.getClass().getName());
		
		ctx.close();
	}
}
