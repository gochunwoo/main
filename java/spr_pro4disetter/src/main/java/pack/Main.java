package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		MyBusiness myBusiness = (MyBusiness)context.getBean("myBusiness");
		myBusiness.displayData();
	}

}
