package com.woniuxy.class35.enumdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class RefeclTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//ͨ����������޲ι��촴������
		//��ȡclassʵ��
		Class<UserPO> cl = UserPO.class;
		//��ȡĿ�깹����
		Constructor<UserPO> con = cl.getConstructor();
		//���ù�������������
		UserPO userpo = con.newInstance();
		
		
		//ͨ����������вι��촴������
		Class<UserPO>  cl1 = UserPO.class;
		Constructor<UserPO> con1 = cl1.getConstructor(int.class,String.class,String.class);
		UserPO userpo1 = con1.newInstance( );
		
		
		StringBuilder sb = new StringBuilder();
		Class<UserPO> cl2 = UserPO.class;
		sb.append(Modifier.toString(cl2.getModifiers()));
		
	}
}
