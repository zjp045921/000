package com.woniuxy.class35.enumdemo;

public enum WeekDemo {
	MON("����һ"),TUE("����һ"),WED("����һ"),THU("����һ"),FRI("����һ"),STA("����һ"),SUN("����һ");
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
