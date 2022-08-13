package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.AppCtx;
import ex04.Client2;

public class MainClient {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		Client2 c1 = ctx.getBean(Client2.class);
		Client2 c2 = ctx.getBean(Client2.class);
		System.out.println("cl == c2 ==>" + (c1 == c2));
		//		c.send();
//		프로토타입 범위를 갖는 빈은 완전한 라이프사이클을 따르지 않음
//      빈 객체의 소멸 처리를 코드에서 직접해야 함
		ctx.close();
	}

}
