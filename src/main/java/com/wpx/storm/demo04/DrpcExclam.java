package com.wpx.storm.demo04;

import org.apache.thrift7.TException;

import backtype.storm.generated.DRPCExecutionException;
import backtype.storm.utils.DRPCClient;

public class DrpcExclam {

	public static void main(String[] args) throws TException, DRPCExecutionException {
		DRPCClient client = new DRPCClient("drpc-host", 3772);
		String result = client.execute("reach", "http://twitter.com");
	
	}
}
