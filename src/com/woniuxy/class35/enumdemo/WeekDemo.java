package com.woniuxy.class35.enumdemo;

public enum WeekDemo {
	MON("星期一"),TUE("星期一"),WED("星期一"),THU("星期一"),FRI("星期一"),STA("星期一"),SUN("星期一");
	private String name;
	private WeekDemo(String name){
		this.name=name;
	}
	public static void main(String[] args) {
		WeekDemo week = WeekDemo.FRI;
		System.out.println(week);
		
			WeekDemo[] week1 = WeekDemo.values();
			for (WeekDemo weekDemo : week1) {
				System.out.println(weekDemo.name());
			}
		
	}
	
	
	
}
