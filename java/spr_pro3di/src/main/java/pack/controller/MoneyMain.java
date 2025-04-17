package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MoneyMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		
		MyInter myInter = (MyInter)context.getBean("myProcess");
		myInter.inputMoney();
		myInter.showMoney();
	}
}
