
/**
 * 分部式RPC调用
 * 
 * DRPC是通过一个DRPC服务器来实现分布式RPC功能的 DRPC server负责接收RPC请求,
 * 并将该请求发送到Storm中运行中Topology,等待接收Topology发送的处理结果,并
 * 将结果返回给客户端. 因此从客户端的角度来说,DRPC与普通的RPC调用没有什么区别
 * 
 * @author wangpx    
 */
package com.wpx.storm.demo04;