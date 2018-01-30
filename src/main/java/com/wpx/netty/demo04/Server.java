package com.wpx.netty.demo04;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务器端
 * 
 * @author wangpx
 */
public class Server {
	//线程池
		private ExecutorService executorService;
		//线程组
		private AsynchronousChannelGroup threadGroup;
		//服务器通道
		public AsynchronousServerSocketChannel assc;
		
		public Server(int port) {
			try {
				//创建一个线程池
				executorService = Executors.newCachedThreadPool();
				//创建线程组
				threadGroup=  AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
				//创建服务器通道
				assc=AsynchronousServerSocketChannel.open(threadGroup);
				//进行绑定
				assc.bind(new InetSocketAddress(port));
				System.out.println("Server start , port "+port);
				//进行阻塞
				assc.accept(this,new ServerHandler());
				//一直阻塞
				Thread.sleep(Integer.MAX_VALUE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static void main(String[] args) {
			 new Server(8888);
		}
}
