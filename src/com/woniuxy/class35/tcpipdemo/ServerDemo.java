package com.woniuxy.class35.tcpipdemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	public static void main(String[] args){
		int port = 554;
		ServerSocket server = null;
		Socket soc = null;
		InputStream is = null;
		
		try {
			server = new ServerSocket(port);
			//创建客户端接收数据
			try {
				System.out.println("1");
				soc = server.accept();
				System.out.println("2");
				//读取源IP
				System.out.println(soc.getInetAddress());
				//读取接收到的数据
				//获取输入流
				is = soc.getInputStream();
				//定义byte数组 接收流
				byte[] bytes = new byte[1024];
				int len = -1;
				while((len = is.read(bytes)) != -1){
					String str = new String(bytes,0,len);
					System.out.println(str);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally{
			try {
				if(is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(soc != null)
						soc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
