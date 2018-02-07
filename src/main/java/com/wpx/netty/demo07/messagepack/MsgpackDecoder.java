package com.wpx.netty.demo07.messagepack;

import java.util.List;

import org.msgpack.MessagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

/**
 * MessagePack解码器
 * 
 * @author wangpx
 */
public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf>{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
			//定义输出缓存数组
			final byte[] array;
			//可读缓存长度
			final int length = msg.readableBytes();
			array = new byte[length];
			msg.getBytes(msg.readerIndex(), array, 0, length);
			MessagePack messagePack = new  MessagePack();
			out.add(messagePack.read(array));
	}
	

}
