package com.wpx.struts2.demo08;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 文件上传的Action
 * 
 * myFile为文件上传页面的file的name
 * 三个参数分别为
 * 
 * file fileContentType fileFilename
 * 
 * @author wangpx
 */
public class UploadAction extends ActionSupport {

	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	
	private static final long serialVersionUID = 1L;

	
	public File getMyFile() {
		return myFile;
	}


	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}


	public String getMyFileContentType() {
		return myFileContentType;
	}


	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}


	public String getMyFileFileName() {
		return myFileFileName;
	}


	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}


	@Override
	public String execute() throws Exception {
		FileUtils.copyFile(myFile,new File("D:/upload",myFileFileName));
		return SUCCESS;
	}

	
}
