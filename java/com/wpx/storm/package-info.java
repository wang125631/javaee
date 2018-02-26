/**
 * 
 * 链接：https://pan.baidu.com/s/1qZawwf6
 * 密码：w0gd
 * 
 * 	Storm 中基本概念
 * 
 *  1.拓扑 Topology
 *  2.流 Stream
 *  3.数据源 Spout
 *  4.数据流处理组件 Bolt
 *  5.数据流分组 Stream group
 *  6.可靠性 Reliability
 *  7.任务 Task
 *  7.工作 Worker
 *  
 * 		 拓扑 Topology
 * 
 *  Storm的拓扑是对计算应用逻辑的封装,它的作用与MapReduce的Job相似,区别在于MapReduce的一个Job在得到结果之后总会结束,而拓扑一直在集群中运行,直到手动终止
 *  Topology可以理解为一系列通过Stream Grouping 相互关联的Spout和Bolt组成的拓扑结构,Spout和Bolt称为拓扑的组件Componet
 * 	
 * 		数据流(Stream)
 * 
 * 数据流是Strom中最核心的抽象概念,一个数据流指的是在分布式环境中并行创建,处理的一组元组tuple的无界序列数据流可以由一种能够表述数据流中表述的域field的模式来定义
 * tuple中包含有 Integer,Long,Short,Byte,Float,Double,Boolean以及字节数组等基本类型对象,当然你也可以通过定义可序列化的对象来实现自定义的元组类型
 * 在声明数据流的时候需要给Stream定义一个有效的id,不过,由于在实际应用中最多的还是单一数据流的Spout与Bolt,这种场景下不需要使用id来区分数据流,因此可以直接使用OutputFieldDeclarer来定义无id的数据流
 * 
 * 		数据源 Spout
 * 
 * 	数据源（Spout）是拓扑中数据流的来源。一般 Spout 会从一个外部的数据源读取元组然后将他们发送到拓扑中。
 * 根据需求的不同，Spout 既可以定义为可靠的数据源，也可以定义为不可靠的数据源。一个可靠的 Spout 
 * 能够在它发送的元组处理失败时重新发送该元组，以确保所有的元组都能得到正确的处理；相对应的，不可靠的 Spout 就不会在元组发送之后对元组进行任何其他的处理。
 * 
 * 一个 Spout 可以发送多个数据流。为了实现这个功能，可以先通过 OutputFieldsDeclarer 的 declareStream 方法来声明定义不同的数据流，
 * 然后在发送数据时在 SpoutOutputCollector 的 emit 方法中将数据流 id 作为参数来实现数据发送的功能。
 * 
 * nextTuple 要么会向拓扑中发送一个新的元组，要么会在没有可发送的元组时直接返回。需要特别注意的是，由于 Storm 是在同一个线程中调用所有的 Spout 方法，
 * nextTuple 不能被 Spout 的任何其他功能方法所阻塞，否则会直接导致数据流的中断
 * 阿里的 JStorm 修改了 Spout 的模型，使用不同的线程来处理消息的发送，这种做法有利有弊，好处在于可以更加灵活地实现 Spout，坏处在于系统的调度模型更加复杂
 * Spout 中另外两个关键方法是 ack 和 fail，他们分别用于在 Storm 检测到一个发送过的元组已经被成功处理或处理失败后的进一步处理.ack 和 fail 方法仅仅对上述“可靠的” Spout 有效。
 *
 * 		数据流处理组件 Bolt
 * 拓扑中所有的数据均是由Bolt完成的 通过数据过滤filtering,函数处理function,聚合aggregations,联结join,数据流交互等功能,Bolt几乎能够完成任何一种数据处理需求
 * 一个Bolt可以实现简单的数据流转换,而更复杂的数据流交换通常需要多个Bolt并通过多个步骤完成,例如将一个微博数据流转化成一个趋势图像的数据流至少包含两个步骤:
 * 其中一个Bolt用于对每个图片的微博转发进行滚动记数,另一个或多个Bolt将数据流输出为"转发最多的图片"结果
 * 与SPout相同,Bolt也可以输出多个数据流,为了实现这个功能,可以通过OutputFieldDeclarer的declarerStream方法来声明定义不同的数据流
 * 然后在发送数据是在OutputCollector的emit方法中将数据流id作为参数来实现数据发送的功能
 * 在定义Bolt的输出数据流时,你需要从其他的Storm组件中订阅指定的数据流,如果你需要从其他的组件中订阅数据楼=流,你就必须要在定义Bolt时分别注册每一个组件
 * 如果需要订阅来自组件"1"的数据流,declarer.shuffleGrouping("1")与declarer.shuffleGrouping("1",DEFAULT_STREAM_ID)两种声明方式是等价的
 * 
 * Bolt的关键方法是execute方法,execute方法负责接收一个元组作为输出,并且使用OutputCollector对象发送新的元组
 * 如果有消息可靠性保障的需求,Bolt必须为他所处理的每个元组调动OutputCollector的ack方法,以便Storm能够了解元组是否处理完成
 * 一般情况下,在处理之后可以根据需要选择不发送还是发送多个新元组,然后再响应ack输入元组 IBasicBolt接口能够实现元组的自动应答
 * 
 * 		数据流分组 Stream grouping
 * 
 * 为拓扑中的每个Bolt的确定输入数据流是定义一个拓扑的重要环节,数据流分组定义了再Bolt不同任务中划分数据流的方式
 * 在Strom中有八种内置的数据流分组方式,你还可以通过CustomStreamGrouping接口实现自定义的数据流分组模型,这八种分组分别为:
 * 	1.随机分组(shuffle grouping):这种方式下元组会被尽可能随机分配到Bolt的不同任务tasks中,使得每个任务所处理元组数量能够保持基本一致,以确保集群的负载均衡
 * 	2.域分组(Fields grouping):这种方式下数据流根据定义地 "域"来进行分组.例如,如果某个数据流是基于一个名为"user-id"的域进行分组的,那么所有包含相同的"user-id"的元组都会被分配到同一个任务中,这样就可以确保消息处理的一致性
 * 	3.部分关键字分组(Partial key grouping):这种方式与域分组很相似,根据定义的域来对数据流进行分组,不同的是,这种方式会考虑由Bolt数据处理的均衡问题,在输入数据源关键字不平衡时会有更好的性能
 * 	4.完全分组(All grouping):这种方式下数据流会被同时发送到Bolt的所有任务中,(也就是同一个元组会被复制多份然后被所有的任务处理)
 *	5.全局分组(Global grouping):这种方式会将所有的数据流都分发送到Bolt的同一个任务中,也就是id最小的那个任务
 *	6.非分组(None grouping): 使用这个方式说明你不关心数据流如何分组.目前这种方式的结果与随机分组完全等效
 *	7.直接分组(Direct grouping):这是一个特殊的分组方式.使用这个方式意味着元组的发送者可以指定下游的那个任务可以接收这个元组.只有在数据流被声明为直接数据流时才能使用直接分组方式
 *	使用直接数据流发送元组需要使用OutputCollector的一个emit方法(该方法会返回他所发送元组的目标任务的id)来获取任务的id
 *	8.本地或随机分组(Local or shuffle grouping) :如果在源组件的worker进程里目标Bolt有一个或更多的任务线程,元组会被随机分配到那些同进程的任务中
 * 
 * 		可靠性Reliability
 * 		
 * 		Storm可以通过拓扑来确保每个发送的元组都能得到正确的处理,通过跟踪由Spout发出的每个元组构成的元组树可以确定元组是否已经完成处理,每个拓扑都有一个"消息延时"参数,如果Storm在延时时间内没有检测到是否处理完成,就会将该元组标记为处理失败,并在稍后重新发送该元组
 * 为了充分利用 Storm 的可靠性机制，你必须在元组树创建新结点的时候以及元组处理完成的时候通知 Storm。这个过程可以在 Bolt 发送元组时通过 OutputCollector 实现：在 emit 方法中实现元组的锚定（Anchoring），同时使用 ack 方法表明你已经完成了元组的处理。
 * 		
 * 		任务 	Task
 * topology是在一个或多个worker process中运行的,每个工作进程都是一个实际的JVM,并且执行topology的一个子集
 * 
 * 		
 * 
 * @author wangpx    
 */
package com.wpx.storm;