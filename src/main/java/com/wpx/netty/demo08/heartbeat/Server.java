package com.wpx.netty.demo08.heartbeat;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

public class Server {

	private int port;

	private Server(int port) {
		this.port = port;
	}
	@SuppressWarnings("resource")
	public void start() {
		NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(bossGroup, workGroup)
						   .channel(NioServerSocketChannel.class)
						   .localAddress(new InetSocketAddress(port))
						   .childHandler(new ChannelInitializer<SocketChannel>() {
							   private static final int READ_IDEL_TIME_OUT=5; //读超时
							   private static final int WRITE_IDEL_TIME_OUT=0; //写超时
							   private static final int ALL_IDEL_TIME_OUT=0; //所有超时
							@Override
							protected void initChannel(SocketChannel ch) throws Exception {
								ch.pipeline().addLast(new IdleStateHandler(READ_IDEL_TIME_OUT, WRITE_IDEL_TIME_OUT, ALL_IDEL_TIME_OUT, TimeUnit.SECONDS));
								ch.pipeline().addLast("encoder",new StringEncoder());
								ch.pipeline().addLast("decoder",new StringDecoder());
								ch.pipeline().addLast(new ServerHandler());
							}
						});
			//绑定端口,开始接收进来的连接
			ChannelFuture future = serverBootstrap.bind(port).sync();
			System.out.println(" Server start listen at " +port);
			
			future.channel().closeFuture().sync();
		} catch (Exception e) {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) {
		int port;
		if(args.length > 0) {
			try {
				port = Integer.parseInt(args[0]);
			} catch (Exception e) {
				port =8080;
			}
		}
		port =8080;
		new Server(port).start();
	}
}
