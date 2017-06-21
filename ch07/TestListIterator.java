import java.util.*;

public class TestListIterator {
public static void main(String[] args) {
	String []books = {
			"权威指南","应用实战"
	};
	List bookList = new ArrayList();
	for(int i =0;i<books.length;i++){
		bookList.add(books[i]);
	}
	ListIterator lit = bookList.listIterator();
	System.out.println(lit);
	while(lit.hasNext()){
		System.out.println(lit);//Q1
		System.out.println(lit.next());//Q1
		lit.add("------分隔符---------");
		System.out.println(lit);//Q1
	}
	System.out.println(bookList);
	System.out.println("--------反向迭代-----------");
	while(lit.hasPrevious()){
		System.out.println(lit.previous());
	}
	//问1：如何实现迭代器向前移动的？调用lit.previous()之后，lit会自动向前移动？
	//Q1:代码显示，lit值没有变，那么lit本身没变，是什么东西让它知道当前指向那个值呢？
	
}
}
