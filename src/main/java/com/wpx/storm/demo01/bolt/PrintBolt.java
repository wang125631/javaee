package com.wpx.storm.demo01.bolt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;



/**
 * 
 * 
 * 
 * @author wangpx
 */
public class PrintBolt extends BaseBasicBolt{

	private static final Log log=LogFactory.getLog(PrintBolt.class);
	
	private static final long serialVersionUID = 1L;

	@Override
	public void execute(Tuple tuple, BasicOutputCollector collector) {
		//获取上个组件声明的Field
		String print = tuple.getStringByField("print");
		log.info("print : "+print);
		//进行传递给下一个bolt
		collector.emit(new Values(print));
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("write"));
	}

}
