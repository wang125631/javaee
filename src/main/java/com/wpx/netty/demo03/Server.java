package com.wpx.netty.demo03;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 服务端类
 * 
 * @author wangpx
 */
public class Server implements Runnable{

	//多路复用器(管理所有的通道)
	private Selector selector;
	//建立缓冲区
	private ByteBuffer readBuf = ByteBuffer.allocate(1024);
	private ByteBuffer writeBuf = ByteBuffer.allocate(1024);
	
	public Server(int port) {
		try {
			//1. 打开多路复用器
			this.selector = Selector.open();
			//2. 打开服务器通道
			ServerSocketChannel ssc = ServerSocketChannel.open();
			//3. 设置服务器通道为非阻塞模式
			ssc.configureBlocking(false);
			//4. 绑定地址
			ssc.bind(new InetSocketAddress(port));
			//5. 将服务器通道注册到多路复用器上,并监听阻塞事件
			ssc.register(this.selector, SelectionKey.OP_ACCEPT);
			System.out.println("Server start , Port :"+port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		while(true) {
			try {
				//让多路复用器开始监听
				this.selector.select();
				//返回所有的Selector的key返回迭代集
				Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
				//进行遍历
				while(keys.hasNext()) {
					//获取一个选择的元素
					SelectionKey key = keys.next();
					//从容器中移除
					keys.remove();
					//如果是有效的 对不同的情况进行不同的处理
					if(key.isValid()) {
						//如果是阻塞的
						if(key.isAcceptable()) {
							this.accept(key);
						}
						//如果是可读状态
						if(key.isReadable()) {
							this.read(key);
						}
						//如果为可写
						if(key.isWritable()) {
							this.write(key);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	private void write(SelectionKey key) {
	
		
	}

	private void read(SelectionKey key) {
		try {
			//清空缓存区的数据
			this.readBuf.clear();
			//获取之前注册的Socket对象
			SocketChannel sc=(SocketChannel) key.channel();
			//读取数据
			int count = sc.read(this.readBuf);
			if(count == -1) {
				key.channel().close();
				key.cancel();
				return;
			}
			//有数据则读取,读取之前需要进行复位方法
			this.readBuf.flip();
			//根据缓存区的数据长度创建相应大小byte数组,接受缓冲区的数据
			byte[] bytes = new byte[this.readBuf.remaining()];
			this.readBuf.get(bytes);
			//打印结果
			String body=new String(bytes).trim();
			System.out.println("客户端发送的数据为   "+body);
		} catch (Exception e) {
			
		}
		
	}

	private void accept(SelectionKey key) {
		try {
			//获取服务通道
			ServerSocketChannel ssc=(ServerSocketChannel) key.channel();
			//执行阻塞方法
			SocketChannel sc = ssc.accept();
			//设置阻塞模式
			sc.configureBlocking(false);
			//注册到多路复用器上,并设置读取标识
			sc.register(this.selector,SelectionKey.OP_READ);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new  Thread(new Server(8888)).start();;
	}

}
