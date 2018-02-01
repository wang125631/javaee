package com.wpx.netty.demo05;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * øÕªß∂À¿‡
 * @author wangpx
 */
public class Client {

	public static void main(String[] args) throws InterruptedException {
	
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		Bootstrap bootstrap = new Bootstrap();
		bootstrap
				.group(workGroup)
				.channel(NioSocketChannel.class)
				.handler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel sc) throws Exception {
						sc.pipeline().addLast(new ClientHandler());
					}
				});
		
		ChannelFuture future = bootstrap.connect("127.0.0.1", 8888).sync();
		future.channel().writeAndFlush(Unpooled.copiedBuffer("Hello Netty".getBytes()));
		future.channel().closeFuture().sync();
		workGroup.shutdownGracefully();
		}
}
