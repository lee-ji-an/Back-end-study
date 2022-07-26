package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.AppCtx;
import ex04.Client;
import ex04.Client2;

public class MainClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		Client2 c = ctx.getBean(Client2.class);
		
		Client2 c1 = ctx.getBean(Client2.class);
		Client2 c2 = ctx.getBean(Client2.class);

		System.out.println("c1 == c2 ==> " + (c1 == c2));
		c.send();
		
		ctx.close();
	}

}
