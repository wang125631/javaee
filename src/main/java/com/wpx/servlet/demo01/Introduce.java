package com.wpx.servlet.demo01;
/**
 * 服务器
		* 网络的架构
			* C/S	客户端/服务器
				* 服务器压力小，如果客户端需要更新下载
			* B/S	浏览器/服务器
				* 服务器压力大，不用更新
				
		* 服务器概念
			* 硬件：一台电脑。
			* 软件：服务器的软件（Tomcat）
			* 访问：http://ip+端口号	找到主机
			
		* Tomcat服务器，免费的，apache组织，支持Servelt/JSP的规范。
		* 安装JDK，配置好环境变量。
		* 常见的启动的问题：
			* 环境变量没配置好。
			* 端口占用的问题。
				* 找到占用的程序，结束掉。
				* 修改端口号。（改成80）
				
		* Tomcat的文件夹
			* bin		启动服务器和关闭服务器
			* conf（*****）	配置文件
			* lib		Tomcat运行时jar包
			* temp		临时文件
			* logs		日志
			* webapps（*****）	web的应用们
			* work（*****）		JSP翻译Servlet
		
		* 动态的WEB资源
			* Servlet/JSP
			* 在服务器中有固定的目录结构
			* 在webapps目录下创建一个文件夹
			website
				|
			WEB-INF
				|
				web.xml		必须有的（配置文件）
				classes		文件夹（编译.class文件）
				lib			文件夹（第三方jar包）
  
   
    * HTTP的协议
		* 超文本传输协议：post请求，参数封装请求体中。做出响应，展示页面上内容，封装的响应体中。
			* 基于请求和响应模式，先有请求再有响应。
			* 默认端口号80
			* 基于TCP协议
			
		* HTTP/1.1和HTTP/1.0区别：
			* 1.1一次链接获取多个资源。
			* 1.0一次链接只能获取一个资源。
		
		* 请求
			* 请求行
				* 请求方式
					* get和post区别
				* 请求路径
				* 协议版本
					* HTTP/1.1版本
			* 请求头
				* if-modefied-since		和last-modefied 完成控制缓存。
				* referer				记住当前网页的来源
				* user-agent			查看浏览器的版本
			* 空行
			* 请求体
				* 封装post请求参数列表
				
	* 响应
			* 响应行
				* 协议版本
				* 状态码
					* 200		一起ok
					* 302		完成重定向操作
					* 304		if-modefied-since和last-modefied一起控制缓存
					* 404		找不到资源
					* 500		程序内部错误
				* 状态码描述
			* 响应头
				* Location		和302完成重定向
				* last-modefied	
				* refresh		页面定时刷新
				* Content-Dispostion	文件下载
					
					禁用浏览器的缓存。
				
			* 空行
			* 响应体
				* 展示用户的数据
==========================================================================================================
	* Servlet
		* 动态WEB的资源。
		* 什么是Servlet
			* 实现Servlet接口，重写5个方法。
			* Servlet是一个小的java程序，运行在服务器中，接收和响应从客户端（浏览器）发送过来的请求。
			
		
				
		* 编译
			* javac -d . HelloServlet.java
			* HelloServlet.java:4: 软件包 javax.servlet 不存在
			* set classpath=%classpath%;servlet-api.jar	设置临时的环境变量，只对当前的窗口有效。
			
 * @author wangpx
 */
public class Introduce {

}
