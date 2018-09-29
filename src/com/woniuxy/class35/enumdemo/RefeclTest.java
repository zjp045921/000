package com.woniuxy.class35.enumdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class RefeclTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//通过反射调用无参构造创建对象
		//获取class实例
		Class<UserPO> cl = UserPO.class;
		//获取目标构造器
		Constructor<UserPO> con = cl.getConstructor();
		//利用构造器创建对象
		UserPO userpo = con.newInstance();
		
		
		//通过反射调用有参构造创建对象
		Class<UserPO>  cl1 = UserPO.class;
		Constructor<UserPO> con1 = cl1.getConstructor(int.class,String.class,String.class);
		UserPO userpo1 = con1.newInstance( );
		
		
		StringBuilder sb = new StringBuilder();
		Class<UserPO> cl2 = UserPO.class;
		sb.append(Modifier.toString(cl2.getModifiers()));
		
	}
}
