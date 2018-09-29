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
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//获取数据库链接
		Connection con = null;
		Statement state = null;
		try {
			con = DriverManager.getConnection(URL,USERNAME,PASS);
			//准备SQL
			String sql = "INSERT INTO users(id,account,password)VALUES(4,'张三','1231234')";
			//创建状态并提交SQL语句，执行SQL语句
			state = con.createStatement();
			int row = state.executeUpdate(sql);
			//操作执行结果
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
		//加载驱动类
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				ResultSet set = null;
				Statement state = null;
				Connection con = null;
				//获取数据库连接
				try {
					con = DriverManager.getConnection(URL,USERNAME,PASS);
					System.out.println(con);
					//准备SQL语句
					String sql = "SELECT * FROM users";
					//执行SQL语句
					//获取statement对象
					state = con.createStatement();
					//获取结果集
					set = state.executeQuery(sql);
					//操作结果集
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
