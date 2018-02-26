package com.wpx.storm.demo02.bolt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;



public class WordReportBolt implements IRichBolt{

	private HashMap<String,Long> counts= null;
	
	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.counts= new HashMap<String,Long>();
	}

	@Override
	public void execute(Tuple tuple) {
	 String word = tuple.getStringByField("word");
	 Long count = tuple.getLongByField("count");
	 this.counts.put(word, count);
	}

	@Override
	public void cleanup() {
	 System.out.println("------FINAL COUNT-----");
	 ArrayList<String> keys = new ArrayList<String>();
	 keys.addAll(this.counts.keySet());
	 Collections.sort(keys);
	 for(String key : keys) {
		 System.out.println(key + " : "+this.counts.get(key));
	 }
	 System.out.println("------");
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
	 
		
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
	 
		return null;
	}

}
