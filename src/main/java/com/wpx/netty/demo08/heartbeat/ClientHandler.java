package com.wpx.netty.demo08.heartbeat;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler extends ChannelHandlerAdapter{

	private static final ByteBuf HEARTBEAT_SEQUENCE = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Heartbeat", CharsetUtil.UTF_8));
	
	private static final int TRY_TIMES = 3;
	
	private int currentTime = 0;
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("启动时间是 :"+new Date());
		System.out.println("Client channelActive ....");
		ctx.fireChannelActive();
	}
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("Client channelInactive ...");
	}
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		System.out.println("触发时间 "+new Date());
		if(evt instanceof IdleStateEvent) {
			IdleStateEvent event=(IdleStateEvent)evt;
			if(event.state() == IdleState.WRITER_IDLE) {
				if(currentTime <= TRY_TIMES) {
					System.out.println("currentTime: "+currentTime);
					currentTime++;
					ctx.channel().writeAndFlush(HEARTBEAT_SEQUENCE.duplicate());
				}
			}
		}
	}
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		String message=(String) msg;
		System.out.println(message);
		if(message.equals("Heartbeat")) {
			ctx.writeAndFlush("has read message from server ");
		}
		ReferenceCountUtil.release(msg);
	}
}
