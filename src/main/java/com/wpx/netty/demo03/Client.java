package com.wpx.netty.demo03;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 客户端类
 * 
 * @author wangpx
 */
public class Client {

	public static void main(String[] args) {
	
		//创建连接地址
		InetSocketAddress address = new InetSocketAddress("127.0.0.1",8888);
		//声明连接通道
		SocketChannel sc =null;
		//建立缓冲区
		ByteBuffer buf = ByteBuffer.allocate(1024);
		try {
			//打开通道
			sc = SocketChannel.open();
			//进行连接
			sc.connect(address);
			
			while(true) {
				//自定义一个字节数组,使用系统的标准输入流
				byte[] bytes = new byte[1024];
				System.in.read(bytes);
				//把数据放到缓冲区
				buf.put(bytes);
				//对缓冲区进行复位
				buf.flip();
				//写出数据
				sc.write(buf);
				//清空缓存区数据
				buf.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
}
