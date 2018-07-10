package com.wpx.netty.demo06.linebasedframedecoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 客户端处理类
 * @author wangpx
 */
public class Client {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(workGroup)
					 .channel(NioSocketChannel.class)
					 .handler(new  ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
							ch.pipeline().addLast(new StringDecoder());
							ch.pipeline().addLast(new ClientHandler());
						}
					});
			ChannelFuture future = bootstrap.connect("127.0.0.1", 8888).sync();
			for(int i=0;i<10;i++) {
				String data="Hello Nio"+System.getProperty("line.separator");
				future.channel().writeAndFlush(Unpooled.copiedBuffer(data.getBytes()));
			}
			future.channel().closeFuture().sync();
			
		} finally {
			workGroup.shutdownGracefully();
		}
	}
}
