/**   
* @Title: UrlQueue.java 
* @Package com.spider 
* @Description: TODO(用一句话描述该文件做什么) 
* @author LiXueDong   
* @date 2016-3-29 上午10:50:59 
* @version V1.0   
*/
package com.spider;

import java.util.LinkedList;

/** 
 * @ClassName: UrlQueue 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author LiXueDong 
 * @date 2016-3-29 上午10:50:59 
 *  
 */
public class UrlQueue {
	
	/** 
	* @Fields urlQueue : TODO() 
	*/
	private LinkedList<String> urlQueue = new LinkedList<String>();
	
	/** 
	* @Title: inQueue 
	* @Description: TODO(入队) 
	* @param: @param url     
	* @return: void    返回类型 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 上午10:54:38
	*/
	public void inQueue(String url)
	{
		urlQueue.addFirst(url);
	}
	
	/** 
	* @Title: outQueue 
	* @Description: TODO(出队) 
	* @param: @return     
	* @return: String    返回类型 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 上午10:59:05
	*/
	public String outQueue()
	{
		return urlQueue.removeLast();
	}
	
	/** 
	* @Title: queueNum 
	* @Description: TODO(队列长度) 
	* @param: @return     
	* @return: int    返回类型 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 上午11:02:58
	*/
	public int queueNum()
	{
		return urlQueue.size();
	}
	
	/** 
	* @Title: queueIsEmpty 
	* @Description: TODO(判断队列是否为空) 
	* @param: @return     
	* @return: boolean    返回类型 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 上午11:04:09
	*/
	public boolean queueIsEmpty()
	{
		return urlQueue.isEmpty();
	}
	
	/** 
	* @Title: contains 
	* @Description: TODO(判断队列是否包含该元素) 
	* @param: @param url
	* @param: @return     
	* @return: boolean    返回类型 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 上午11:05:23
	*/
	public boolean contains(String url)
	{
		return urlQueue.contains(url);
	}
}
