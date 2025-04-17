package pack.controller;

import pack.model.GuguInter;

public class MyProcess implements MyBusinessInter {
	private String programmerName;
	private GuguInter guguInter;
	private int dan;
	
	public MyProcess() {
		
	}
	public void setProgrammerName(String programmerName) {
		this.programmerName = programmerName;
	}
	
	public void setGuguInter(GuguInter guguInter) {
		this.guguInter =guguInter;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}
	
	@Override
	public String showData() {
		int re[] = guguInter.numberCalc(dan);
		String str = "";
		for(int i = 0; i < re.length; i++) {
			str += dan + " * " + (i + 1) + " = " + re[i] + "\n";
		}
		
		return "작성자 : " + programmerName + "\n" + dan + " 단결과 : \n" + str;
	}

}
