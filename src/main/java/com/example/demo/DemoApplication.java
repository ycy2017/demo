package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
    @RequestMapping("/hello")
    String index(){
    	
      return "Hello Spring Boot";
    }
  
    
    @RequestMapping("/hello1")
    String hello1(){
    	
    	
      return "Hello Spring Boot";
    }
    
    
    @RequestMapping("/down")
    void down(HttpServletResponse response){
    	
    	 String realPath = "C:\\Users\\Administrator\\Desktop\\pdf\\1999may\\MATHEMATICAL-METHODS-SL-PAPER-1.pdf";//获取要下载的文件的绝对路径  
         String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);//获取要下载的文件名  
         //设置content-disposition响应头控制浏览器以下载的形式打开文件，中文文件名要使用URLEncoder.encode方法进行编码，否则会出现文件名乱码  
         try {
			response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
         InputStream in;
		try {
			in = new FileInputStream(realPath);
		   int len = 0;  
	         byte[] buffer = new byte[1024];  
	         OutputStream out = response.getOutputStream();  
	         while ((len = in.read(buffer)) > 0) {  
	             out.write(buffer,0,len);//将缓冲区的数据输出到客户端浏览器  
	         }  
	         in.close();  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    @RequestMapping("/downerror")
    void down1(HttpServletResponse response) throws FileNotFoundException{
    	 String realPath = "F:\\电影集\\[电影天堂www.dy2018.com]魁拔Ⅲ战神崛起HD国语中字.rmvb";//获取要下载的文件的绝对路径  
         String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);//获取要下载的文件名  
         //设置content-disposition响应头控制浏览器以下载的形式打开文件，中文文件名要使用URLEncoder.encode方法进行编码，否则会出现文件名乱码  
         InputStream in;
		try {
			
			in = new FileInputStream(realPath);
			response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
			int len = 0;  
	         byte[] buffer = new byte[1024];  
	         OutputStream out = response.getOutputStream();  
	         while ((len = in.read(buffer)) > 0) {  
	             out.write(buffer,0,len);//将缓冲区的数据输出到客户端浏览器  
	         }  
	         in.close();  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }
    
    
    
}
