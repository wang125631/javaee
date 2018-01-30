package com.wpx.netty.demo02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * 服务器端处理类
 * 
 * @author wangpx
 */
public class ServerHandler  implements Runnable{
	private Socket socket;
	public ServerHandler(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		BufferedReader in =null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(),true);
			String body =null;
			while(true) {
				body = in.readLine();
				if( body == null) {
					break;
				}
				System.out.println("客户端发送的数据为" + body);
				out.println("服务端的相应数据....");
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
			
		}
	}

}
