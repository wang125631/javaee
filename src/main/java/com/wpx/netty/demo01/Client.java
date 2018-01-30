package com.wpx.netty.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class Client {

	public static void main(String[] args) {
	
		try {
			//创建连接socket对象连接
			Socket socket = new Socket("127.0.0.1", 8888);
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write("Hello BIO".getBytes());
			outputStream.flush();
			outputStream.close();
			socket.close();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
