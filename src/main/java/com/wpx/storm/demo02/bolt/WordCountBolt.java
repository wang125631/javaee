package com.wpx.storm.demo02.bolt;

import java.util.HashMap;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;




@SuppressWarnings("all")
public class WordCountBolt implements IRichBolt{

	private OutputCollector collector;
	private HashMap<String,Long> counts=null;
	
	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		 this.collector = collector;
		 this.counts = new HashMap<String,Long>();
	}

	@Override
	public void execute(Tuple tuple) {
		 String word = tuple.getStringByField("word");
		 Long count = this.counts.get(word);
		 if(count == null) {
			 count = 0L;
		 }
		 count++;
		 this.counts.put(word, count);
		 this.collector.emit(new Values(word,count));
	}

	@Override
	public void cleanup() {
		 
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		 declarer.declare(new Fields("word","count"));
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		 
		return null;
	}

}
