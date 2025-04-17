package pack.controller;

import pack.model.DataDao;
// 비지니스 로직 담당
public class SelectServiceImpl implements SelectService {
	private DataDao dataDao; // 모델이 가진 DB 처리용
	
	public SelectServiceImpl(DataDao dataDao) {	// 생성자 주입(Constructor injection)
		System.out.println("selectServiceImpl 생성자");
		// 생성자를 이용해 dataDao에게 주소치환
		this.dataDao = dataDao;	// 생성자 주입을 받음!! 스프링이 init.xml에서 넣어준거임
	}
	
	@Override
	public void selectProcess() {
		System.out.println("컨트롤러 영역의 selectProcess() 실행");
		dataDao.selectData(); // dao 호출
	}
}
