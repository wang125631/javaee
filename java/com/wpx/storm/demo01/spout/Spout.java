package com.wpx.storm.demo01.spout;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
/**
 * 
 * @author wangpx
 */
public class Spout extends BaseRichSpout{


	private static final long serialVersionUID = 1L;
	
	private SpoutOutputCollector collector;

	private static final Map<Integer,String> map= new HashMap<Integer,String>();
	
	static {
		map.put(0, "java");
		map.put(2, "ruby");
		map.put(4, "groovy");
	}
	
	@Override
	public void nextTuple() {
		// 随机发送一个单词
		final Random r =new Random();
		int num = r.nextInt(5);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.collector.emit(new Values(map.get(num)));
	}

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		 //对spout进行初始化
		this.collector = collector; 
		System.out.println(this.collector);
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		 //进行声明
		declarer.declare(new Fields("print"));
	}

}
