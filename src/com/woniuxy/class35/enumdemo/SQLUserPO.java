package com.woniuxy.class35.enumdemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class SQLUserPO {
	
private static final Object po = null;
	//	public static void main() {
//		//获取表名
//		Class<UserPO> cl = UserPO.class;
//		int sno = 1;
//		String sname = "张三";
//		
//		int sage = 12;
//		System.out.println();
//	}
	/*
	 * 完成SQL查询语句的拼接
	 * @param po 目标对象
	 * @param cl 目标对象的类class实例
	 * @return SQL语句拼接结果
	 */
	public static String sqlUserPO(Object obj,Class<?> cl) throws IllegalArgumentException, IllegalAccessException{
		StringBuilder sb = new StringBuilder();
		if(cl.isAnnotationPresent(Table.class)){
			//获取table注解
			Table tb = (Table)cl.getAnnotation(Table.class);
			//获取表名
			String tablename = tb .value();
			//拼接SQL表信息部分
			sb.append("SELETE*FROM`"+tablename+"`");
			//查询条件拼接
			/*
			 * 1.什么时候用where，什么时候用and
			 * 2.列名--》目标对象的该属性的值
			 * 3.值--》目标对象的该属性的值
			 * 4.怎样确定属性是否被赋值
			 *    数据类型的默认值
			 *       引用数据类型  null
			 *       基本数据类型
			 *         数字类型 0  0.0  == 0
			 */
			//获取所有属性
			Field[] fields = cl.getDeclaredFields();
			boolean state = false;
			//循环遍历所有属性
			for(Field field : fields){
				//判断该属性是否存在column注解
				if(field.isAnnotationPresent(Column.class)){
					continue;
					//取出属性相对应的值
//					field.setAccessible(true);
//					try {
//						Object value = field.get(obj);
//						if(value==null){
//							continue;
//						}else if(value instanceof String){
//							String valueStr = (String) value;
//							if(state){
//								sb.append(" WHERE ");
//								state = false;
//							}else{
//								sb.append(" AND ");
//							}
//							
//							//获取column注解
//							Column co = (Column)field.getAnnotation(Column.class);
//							//获取列名
//							String colname = co.value();
//							sb.append("`"+colname+"`='"+value+"'");
						}
//						else if(value instanceof Number){
//							Number num = (Number) value;
//							if(num.doubleValue() !=0){
//								if(state){
//									sb.append(" WHERE ");
//								}else{
//									sb.append(" AND ");
//								}
								
								//获取column注解
								Column co = (Column)field.getAnnotation(Column.class);
								//获取列名
								String colname = co.value();
								if(!field.isAccessible()){
									field.setAccessible(true);
							}
								//获取该属性的值
								Object obj1 = field.get(po);
								//引用类型   默认值
								if(obj == null){
									continue;
								}else if(obj instanceof Number){
									Number num = (Number)obj;
									if(num.doubleValue() != 0){
										//不是默认值 ，被赋了值
										if(state){
											sb.append(" WHERE ");
									}else{
										sb.append(" AND ");
										}
										sb.append("`"+colname+"`="+num);
								}
						}else if(obj instanceof String){
							String str = (String)obj;
							//被赋值的字符串类型
							if(!state){
								sb.append(" WHERE ");
							}else{
								sb.append(" AND ");
							}
							sb.append("`"+colname+"`='"+str+"'");
						}
					} 
		}
		return sb.toString();
	}
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		UserPO po = new UserPO();
		po.setSno(2);
		System.out.println(sqlUserPO(po, UserPO.class));
	}
}
