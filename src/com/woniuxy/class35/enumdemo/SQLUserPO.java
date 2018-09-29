package com.woniuxy.class35.enumdemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class SQLUserPO {
	
private static final Object po = null;
	//	public static void main() {
//		//��ȡ����
//		Class<UserPO> cl = UserPO.class;
//		int sno = 1;
//		String sname = "����";
//		
//		int sage = 12;
//		System.out.println();
//	}
	/*
	 * ���SQL��ѯ����ƴ��
	 * @param po Ŀ�����
	 * @param cl Ŀ��������classʵ��
	 * @return SQL���ƴ�ӽ��
	 */
	public static String sqlUserPO(Object obj,Class<?> cl) throws IllegalArgumentException, IllegalAccessException{
		StringBuilder sb = new StringBuilder();
		if(cl.isAnnotationPresent(Table.class)){
			//��ȡtableע��
			Table tb = (Table)cl.getAnnotation(Table.class);
			//��ȡ����
			String tablename = tb .value();
			//ƴ��SQL����Ϣ����
			sb.append("SELETE*FROM`"+tablename+"`");
			//��ѯ����ƴ��
			/*
			 * 1.ʲôʱ����where��ʲôʱ����and
			 * 2.����--��Ŀ�����ĸ����Ե�ֵ
			 * 3.ֵ--��Ŀ�����ĸ����Ե�ֵ
			 * 4.����ȷ�������Ƿ񱻸�ֵ
			 *    �������͵�Ĭ��ֵ
			 *       ������������  null
			 *       ������������
			 *         �������� 0  0.0  == 0
			 */
			//��ȡ��������
			Field[] fields = cl.getDeclaredFields();
			boolean state = false;
			//ѭ��������������
			for(Field field : fields){
				//�жϸ������Ƿ����columnע��
				if(field.isAnnotationPresent(Column.class)){
					continue;
					//ȡ���������Ӧ��ֵ
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
//							//��ȡcolumnע��
//							Column co = (Column)field.getAnnotation(Column.class);
//							//��ȡ����
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
								
								//��ȡcolumnע��
								Column co = (Column)field.getAnnotation(Column.class);
								//��ȡ����
								String colname = co.value();
								if(!field.isAccessible()){
									field.setAccessible(true);
							}
								//��ȡ�����Ե�ֵ
								Object obj1 = field.get(po);
								//��������   Ĭ��ֵ
								if(obj == null){
									continue;
								}else if(obj instanceof Number){
									Number num = (Number)obj;
									if(num.doubleValue() != 0){
										//����Ĭ��ֵ ��������ֵ
										if(state){
											sb.append(" WHERE ");
									}else{
										sb.append(" AND ");
										}
										sb.append("`"+colname+"`="+num);
								}
						}else if(obj instanceof String){
							String str = (String)obj;
							//����ֵ���ַ�������
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
