package com.wpx.netty.demo06.fixedlengthfrmaedecoder;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 服务端处理类
 * @author wangpx
 */
@SuppressWarnings("all")
public class ServerHandler  extends ChannelHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String data=(String) msg;
		System.out.println("客户端发送的数据为 "+msg);
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
