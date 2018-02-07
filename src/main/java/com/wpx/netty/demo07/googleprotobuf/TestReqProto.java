package com.wpx.netty.demo07.googleprotobuf;

import java.util.ArrayList;

import com.google.protobuf.InvalidProtocolBufferException;
import com.wpx.netty.demo07.googleprotobuf.SubscribeReqProto.SubscribeReq.Builder;


public class TestReqProto {

	/**
	 * 编码
	 */
	private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
		return req.toByteArray();
	}
	/**
	 * 解码
	 */
	private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException{
		return SubscribeReqProto.SubscribeReq.parseFrom(body);
	}
	/**
	 * 
	 * 设置请求体
	 */
	private static SubscribeReqProto.SubscribeReq createSubscribeReq(){
		Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
		//c++ int32 
		builder.setSubReqID(1);
		builder.setUserName("wangpx");
		builder.setProductName("Nothing");
		ArrayList<String> address = new ArrayList<String>();
		address.add("Guangdong Zhaoqing");
		address.add("Henan AnYang");
		builder.addAllAddress(address);
		return builder.build();
	}
	public static void main(String[] args) throws InvalidProtocolBufferException {
		SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode : " + req.toString());
        SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
        System.out.println("After decode : " + req.toString());
        System.out.println("Assert equal : --> " + req2.equals(req));
	}
}
