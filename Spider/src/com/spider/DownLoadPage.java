package com.spider;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.httpclient.DefaultMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;


/** 
* @ClassName: DownLoadPage 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author LiXueDong 
* @date 2016-3-29 上午9:37:31 
*  
*/
/** 
* @ClassName: DownLoadPage 
* @Description: TODO() 
* @author LiXueDong 
* @date 2016-3-29 上午11:38:56 
*  
*/
public class DownLoadPage {
	
	/** 
	* @Title: getFileName 
	* @Description: TODO(获取文件名称) 
	* @param: @param url
	* @param: @param contentType
	* @param: @return     设定文件 
	* @return: String    返回类型 
	* @throws:  
	* @date: 2016-3-29 上午10:47:42
	*/
	public String getFileName(String url,String contentType)
	{
		String fileName = "";
		if(contentType.contains("html"))	
			fileName = url.replaceAll("[\\?/:*|<>\"]", "_")+".html";
		else
			fileName = url.replaceAll("[\\?/:*|<>\"]", "_") + "." + contentType.substring(contentType.indexOf("/") + 1);
		return fileName;
	}
	
	/** 
	* @Title: downLoadPage 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param: @param url     设定文件 
	* @return: String    返回类型 
	* @throws:  
	* @date: 2016-3-29 上午10:49:06
	*/
	public String downLoadPage(String url)
	{
		String fileName = "";
		HttpClient httpClient = new HttpClient();
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		if(url.contains("http")){
			GetMethod getMethod = new GetMethod(url);
			getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
			getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultMethodRetryHandler());
			try{
				int statut = httpClient.executeMethod(getMethod);
				if(statut != HttpStatus.SC_OK){
					System.out.println("err -- 请求码问题");
				}else{
					byte[] content = getMethod.getResponseBody();
					String aa = getFileName(url, getMethod.getResponseHeader("Content-Type").getValue());
					fileName = "F:\\ben\\temp\\"+getFileName(url, getMethod.getResponseHeader("Content-Type").getValue());
					save2Local(content, fileName);
					System.out.println("save -- "+fileName);
				}
			}catch(HttpException e){
				System.out.println("err -- http" + e.getClass());
			}catch(IOException e){
				System.out.println("err -- IO" + e.getClass());
			}
		}
		return fileName;
	}
	

	/** 
	* @Title: save2Local 
	* @Description: TODO() 
	* @param: @param content
	* @param: @param path     
	* @return: void    返回类型 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 上午11:39:00
	*/
	public void save2Local(byte[] content,String path)
	{
		try{
		DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(path)));
		out.write(content);
		if(out != null )
			out.close();
		}catch(FileNotFoundException e){
			System.out.println("err -- fileNoFound" + e.getClass());
			e.printStackTrace();
		}catch(IOException e){
			System.out.println("err -- IO" + e.getClass());
		}
		
	}
}
