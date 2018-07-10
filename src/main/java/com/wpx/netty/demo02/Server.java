package com.wpx.netty.demo02;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器类
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class Server {

	public static void main(String[] args) {
		
		ServerSocket server = null;
		BufferedReader in = null;
		PrintWriter out =null;
		
		try {
			server = new ServerSocket(8756);
			System.out.println("服务端启动 ...");
			Socket socket = null;
			ExecutorPoolHandler poolHandler = new ExecutorPoolHandler(50, 10000);
			while(true) {
				socket = server.accept();
				poolHandler.execute(new ServerHandler(socket)); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(in != null){
				try {
					in.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(server != null){
				try {
					server.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
			server = null;		
		}
		
		
	}
}
