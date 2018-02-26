package com.wpx.storm.demo03.bolt;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;



public class SplitBolt implements IRichBolt{
	
	private static final long serialVersionUID = 1L;
	private OutputCollector collector;
	private boolean flag;
	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {

		this.collector = collector;
	}

	@Override
	public void execute(Tuple input) {
		 try {
			String subjects = input.getStringByField("subjects");
			String[] words = subjects.split(",");
			for(String word : words ) {
				collector.emit(input,new Values(word));
			}
			collector.ack(input);
		 } catch (Exception e) {
			e.printStackTrace();
			collector.fail(input);
		}
		
	}

	@Override
	public void cleanup() {
		 
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		 declarer.declare(new Fields("word"));
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		 
		return null;
	}

}
