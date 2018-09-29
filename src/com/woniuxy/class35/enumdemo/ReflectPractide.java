package com.woniuxy.class35.enumdemo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ReflectPractide {
	public <T> T encapsulation(Map<String, Object> map, Class<T> cl)
			throws InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		// ����Ŀ����ʵ��
		T po = cl.newInstance();

		// ��ȡĿ������������
		Field[] fields = cl.getDeclaredFields();
		// ѭ������ÿ������
		for (Field field : fields) {
			String fieldName = field.getName();
			// ͨ����������MAP������Ӧ��ֵ
			Object obj = map.get(fieldName);
			if (obj == null) {
				continue;
			}
			// Ϊ���Ը�ֵ
			// ��һ�֣��������Խ��и�ֵ
			// ͻ�Ʒ���Ȩ��
			// if(!field.isAccessible()){
			// field.setAccessible(true);
			// }
			// //��ֵ
			// field.set(po, obj);
			// �ڶ��֣�����set������ֵ
			// ƴ��Ŀ��set������
			String setMethodName = "set"
					+ fieldName.substring(0, 1).toUpperCase()
					+ fieldName.substring(1);
			Method setmethod = cl.getDeclaredMethod(setMethodName,
					field.getType());
			// ִ�з���
			setmethod.invoke(po, obj);
		}
		return po;
	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, NoSuchMethodException, SecurityException,
			IllegalArgumentException, InvocationTargetException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 22);
		map.put("name", "admin");
		UserPO po = new ReflectPractide().encapsulation(map, UserPO.class);
		System.out.println(po);
	}
}
