package com.wpx.netty.demo07.googleprotobuf;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class Server {

	@SuppressWarnings("resource")
	public void bind(int port) throws Exception{
		NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(bossGroup, workGroup)
						   .channel(NioServerSocketChannel.class)
						   .option(ChannelOption.SO_BACKLOG, 1024)
						   .handler(new LoggingHandler(LogLevel.INFO))
						   .childHandler(new ChannelInitializer<SocketChannel>() {
							@Override
							protected void initChannel(SocketChannel ch) throws Exception {
								ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
								ch.pipeline().addLast(new ProtobufDecoder(SubscribeReqProto.SubscribeReq.getDefaultInstance()));
								ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
								ch.pipeline().addLast(new ProtobufEncoder());
								ch.pipeline().addLast(new ServerHandler());
							}
						});
			
			ChannelFuture f = serverBootstrap.bind(port).sync();
			System.out.println("服务端启动,监听的端口号为:  "+port);
			f.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
	public static void main(String[] args) throws Exception {
		new Server().bind(8080);
	}
}
