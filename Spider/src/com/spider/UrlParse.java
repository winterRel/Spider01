/**   
* @Title: UrlParse.java 
* @Package com.spider 
* @Description: TODO(用一句话描述该文件做什么) 
* @author LiXueDong   
* @date 2016-3-29 上午11:32:13 
* @version V1.0   
*/
package com.spider;

import java.util.HashSet;
import java.util.Set;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;


/** 
 * @ClassName: UrlParse 
 * @Description: TODO(分析url) 
 * @author LiXueDong 
 * @date 2016-3-29 上午11:32:13 
 *  
 */
public class UrlParse {
	private Set<String> links = new HashSet<String>();
	

	/** 
	* @Title: parseHtml 
	* @Description: TODO() 
	* @param: @param path
	* @param: @return     
	* @return: Set<String>    返回类型 
	* @throws:  
	* @author: LiXueDong
	* @date: 2016-3-29 下午1:43:33
	*/
	public Set<String> parseHtml(String path)
	{
		NodeFilter nodeFilter = new NodeFilter() {
			
			@Override
			public boolean accept(Node n) {
				// TODO Auto-generated method stub
				if(n.getText().startsWith("fram src=")){
					return true;
				}else{
					return false;
				}
			}
		};
		
		NodeFilter tagFilter = new NodeClassFilter(LinkTag.class);
		OrFilter orFilter = new OrFilter(nodeFilter,tagFilter);
		try{
			Parser parser = new Parser(path);
			NodeList nodeList = parser.extractAllNodesThatMatch(orFilter);
			if(nodeList != null){
				for(int i = 0; i < nodeList.size(); i++){
					Node n = nodeList.elementAt(i);
					if(n instanceof LinkTag ){
						links.add(((LinkTag)n).getLink());
					}else{
						String frame = n.getText();
						int start = frame.indexOf("src=");
						frame = frame.substring(start);
						int end = frame.indexOf(">");
						if(end == -1)
							end = frame.indexOf(" ");
						frame = frame.substring(start,end - 1);
						
					}
				}
			}
		}catch(ParserException e){
			System.out.println("err -- parserHtml");
		}
		return links;
	}
}
