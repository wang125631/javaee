package com.wpx.storm.demo03.topology;




import com.wpx.storm.demo03.bolt.SplitBolt;
import com.wpx.storm.demo03.bolt.WriterBolt;
import com.wpx.storm.demo03.spout.MessageSpout;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;

/**
 * 
 * @author wangpx
 */
public class MessageTopology {

	public static void main(String[] args) throws InterruptedException {
	TopologyBuilder topologyBuilder = new TopologyBuilder();
	topologyBuilder.setSpout("spout", new MessageSpout());
	topologyBuilder.setBolt("split-spout", new SplitBolt()).shuffleGrouping("spout");
	topologyBuilder.setBolt("write-spout", new WriterBolt()).shuffleGrouping("split-spout");
	//±æµÿ≈‰÷√
	Config config = new Config();
	config.setDebug(false);
	LocalCluster localCluster = new LocalCluster();
	System.out.println(localCluster);
	localCluster.submitTopology("message", config, topologyBuilder.createTopology());
	Thread.sleep(1000);
	localCluster.killTopology("message");
	localCluster.shutdown();
	}
}
