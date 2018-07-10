package com.wpx.storm.demo03.spout;

import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichSpout;
import backtype.storm.topology.OutputFieldsDeclarer;



public class MessageSpout implements IRichSpout{
	
	private static final long serialVersionUID = 1L;

	private int index = 0;
	private String[] subjects =new String[]{
		"groovy,python",
		"openfire,restful",
		"flume,activiti",
		"hadoop,hbase",
		"spark,sqoop"
	};
	
	private SpoutOutputCollector collector;
	
	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		this.collector=collector;
	}

	@Override
	public void close() {
 
		
	}

	@Override
	public void activate() {
 
		
	}

	@Override
	public void deactivate() {
 
		
	}

	@Override
	public void nextTuple() {
 
		
	}

	@Override
	public void ack(Object msgId) {
 
		
	}

	@Override
	public void fail(Object msgId) {
 
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
 
		
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
 
		return null;
	}

}
