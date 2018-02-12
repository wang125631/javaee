package com.wpx.springmvc.demo08;


import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *文件上传
 * @author wangpx
 */
@Controller
@RequestMapping("/spring-mvc/demo08")
public class UploadTest {

	private static final String SUCCESS="success";
	
	@RequestMapping("/upload")
	public String upload(@RequestParam("filename") MultipartFile filename) throws IllegalStateException, IOException {
		if(!filename.isEmpty()) {
			filename.transferTo(new File("D:\\temp\\"+filename.getOriginalFilename()));
		}
		return SUCCESS;
	}
}
