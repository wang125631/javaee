package com.wpx.netty.demo06.fixedlengthfrmaedecoder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * FixedLengthFrameDecoder
 * 按照指定长度对消息进行自动解码
 * 
 * @author wangpx
 */
public class Server {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap serverBootstrap = new  ServerBootstrap();
			serverBootstrap.group(bossGroup, workGroup)
						   .channel(NioServerSocketChannel.class)
						   .option(ChannelOption.SO_BACKLOG, 1024)
						   .childHandler(new ChannelInitializer<SocketChannel>() {
							@Override
							protected void initChannel(SocketChannel ch) throws Exception {
								ch.pipeline().addLast(new FixedLengthFrameDecoder(15));
								ch.pipeline().addLast(new StringDecoder());
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
