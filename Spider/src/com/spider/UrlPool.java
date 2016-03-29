/**   
* @Title: UrlPool.java 
* @Package com.spider 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author LiXueDong   
* @date 2016-3-29 ����11:06:07 
* @version V1.0   
*/
package com.spider;

import java.util.HashSet;
import java.util.Set;

/** 
 * @ClassName: UrlPool 
 * @Description: TODO(�����ŷ��ʹ���url�͹���urlQueue) 
 * @author LiXueDong 
 * @date 2016-3-29 ����11:06:07 
 *  
 */
public class UrlPool {
	/** 
	* @Fields urlPool : TODO() 
	*/
	private static Set<String> urlPool = new HashSet<String>();
	
	/** 
	* @Fields urlQueue : TODO() 
	*/
	private static UrlQueue urlQueue = new UrlQueue();
	
	/** 
	* @Title: getQueue 
	* @Description: TODO() 
	* @param: @return     
	* @return: UrlQueue    �������� 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 ����11:10:25
	*/
	public static UrlQueue getQueue()
	{
		return urlQueue;
	}
	
	/** 
	* @Title: addPool 
	* @Description: TODO() 
	* @param: @param url     
	* @return: void    �������� 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 ����11:14:20
	*/
	public static void addPool(String url)
	{
		System.out.println("in pool --- " + url);
		urlPool.add(url);
	}
	
	/** 
	* @Title: removePool 
	* @Description: TODO() 
	* @param: @param url     
	* @return: void    �������� 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 ����11:15:47
	*/
	public static void removePool(String url){
		System.out.println("remove pool --- " + url);
		urlPool.remove(url);
	}
	
	/** 
	* @Title: poolIsEmpty 
	* @Description: TODO() 
	* @param: @return     
	* @return: boolean    �������� 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 ����11:16:22
	*/
	public static boolean poolIsEmpty()
	{
		return urlPool.isEmpty();
	}
	
	/** 
	* @Title: contains 
	* @Description: TODO() 
	* @param: @param url
	* @param: @return     
	* @return: boolean    �������� 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 ����11:17:14
	*/
	public static boolean contains(String url)
	{
		return urlPool.contains(url);
	}
	
	// ��ʼ����Զ��еĹ���
	
	/** 
	* @Title: inQueue 
	* @Description: TODO() 
	* @param: @param url     
	* @return: void    �������� 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 ����11:23:59
	*/
	public static void inQueue(String url)
	{
		if(!urlPool.contains(url) && url != null && !url.trim().equals(""))
			System.out.println("in queue --- " + url);
			urlQueue.inQueue(url);
	} 
	
	/** 
	* @Title: outQueue 
	* @Description: TODO() 
	* @param: @return     
	* @return: String    �������� 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 ����11:28:10
	*/
	public static String outQueue()
	{
		System.out.println("out queue --- ");
		return urlQueue.outQueue();
	}
	
	/** 
	* @Title: queueNum 
	* @Description: TODO() 
	* @param: @return     
	* @return: int    �������� 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 ����11:30:20
	*/
	public static int queueNum()
	{
		return urlQueue.queueNum();
	}
	
	/** 
	* @Title: queueIsEmpty 
	* @Description: TODO() 
	* @param: @return     
	* @return: boolean    �������� 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 ����11:31:01
	*/
	public static boolean queueIsEmpty()
	{
		return urlQueue.queueIsEmpty();
	}
	
	/** 
	* @Title: queueContains 
	* @Description: TODO() 
	* @param: @param url
	* @param: @return     
	* @return: boolean    �������� 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 ����11:32:00
	*/
	public static boolean queueContains(String url)
	{
		return urlQueue.contains(url);
	}
}
