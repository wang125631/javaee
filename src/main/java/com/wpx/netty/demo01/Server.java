package com.wpx.netty.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class Server {

	public static void main(String[] args) {
		//新建serverSocket对象监听8888端口
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(8888);
			//serverSocket的accept方法会将其阻塞
			Socket socket = serverSocket.accept();
			//新启动一个线程去处理
			new Thread(new ServerHandler(socket)).start();
			}
		catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
