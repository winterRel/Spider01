/**   
* @Title: UrlQueue.java 
* @Package com.spider 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author LiXueDong   
* @date 2016-3-29 ����10:50:59 
* @version V1.0   
*/
package com.spider;

import java.util.LinkedList;

/** 
 * @ClassName: UrlQueue 
 * @Description: TODO(������һ�仰��������������) 
 * @author LiXueDong 
 * @date 2016-3-29 ����10:50:59 
 *  
 */
public class UrlQueue {
	
	/** 
	* @Fields urlQueue : TODO() 
	*/
	private LinkedList<String> urlQueue = new LinkedList<String>();
	
	/** 
	* @Title: inQueue 
	* @Description: TODO(���) 
	* @param: @param url     
	* @return: void    �������� 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 ����10:54:38
	*/
	public void inQueue(String url)
	{
		urlQueue.addFirst(url);
	}
	
	/** 
	* @Title: outQueue 
	* @Description: TODO(����) 
	* @param: @return     
	* @return: String    �������� 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 ����10:59:05
	*/
	public String outQueue()
	{
		return urlQueue.removeLast();
	}
	
	/** 
	* @Title: queueNum 
	* @Description: TODO(���г���) 
	* @param: @return     
	* @return: int    �������� 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 ����11:02:58
	*/
	public int queueNum()
	{
		return urlQueue.size();
	}
	
	/** 
	* @Title: queueIsEmpty 
	* @Description: TODO(�ж϶����Ƿ�Ϊ��) 
	* @param: @return     
	* @return: boolean    �������� 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 ����11:04:09
	*/
	public boolean queueIsEmpty()
	{
		return urlQueue.isEmpty();
	}
	
	/** 
	* @Title: contains 
	* @Description: TODO(�ж϶����Ƿ������Ԫ��) 
	* @param: @param url
	* @param: @return     
	* @return: boolean    �������� 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 ����11:05:23
	*/
	public boolean contains(String url)
	{
		return urlQueue.contains(url);
	}
}
