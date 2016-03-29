package com.spider;
import org.apache.commons.httpclient.*;
import java.net.URL;
import java.util.Set;
/**
 * <p>Title: Spider Demo</p>
 * <p>Description: </p>
 * @author LiXueDong
 * @date 2016-3-28
 */
public class Spider {
	 
	 /** 
	* @Title: initSpider 
	* @Description: TODO() 
	* @param: @param seeds     
	* @return: void    返回类型 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 下午1:47:39
	*/
	private void initSpider(String[] seeds)
	 {
		System.out.println("spider start ----------------------------------------");
		for(int i = 0; i < seeds.length; i++){
			UrlPool.inQueue(seeds[i]);
		} 
	 }
	
	/** 
	* <p>Title: </p> 
	* <p>Description: </p>  
	*/
	public Spider(String[] seeds)
	{
		initSpider(seeds);
		UrlQueue queue = UrlPool.getQueue();
		while(UrlPool.queueNum() > 0 && UrlPool.queueNum() < 1000)
		{
			String visitLink = UrlPool.outQueue();
			if(visitLink == null)
				continue;
			DownLoadPage down = new DownLoadPage();
			String fileName = down.downLoadPage(visitLink);
			UrlParse parse = new UrlParse();
			Set<String> links = parse.parseHtml(fileName);
			for(String s:links){
				if( !UrlPool.contains(s))
					UrlPool.inQueue(s);
			}
		}
	}
	public static void main(String[] args) {
		String[] seeds = {"http://www.acfun.tv"};
		Spider s = new Spider(seeds);
	}
}
