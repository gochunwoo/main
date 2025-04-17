package pack.controller;

import java.util.Scanner;

import pack.model.MoneyInter;

public class MyProcess implements MyInter {
	private MoneyInter moneyInter;
	private int re[];
	
	public MyProcess(MoneyInter moneyInter) {
		this.moneyInter = moneyInter;
	}
	@Override
	public void inputMoney() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("금액입력");
			int mymoney = scanner.nextInt();
			re = moneyInter.calcMoney(mymoney);
			
			
		} catch (Exception e) {
			System.out.println("inputMoney err : " + e);
		}
		
	}@Override
	public void showMoney() {
		StringBuffer sb = new StringBuffer();
		sb.append("만원 :" + re[0] + "\n");
		sb.append("천원 :" + re[1] + "\n");
		sb.append("백원 :" + re[2] + "\n");
		sb.append("십원 :" + re[3] + "\n");
		sb.append("일원 :" + re[4] + "\n");
		System.out.println(sb.toString());
	}
}
