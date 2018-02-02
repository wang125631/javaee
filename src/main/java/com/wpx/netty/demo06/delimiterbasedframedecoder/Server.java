package com.wpx.netty.demo06.delimiterbasedframedecoder;



import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 
 * DelimiterBasedFrameDecoder
 * 通过自定义分隔符的方式来实现数据的截取
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
		/**
		 * 在服务器TCP内核模块维护有两个队列
		 * 客户端向服务端connect的时候,会发送带有SYN标志的包(第一次握手)
		 * 服务端收到客户端发来的SYN时,向客户端发送SYN ACK确认(第二次握手) 此时Tcp会把客户端连接加入到队列1中
		 * 当服务端收到客户端发送ACK时(第三次握手) Tcp内核会把客户端从队列1中放到队列2中 ,连接完成,应用程序accept返回
		 * 
		 * SO_BACKLOG 为为两个队列的长度,当两个队列的长度大于backlog时,新连接会被TCP内核拒绝
		 * backlog对程序支持的连接并无影响,backlog影响的只是没有被accept取出的连接
		 * 
		 */
						   .option(ChannelOption.SO_BACKLOG, 1024)
						   .childHandler(new ChannelInitializer<SocketChannel>() {
							@Override
							protected void initChannel(SocketChannel ch) throws Exception {
								ByteBuf delimiter=Unpooled.copiedBuffer("$$_".getBytes());
								ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,delimiter));
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
