package ex01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration	// �ش� Ŭ������ ������ ���� Ŭ������ ���� Ctrl+Shift+O 
public class AppContext {  

	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();	//�������� �����ϴ� �� ��ü 
		g.setFormat("%s, �ȳ��ϼ���.");
		return g;
	}
}
