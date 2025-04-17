package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pack.model.DataDao;
import pack.model.DataDaoImpl;
// 컨트롤러역할
public interface Main {
	public static void main(String[] args) {
		// 스프링사용안한방식
		//DB 처리용
		DataDaoImpl daoImpl = new DataDaoImpl();
		DataDao dataDao = daoImpl;
		//비지니스 로직용
		SelectServiceImpl serviceImpl = new SelectServiceImpl(dataDao);
		SelectService service = serviceImpl;
		service.selectProcess();
		
		System.out.println("\n스프링사용");
		// init.xml 읽어서 -> DataDaoImpl 과 SelectServiceImpl 자동으로 생성
		// SelectServiceImpl 내부에 dataDao가 자동으로 들어가 있음
		// selectProcess() 호출하면 → 내부에서 dataDao.selectData() 실행됨
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		SelectService selectService = (SelectService)context.getBean("serviceImpl");
		selectService.selectProcess();
	}
}
