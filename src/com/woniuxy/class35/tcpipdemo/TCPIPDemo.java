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
			// ����socket���󣬷�װĿ��IP�Ͷ˿���Ϣ����������ͨ������
			Socket TCPIPDemo = new Socket(aimIP, aimPort);
			// ��������
			// ��ȡĿ����������
			os = TCPIPDemo.getOutputStream();
			System.out.println("2");
			// ���ֽ���תΪ�ַ���
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
