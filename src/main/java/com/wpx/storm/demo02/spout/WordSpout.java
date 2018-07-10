package com.wpx.storm.demo02.spout;

import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichSpout;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Values;



public class WordSpout implements IRichSpout{
	
	private static final long serialVersionUID = 1L;

	private SpoutOutputCollector collector;
	
	private int index = 0;
	
	private String[] sentences = {
			"my dof has fleas",
			"i like cold beverages",
			"the dog ate my homework",
			"don't have a cow man",
			"i don't think i like fleas"
	};
	
	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		 this.collector = collector;
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
		 this.collector.emit(new Values(sentences[index]));
		 index++;
		 int length = sentences.length;
		 if(index >= length) {
			 index=0;
		 }
		 
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
