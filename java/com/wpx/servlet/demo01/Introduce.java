package com.wpx.servlet.demo01;
/**
 * ������
		* ����ļܹ�
			* C/S	�ͻ���/������
				* ������ѹ��С������ͻ�����Ҫ��������
			* B/S	�����/������
				* ������ѹ���󣬲��ø���
				
		* ����������
			* Ӳ����һ̨���ԡ�
			* ��������������������Tomcat��
			* ���ʣ�http://ip+�˿ں�	�ҵ�����
			
		* Tomcat����������ѵģ�apache��֯��֧��Servelt/JSP�Ĺ淶��
		* ��װJDK�����úû���������
		* ���������������⣺
			* ��������û���úá�
			* �˿�ռ�õ����⡣
				* �ҵ�ռ�õĳ��򣬽�������
				* �޸Ķ˿ںš����ĳ�80��
				
		* Tomcat���ļ���
			* bin		�����������͹رշ�����
			* conf��*****��	�����ļ�
			* lib		Tomcat����ʱjar��
			* temp		��ʱ�ļ�
			* logs		��־
			* webapps��*****��	web��Ӧ����
			* work��*****��		JSP����Servlet
		
		* ��̬��WEB��Դ
			* Servlet/JSP
			* �ڷ��������й̶���Ŀ¼�ṹ
			* ��webappsĿ¼�´���һ���ļ���
			website
				|
			WEB-INF
				|
				web.xml		�����еģ������ļ���
				classes		�ļ��У�����.class�ļ���
				lib			�ļ��У�������jar����
  
   
    * HTTP��Э��
		* ���ı�����Э�飺post���󣬲�����װ�������С�������Ӧ��չʾҳ�������ݣ���װ����Ӧ���С�
			* �����������Ӧģʽ����������������Ӧ��
			* Ĭ�϶˿ں�80
			* ����TCPЭ��
			
		* HTTP/1.1��HTTP/1.0����
			* 1.1һ�����ӻ�ȡ�����Դ��
			* 1.0һ������ֻ�ܻ�ȡһ����Դ��
		
		* ����
			* ������
				* ����ʽ
					* get��post����
				* ����·��
				* Э��汾
					* HTTP/1.1�汾
			* ����ͷ
				* if-modefied-since		��last-modefied ��ɿ��ƻ��档
				* referer				��ס��ǰ��ҳ����Դ
				* user-agent			�鿴������İ汾
			* ����
			* ������
				* ��װpost��������б�
				
	* ��Ӧ
			* ��Ӧ��
				* Э��汾
				* ״̬��
					* 200		һ��ok
					* 302		����ض������
					* 304		if-modefied-since��last-modefiedһ����ƻ���
					* 404		�Ҳ�����Դ
					* 500		�����ڲ�����
				* ״̬������
			* ��Ӧͷ
				* Location		��302����ض���
				* last-modefied	
				* refresh		ҳ�涨ʱˢ��
				* Content-Dispostion	�ļ�����
					
					����������Ļ��档
				
			* ����
			* ��Ӧ��
				* չʾ�û�������
==========================================================================================================
	* Servlet
		* ��̬WEB����Դ��
		* ʲô��Servlet
			* ʵ��Servlet�ӿڣ���д5��������
			* Servlet��һ��С��java���������ڷ������У����պ���Ӧ�ӿͻ��ˣ�����������͹���������
			
		
				
		* ����
			* javac -d . HelloServlet.java
			* HelloServlet.java:4: ������ javax.servlet ������
			* set classpath=%classpath%;servlet-api.jar	������ʱ�Ļ���������ֻ�Ե�ǰ�Ĵ�����Ч��
			
 * @author wangpx
 */
public class Introduce {

}