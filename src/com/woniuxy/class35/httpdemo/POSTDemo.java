package com.woniuxy.class35.httpdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class POSTDemo {
	public static void main(String[] args) {
		String urlStr = "http://localhost/Agileone_1.2/index.php";
		HttpURLConnection http = null;
		OutputStream os = null;
		InputStream is = null;
		URL url = null;
		try {
			url = new URL(urlStr);
			//��ȡHttpURLConnection
			http = (HttpURLConnection)url.openConnection();
			//�������Ӳ�����Ϣ
			//��������ʽ  Ĭ��ΪGET
			http.setRequestMethod("POST");
			http.setRequestProperty("Cookie", "PHPSESSID=942fc3c184f4ffb26ac959befc604dfb");
			http.setDoOutput(true);
			//��������
			http.connect();
			
			//����������������
			//��ȡ�����
			os = http.getOutputStream();
			//����������������
			String requestContect = "username=admin& password=admin&savelogin = true"; 
			os.write(requestContect.getBytes());
			//���շ�������Ӧ����
			is = http.getInputStream();
			byte[] contect = new byte[1024];
			int len = -1;
			while((len=is.read(contect))!= -1){
				System.out.println(new String(contect,0,len));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(os != null)
						os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					http.disconnect();
				}
			}
		}
	}
}
