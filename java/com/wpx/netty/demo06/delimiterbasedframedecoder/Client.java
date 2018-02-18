package com.wpx.netty.demo06.delimiterbasedframedecoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 
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
							 ByteBuf delimiter=Unpooled.copiedBuffer("$$_".getBytes());
							 ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
							 ch.pipeline().addLast(new StringDecoder());
							 
						}
					});
			
			ChannelFuture future = bootstrap.connect("127.0.0.1", 8888).sync();
			String data= "Hello Netty $$_";
			for(int i=0;i<10;i++) {
				future.channel().writeAndFlush(Unpooled.copiedBuffer(data.getBytes()));
			}
		
			future.channel().closeFuture().sync();
		} finally {
			workGroup.shutdownGracefully();
		}
	}
}
