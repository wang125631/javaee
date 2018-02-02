package com.wpx.netty.demo06.linebasedframedecoder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 
 * LineBasedFrameDecoder的工作原理为依次遍历ByteBuf中的可读字节,
 * 判断是否有"\n" 或"\r\n" 如果有就以此为结束位置"
 * 
 * 服务端类
 * 
 * @author wangpx
 */
public class Server {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(bossGroup, workGroup)
					 .channel(NioServerSocketChannel.class)
					 .option(ChannelOption.SO_BACKLOG, 1024)
					 .childHandler( new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
							ch.pipeline().addLast(new StringDecoder());
							ch.pipeline().addLast(new ServerHandler());
						}
					});
			ChannelFuture future = bootstrap.bind(8888).sync();
			future.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
}
