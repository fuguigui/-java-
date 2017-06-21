/*
 *伏贵荣
 *2017/4/29
 * */
import java.util.*;
public class TestIterator {
	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("轻量级J2EE企业应用实战");
		books.add("Struts2权威指南");
		books.add("基于J2EE的AJAX宝典");
		//获取books集合对应的迭代器
		Iterator it = books.iterator();
		while(it.hasNext()){
			String book = (String)it.next();
			System.out.println(book);
			if(book.equals("Struts2权威指南")){
				it.remove();
				//若将此句改为books.remove(book);则会引发异常。不能在
				//使用iterator迭代过程中，修改集合元素
				
				System.out.println("已删除");
			}
			book = "测试字符串";
			//集合元素并不会改变，这说明迭代器是把集合元素的值传给了变量，而不是本身
			//集合元素的顺序与添加时不同
		}
		System.out.println(books);
	}
}
