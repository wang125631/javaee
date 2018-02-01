package com.wpx.netty.demo05;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 服务端类
 * @author wangpx
 */
public class Server {

	public static void main(String[] args) throws InterruptedException {
		//用于接受Client端连接
		NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		//实际的业务处理操作
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
	
		//创建Bootstrap辅助类,对Server进行一系列的配置
		ServerBootstrap b = new ServerBootstrap();
		//把两个工作线程组加入
		b.group(bossGroup, workGroup)
		//指定使用NioServerSocketChannel这种类型的通道
		 .channel(NioServerSocketChannel.class)
		 //使用childHandler去绑定具体的事件处理器
		 .childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel sc) throws Exception {
				sc.pipeline().addLast(new ServerHandler());
			}
		});
		
		ChannelFuture f = b.bind(8888).sync();
		
		f.channel().closeFuture().sync();
		
		bossGroup.shutdownGracefully();
		workGroup.shutdownGracefully();
	}
}
