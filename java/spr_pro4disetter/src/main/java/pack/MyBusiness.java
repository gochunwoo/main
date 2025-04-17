package pack;

public class MyBusiness {
	private int nai;	 // 맴버필드
	private String juso; // 맴버필드
	private StringDatas datas;	// 클래스의 포함관계
	
	public MyBusiness() {
		
	}
	
	public void setNai(int nai) {
		this.nai = nai;
		
	}
	
	public void setJuso(String juso) {
		this.juso = juso;
	}
	
	public void setDatas(StringDatas datas) {
		this.datas = datas;
	}
	
	public void displayData() {
		System.out.println("나이는 " + nai );
		System.out.println("주소는 " + juso );
		System.out.println("이름은 " + datas.processName() );
		System.out.println("취미는 " + datas.processHobby() );
	}
}
