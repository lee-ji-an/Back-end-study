package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import ex05.Calculator;
import ex05.RecCalculator;

public class MainAspect {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Calculator c = ctx.getBean("calculator", RecCalculator.class);
		System.out.println(c.factorial(10));
		System.out.println(c.factorial(10));
		System.out.println(c.factorial(7));
		System.out.println(c.factorial(7));
		System.out.println(c.factorial(5));
		
		ctx.close();
	}
}
