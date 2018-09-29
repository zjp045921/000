package com.woniuxy.class35.enumdemo;

import java.util.Random;

public class HomeWork {
	public static void main(String[] args){
		int[] nums = new int[1000000];
		//存数据
		for(int i=0;i<nums.length;i++){
			nums[i] = i+1;
		}
		//出导
		int len = nums.length;
		Random ran = new Random();
		while(len>0){
			int index = ran.nextInt(len);
			System.out.println(nums[index]);
			nums[index] = nums[len-1];
			len--;
		}
		System.out.println();
		
	}

}
