package com.woniuxy.class35.tcpipdemo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPIPDemo {
	public static void main(String[] args) {
		String aimIP = "localhost";
		int aimPort = 554;
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		System.out.println("3");
		try {
			// 创建socket对象，封装目标IP和端口信息，建立数据通道链接
			Socket TCPIPDemo = new Socket(aimIP, aimPort);
			// 发送数据
			// 获取目标主机的流
			os = TCPIPDemo.getOutputStream();
			System.out.println("2");
			// 将字节流转为字符流
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			System.out.println("1");
			bw.write("hello world");
			bw.flush();

		} catch (Exception e) {
			
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (osw != null)
						osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (os != null)
							os.close();
					} catch (IOException e) {
						e.printStackTrace();
					} 
				}
			}
		}
	}

}
