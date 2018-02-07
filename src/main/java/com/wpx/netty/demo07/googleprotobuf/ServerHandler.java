package com.wpx.netty.demo07.googleprotobuf;

import com.wpx.netty.demo07.googleprotobuf.SubscribeReqProto.SubscribeReq;


import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
/**
 * netty 5
 * 
 * @author wangpx
 */
@Sharable
public class ServerHandler extends ChannelHandlerAdapter{

@Override
public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
	//将msg转化为指定格式
	SubscribeReqProto.SubscribeReq req=(SubscribeReq) msg;
	System.out.println(" 服务端接受到的信息:  "+req.toString());
	ctx.writeAndFlush(resp(req.getSubReqID()));
}
	private SubscribeRespProto.SubscribeReq resp(int subReqID){
		SubscribeRespProto.SubscribeReq.Builder builder = SubscribeRespProto.SubscribeReq.newBuilder();
		builder.setSubReqID(subReqID);
		builder.setRespCode(0);
		builder.setDesc("desc message ...");
		return builder.build();
	}
	@Override
		public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
			cause.printStackTrace();
			ctx.close();
		}
}
