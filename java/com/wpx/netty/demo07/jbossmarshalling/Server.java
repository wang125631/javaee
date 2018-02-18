package com.wpx.netty.demo07.jbossmarshalling;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * 服务端类
 * @author wangpx
 */
public class Server {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(bossGroup, workGroup)
						   .channel(NioServerSocketChannel.class)
						   .option(ChannelOption.SO_BACKLOG,1024)
						   //开启日志
						   .handler(new LoggingHandler(LogLevel.INFO))
						   .childHandler(new ChannelInitializer<SocketChannel>() {
							@Override
							protected void initChannel(SocketChannel ch) throws Exception {
								
								ch.pipeline().addLast(MarshallingCodeFactory.buildMarshallingDecoder());
								ch.pipeline().addLast(MarshallingCodeFactory.buildMarshallingEncoder());
								
								ch.pipeline().addLast(new ServerHandler());
						
							}
						});
			ChannelFuture future = serverBootstrap.bind(8888).sync();
			future.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
}
