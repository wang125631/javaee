package com.wpx.netty.demo08.heartbeat;

import java.util.concurrent.TimeUnit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

public class Client {

	@SuppressWarnings("resource")
	public void connect(int port,String host)throws Exception {
		ChannelFuture future=null;
		//Configure the client
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.group(workGroup)
				 .channel(NioSocketChannel.class)
				 .option(ChannelOption.TCP_NODELAY, true)
				 .handler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ChannelPipeline pipeline = ch.pipeline();
						pipeline.addLast("decoder",new StringDecoder());
						pipeline.addLast("encoder",new StringEncoder());
						pipeline.addLast("ping",new IdleStateHandler(0, 4, 0, TimeUnit.SECONDS));
						pipeline.addLast(new ClientHandler());
					}
				});
		try {
			future = bootstrap.connect(host, port).sync();
			future.channel().writeAndFlush("Hello Netty Server ,I am a common client ");
			future.channel().closeFuture().sync();
		} finally {
			if(future != null) {
				if(future.channel()!=null && future.channel().isOpen()) {
					future.channel().close();
				}
			}
			System.out.println("准备重连 ");
			connect(port, host);
			System.out.println("重连成功");
		}
	}
	
	public static void main(String[] args) throws Exception {
		int port = 8080;
		if(args !=null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (Exception e) {
				port =8080;
			}
		}
		new Client().connect(port, "127.0.0.1");

	}
}
