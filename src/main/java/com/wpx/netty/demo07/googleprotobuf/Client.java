package com.wpx.netty.demo07.googleprotobuf;



import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;


/**
 * 
 * 客户端类
 * 
 * @author wangpx
 */
public class Client {

	@SuppressWarnings("resource")
	public void connect(int port,String hostAddress) throws InterruptedException {
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(workGroup)
					 .channel(NioSocketChannel.class)
					 .option(ChannelOption.SO_BACKLOG, 1024)
					 .handler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
							ch.pipeline().addLast(new ProtobufDecoder(SubscribeRespProto.SubscribeReq.getDefaultInstance()));
							ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
							ch.pipeline().addLast(new ProtobufEncoder());
							ch.pipeline().addLast(new ClientHandler());
						}
					});
			ChannelFuture future = bootstrap.connect(hostAddress, port).sync();
			System.out.println("客户端 hostAddress:"+hostAddress+ " port: "+port+ " 发起连接....");
			future.channel().closeFuture().sync();
		} finally {
			workGroup.shutdownGracefully();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		int port=8080;
		if(args !=null && args.length>0) {
			try {
				port=Integer.valueOf(args[0]);
			} catch (Exception e) {
				port=8080;
			}
		}
		new Client().connect(port, "127.0.0.1");
	}
}
