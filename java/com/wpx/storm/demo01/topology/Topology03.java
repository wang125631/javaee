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
import backtype.storm.tuple.Fields;



public class Topology03 {

	public static void main(String[] args) throws InterruptedException, AlreadyAliveException, InvalidTopologyException  {
		Config config = new Config();
		config.setNumWorkers(2);
		config.setDebug(true);
		
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("spout", new Spout(), 4);
		builder.setBolt("print-bolt", new PrintBolt(), 4).shuffleGrouping("spout");
		//设置字段分组
		builder.setBolt("write-bolt",new WriteBolt(),8).fieldsGrouping("print-bolt", new Fields("write"));
		//设置完全分组
		builder.setBolt("write-bolt", new WriteBolt(),4).allGrouping("print-bolt");
		//设置全局分组
		builder.setBolt("write-bolt", new WriteBolt(), 4).globalGrouping("print-bolt");
		
		//本地模式
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("top3", config, builder.createTopology());;
		Thread.sleep(100);
		cluster.killTopology("top3");
		cluster.shutdown();
		
		//集群模式
		StormSubmitter.submitTopology("top3", config, builder.createTopology());
	}
}
