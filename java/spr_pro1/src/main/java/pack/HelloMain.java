package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// 스프링 사용전 기존방법사용
		Message1 message1 = new Message1();
		message1.sayHello("홍길동");
		System.out.println();
		MessageInter inter = message1;
		inter.sayHello("메로나");
		System.out.println();
		
		// Spring Framework 사용 
		ApplicationContext context= new ClassPathXmlApplicationContext("init.xml");
		// init.xml 을 불러오기위해 ApplicationContext 사용
		MessageInter messageInter = (MessageInter)context.getBean("msg");
		messageInter.sayHello("스프링");
	}

}
