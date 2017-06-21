/*
 *伏贵荣
 *2017/4/29
 * */
import java.util.*;
public class TestForeach {
	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add(new String("轻量级J2EE企业应用实战"));
		books.add(new String("Struts2权威指南"));
		books.add(new String("基于J2EE的AJAX宝典"));
		for(Object obj: books){
			String book = (String)obj;
			System.out.println(book);
			if(book.equals("Struts2权威指南")){
				books.remove(book);
				//这句话会引发异常：在使用foreach时也不能修改集合的值
				//这么说，foreach是不是不如iterator好？？最起码，它还可以remove
			}
			System.out.println("books");
		}
	}

}
