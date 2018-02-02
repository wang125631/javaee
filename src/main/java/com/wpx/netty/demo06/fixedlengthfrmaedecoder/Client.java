package com.wpx.netty.demo06.fixedlengthfrmaedecoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * øÕªß∂À¿‡
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
					 .handler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new FixedLengthFrameDecoder(15));
							ch.pipeline().addLast(new StringDecoder());
							ch.pipeline().addLast(new ClientHandler());
						}
					});
			ChannelFuture future = bootstrap.connect("127.0.0.1",8888).sync();
		
			future.channel().writeAndFlush(Unpooled.copiedBuffer("Wangpengxiao send message ....".getBytes()));
			
			future.channel().closeFuture().sync();
			
		} finally {
			workGroup.shutdownGracefully();
		}
		
	}
}
