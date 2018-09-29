package com.woniuxy.class35.enumdemo;

public enum Computer {
	DELL("����"),LENOVO("����"),APPLE("ƻ��");
	
	private String name;
	private Computer(String name){
		this.name = name;
	}
	public static void main(String[] args) {
		Computer[] com = Computer.values();
		for (Computer computer : com) {
			System.out.println(computer.name);
		}
		
	}
}
