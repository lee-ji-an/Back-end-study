package ex01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	// 해당 클래스를 스프링 설정 클래스로 지정 Ctrl+Shift+O 
public class AppContext {  

	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();	//스프링이 생성하는 빈 객체 
		g.setFormat("%s, 안녕하세요.");
		return g;
	}
}
