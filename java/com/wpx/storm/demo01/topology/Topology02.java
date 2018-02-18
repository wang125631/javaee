package com.wpx.storm.demo01.topology;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.topology.TopologyBuilder;

import com.wpx.storm.demo01.bolt.PrintBolt;
import com.wpx.storm.demo01.bolt.WriteBolt;
import com.wpx.storm.demo01.spout.Spout;

/**
 * 
 * 并行度和任务数
 * 
 * @author wangpx
 */

public class Topology02 {

	public static void main(String[] args) throws InterruptedException, AlreadyAliveException, InvalidTopologyException, AuthorizationException {
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
