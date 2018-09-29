package com.woniuxy.class35.jdbcdemo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBCDemo {
	private static String URL = "jdbc:mysql://localhost:3306/isnumber";
	private static String USERNAME = "root";
	private static String PASS = "";
	public static void main(String[] args) {
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//��ȡ���ݿ�����
		Connection con = null;
		Statement state = null;
		try {
			con = DriverManager.getConnection(URL,USERNAME,PASS);
			//׼��SQL
			String sql = "INSERT INTO users(id,account,password)VALUES(4,'����','1231234')";
			//����״̬���ύSQL��䣬ִ��SQL���
			state = con.createStatement();
			int row = state.executeUpdate(sql);
			//����ִ�н��
			System.out.println(row);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(state != null)
					state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					if(con != null)
						con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void query(){
		//����������
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				ResultSet set = null;
				Statement state = null;
				Connection con = null;
				//��ȡ���ݿ�����
				try {
					con = DriverManager.getConnection(URL,USERNAME,PASS);
					System.out.println(con);
					//׼��SQL���
					String sql = "SELECT * FROM users";
					//ִ��SQL���
					//��ȡstatement����
					state = con.createStatement();
					//��ȡ�����
					set = state.executeQuery(sql);
					//���������
					while(set.next()){
						int id = set.getInt("id");
						String account = set.getString("account");
						String password = set.getString("password");
						int userid = set.getInt("userid");
						System.out.println(id+":"+account+":"+password+":"+userid);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					try {
						if(set != null)
							set.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						try {
							if(state != null)
								state.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}finally{
							try {
								if(con != null)
									con.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
	}
}
