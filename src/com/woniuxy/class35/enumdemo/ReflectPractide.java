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
		// 创建目标类实例
		T po = cl.newInstance();

		// 获取目标类所有属性
		Field[] fields = cl.getDeclaredFields();
		// 循环遍历每个属性
		for (Field field : fields) {
			String fieldName = field.getName();
			// 通过属性名在MAP中找相应的值
			Object obj = map.get(fieldName);
			if (obj == null) {
				continue;
			}
			// 为属性赋值
			// 第一种：操作属性进行赋值
			// 突破访问权限
			// if(!field.isAccessible()){
			// field.setAccessible(true);
			// }
			// //赋值
			// field.set(po, obj);
			// 第二种：调用set方法赋值
			// 拼接目标set方法名
			String setMethodName = "set"
					+ fieldName.substring(0, 1).toUpperCase()
					+ fieldName.substring(1);
			Method setmethod = cl.getDeclaredMethod(setMethodName,
					field.getType());
			// 执行方法
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
