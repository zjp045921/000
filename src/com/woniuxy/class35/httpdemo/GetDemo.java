package com.woniuxy.class35.httpdemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetDemo {
	public static void main(String[] args) {
		String urlStr = "http://localhost/Agileone_1.2/index.php";
		URL url = null;
		HttpURLConnection http = null;
		InputStream is = null;
		try {
			url = new URL(urlStr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		try {
			http = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 设置请求头信息
		http.setRequestProperty(
				"Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		http.setRequestProperty("Cookie",
				"PHPSESSID=013b791e77b7ff5125f2a76212319940");
		// 建立链接
		try {
			http.connect();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 接收服务器相应数据
		try {
			is = http.getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		byte[] content = new byte[1024];
		int len = -1;
		try {
			while ((len = is.read(content)) != -1) {
				System.out.println(new String(content, 0, len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				http.disconnect();
			}
		}

	}
}
