package com.wpx.storm.demo02.topology;



import com.wpx.storm.demo02.bolt.WordCountBolt;
import com.wpx.storm.demo02.bolt.WordReportBolt;
import com.wpx.storm.demo02.bolt.WordSplitBolt;
import com.wpx.storm.demo02.spout.WordSpout;
import com.wpx.storm.demo02.util.WaitUtils;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;

public class WordTopology {

	//定义常量
	private static final String WORD_SPOUT_ID = "word-spout";
	private static final String SPLIT_BOLT_ID="split-bolt";
	private static final String COUNT_BOLT_ID="count-bolt";
	private static final String REPORT_BOLT_ID="report-bolt";
	private static final String TOPOLOGY_NAME="word-count-topology";
	public static void main(String[] args) {
		//实例化对象
		WordSpout spout = new WordSpout();
		WordSplitBolt wordSplitBolt = new WordSplitBolt();
		WordCountBolt wordCountBolt = new WordCountBolt();
		WordReportBolt wordReportBolt = new WordReportBolt();
		
		//构建拓扑
		TopologyBuilder topologyBuilder = new TopologyBuilder();
		topologyBuilder.setSpout(WORD_SPOUT_ID, spout);
		
		//WordSpout -> WordSplitBolt
		topologyBuilder.setBolt(SPLIT_BOLT_ID,wordSplitBolt).shuffleGrouping(WORD_SPOUT_ID);
		
		//WordSplitBolt -> WordCountBolt
		topologyBuilder.setBolt(COUNT_BOLT_ID, wordCountBolt).fieldsGrouping(SPLIT_BOLT_ID, new Fields("word"));
		
		//WordCountBolt -> WordReportBolt
		topologyBuilder.setBolt(REPORT_BOLT_ID, wordReportBolt).globalGrouping(COUNT_BOLT_ID);
	
		//本地配置
		LocalCluster localCluster = new LocalCluster();
		Config config = new Config();
		config.setDebug(false);
		
		localCluster.submitTopology(TOPOLOGY_NAME, config,topologyBuilder.createTopology());
		WaitUtils.waitForMillis(10);
		localCluster.killTopology(TOPOLOGY_NAME);
		localCluster.shutdown();
	}
}
