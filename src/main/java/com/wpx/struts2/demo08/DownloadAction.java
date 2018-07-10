package com.wpx.struts2.demo08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class DownloadAction extends ActionSupport{

	private String filename; //要下载的文件的名称

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	//设置下载文件mimeType类型
	
	public String getContentType() {
		String mimeType = ServletActionContext.getServletContext().getMimeType(filename);
		System.out.println(mimeType);
		return mimeType;
	}
	
	// 获取下载文件名称
	public String getDownloadFileName() throws UnsupportedEncodingException {
		filename = URLEncoder.encode(filename,"utf-8");
		return filename;	
	}
	
	public InputStream getInputStream() throws UnsupportedEncodingException, FileNotFoundException {
		filename = new String(filename.getBytes("iso8859-1"),"utf-8");
		System.out.println(filename);
		FileInputStream fis = new FileInputStream(new File("D:/upload",filename));
		return fis;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("文件下载中...");
		return SUCCESS;
	}
	
}
