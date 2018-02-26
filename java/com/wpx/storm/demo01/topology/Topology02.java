package com.wpx.storm.demo01.topology;


import com.wpx.storm.demo01.bolt.PrintBolt;
import com.wpx.storm.demo01.bolt.WriteBolt;
import com.wpx.storm.demo01.spout.Spout;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.topology.TopologyBuilder;

/**
 * 
 * 并行度和任务数
 * 
 * @author wangpx
 */

public class Topology02 {

	public static void main(String[] args) throws InterruptedException, AlreadyAliveException, InvalidTopologyException{
			Config config = new Config();
			config.setNumWorkers(2);//设置使用两个工作进程
			config.setDebug(false);
			TopologyBuilder builder = new TopologyBuilder();
			//设置Spout的并行度和任务数
			builder.setSpout("spout", new Spout(),2);//.setNumTasks(2)
			//设置bolt的并行度和任务数:(产生2个执行器和4任务)
			builder.setBolt("print-bolt", new PrintBolt(),2).shuffleGrouping("spout").setNumTasks(4);
			builder.setBolt("write-bolt",new WriteBolt(),6).shuffleGrouping("print-bolt");
			//本地模式
			LocalCluster cluster = new LocalCluster();
			cluster.submitTopology("top2", config, builder.createTopology());
			Thread.sleep(1000);
			cluster.killTopology("top2");
			cluster.shutdown();
			//集群模式
			StormSubmitter.submitTopology("top2", config,builder.createTopology());
	}
	
}
