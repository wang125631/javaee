# javaee

demo01 -> js基础

	demo01.html -> js的动态/匿名函数
	demo02.html -> js的全局/局部
	demo03.html -> String对象
	demo04.html -> Array对象
	demo05.html -> Date日期对象
	demo06.html -> Math对象
	demo07.html -> 全局函数
	demo08.html -> Bom对象
	demo09.html -> window对象
	js闭包 : http://www.ruanyifeng.com/blog/2009/08/learning_javascript_closures.html
	
demo02 -> js操作dom

	demo01.html -> 获取dom节点
	demo02.html -> 创建dom节点
	demo03.html -> Element对象
	demo04.html -> Node对象
	demo05.html -> innerHTML
	demo06.html -> 全选/反选
	demo07.html -> 下拉列表左右添加
	demo08.html -> 省市二级联动

demo03 -> JQuery选择器

	demo01.html -> JQuery基础 
	demo02.html -> JQuery选择器--基本选择器
	demo03.html -> JQuery选择器--层次选择器
	demo04.html -> JQuery选择器--基本过滤选择器
	demo05.html -> JQuery选择器--内容过滤选择器 
	demo06.html -> JQuery选择器--可见性过滤选择器 
	demo07.html -> JQuery选择器--属性选择器
	demo08.html -> JQuery选择器--子元素选择器
	demo09.html -> JQuery选择器--表单对象属性过滤选择器
	demo10.html -> JQuery选择器--表单选择器

demo04 -> JQuery操作Dom

	demo01.html -> 查找节点
	demo02.html -> 创建节点
	demo03.html -> 内部插入节点
	demo04.html -> 外部插入节点
	demo05.html -> 删除节点
	demo06.html -> 复制节点
	demo07.html -> 替换节点
	demo08.html -> 样式操作
	demo09.html -> 遍历节点
	demo10.html -> 包裹节点
	
demo05 -> JQuery对ajax的支持   (此部分需在服务器环境下 maven下tomcat运行指令 tomcat7:run)

	demo01.html -> ajax方法的调用
	demo02.html -> 异步提交表单
	demo03.html -> get
	demo04.html -> getJSON
	demo05.html -> load方法的调用
	demo06.html -> post方法的调用
	demo07.html -> getScript

------------------------------------------专题/框架类--------------------------------------------------

jdbc

	jdbc.demo01	-> sql简介/数据库的CRUD(增删改查)
	jdbc.demo02	-> 数据库表的CRUD
	jdbc.demo03	-> 表数据的CRUD
	jdbc.demo04	-> 多表操作
	SQL Join  https://segmentfault.com/a/1190000000454332
	jdbc.demo05	-> java操作数据库
		Emp    -> 封装的实体类
		Demo01 -> 连接数据库进行查询
		Demo02 -> 通过prepareStatement插入数据
		Demo03 -> 修改数据
		Demo04 -> 删除操作
		JdbcUtils -> jdbc简单封装
	jdbc.demo06	-> mysql事务
	jdbc.demo07	-> jdbc事务处理

Servlet(Servlet部分需要修改web.xml)

	servlet.demo01 -> Tomcat/服务器简介
	servlet.demo02 -> 第一个前后端交互案例
	servlet.demo03 -> Servlet接口
	servlet.demo04 -> GenericServlet 
	servlet.demo05 -> 初始化参数 
	servlet.demo06 -> ServletConfig对象
	servlet.demo07 -> 通过servlet进行页面跳转
	servlet.demo08 -> 通过servlet进行定时页面跳转
	servlet.demo09 -> 统计网站访问次数
	servlet.demo10 -> Request常用API
	servlet.demo11 -> 用户登录功能模拟
	servlet.demo12 -> 重定向和转发
	servlet.demo13 -> 中文乱码
	servlet.demo14 -> 禁止缓存
	servlet.demo15 -> 文件下载
	servlet.demo16 -> 验证码
	servlet.demo17 -> 用户追踪之--Session
	servlet.demo18 -> 用户追踪之--Cookie
	servlet.demo19 -> EL表达式
	servlet.demo20 -> jstl标签
	servlet.demo21 -> 客户信息分页查询
	servlet.demo22 -> Listener
	servlet.demo23 -> Filter

struts2
	
	struts2.demo01 -> Hello Struts2
	struts2.demo02 -> 成为Action的三种方式
	struts2.demo03 -> 获取参数的三种方式
	struts2.demo04 -> 类型转化
	struts2.demo05 -> 数据校验
	struts2.demo06 -> 国际化
	struts2.demo07 -> 拦截器
	struts2.demo08 -> 文件的上传和下载
	struts2.demo09 -> ognl/ValueStack
	struts2.demo10 -> 防止表单重复提交

spring
	
	spring.demo01 -> spring加载配置文件
	spring.demo02 -> Bean的实例化
	spring.demo03 -> Bean的作用范围
	spring.demo04 -> Bean的生命周期
	spring.demo05 -> SpEL
	spring.demo06 -> spring集合注入
	spring.demo07 -> spring注解
	spring.demo08 -> @Configuration
	spring.demo09 -> JDK代理
	spring.demo10 -> cglib代理
	spring.demo11 -> 前置增强
	spring.demo12 -> 环绕通知
	spring.demo13 -> 自动生成代理
	spring.demo14 -> 切面类/aspectj
	spring.demo15 -> aspect通过xml配置
	spring.demo16 -> JdbcTemplate
	spring.demo17 -> JdbcDaoSupport
	spring.demo18 -> TransactionTemplate/手动编码
	spring.demo19 -> 配置生成事务代理对象/原始的声明式事务
	spring.demo20 -> 声明式事务管理(自动代理/基于切面)
	spring.demo21 -> 基于注解的事务管理
	
	
hibernate
	
	hibernate.demo01 -> Hibernate实现增删改查
	hibernate.demo02 -> get/load及配置说明
	hibernate.demo03 -> 三种持久化对象的状态/工具类封装
	hibernate.demo04 -> Hibernate的缓存 
	hibernate.demo05 -> Hibernate关系映射---一对多
	hibernate.demo06 -> Hibernate关系映射---多对多
	hibernate.demo07 -> Hibernate关系映射---一对一
	hibernate.demo08 -> Hibernate的数据检索/检索优化	
	
	
springmvc 
	
	spring.demo01 -> springmvc的HelloWorld
	spring.demo02 -> springMVC的工作流程
	spring.demo03 -> springMVC的PathVariable注解
	spring.demo04 -> RESTful的CRUD
	spring.demo05 -> springmvc常用注解说明
	spring.demo06 -> springmvc类型转换器

jvm

	jvm.demo01 -> GC信息  
	jvm.demo02 -> SurvivorRatio的配置说明
	jvm.demo03 -> 堆内存溢出
	jvm.demo04 -> 栈调用深度

	
threadpool
	
	threadpool.demo01 -> synchronized关键字 
	threadpool.demo02 -> volatile 关键字
	threadpool.demo03 -> wait/notify |模拟Blocking Queue
	threadpool.demo04 -> ThreadLocal
	threadpool.demo05 -> 同步/并发类容器
	threadpool.demo06 -> 并发的Queue
	threadpool.demo07 -> Master-Worker模式
	threadpool.demo08 -> Executors创建线程池/自定义线程池
	
netty
	
	netty.demo01 -> 传统的BIO
	netty.demo02 -> 伪异步的BIO
	netty.demo03 -> 非阻塞的NIO
	netty.demo04 -> 异步非阻塞的AIO
	netty.demo05 -> 使用Netty实现简单通讯
	netty.demo06 -> Netty中粘/拆包问题(行分隔,自定义分隔,固定长度)
	netty.demo07 -> Netty中编/解码问题
	netty.demo08 -> Netty心跳检测
	netty.demo09 -> Netty文件上传
	netty.demo10 -> Netty文件下载
	
linux
	
	linux.demo01 -> linux常用命令
	linux.demo02 -> activemq搭建
	linux.demo03 -> 
	linux.demo04 -> 
	linux.demo05 -> 
	linux.demo06 -> 
	linux.demo07 -> 
	
	