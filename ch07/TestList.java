import java.util.*;

public class TestList {
	public static void main(String[] args) {
		List books = new ArrayList();
		books.add(new String("应用实战"));
		books.add(new String("权威指南"));
		books.add(new String("宝典"));
		System.out.println(books);//会是什么形式呢？
		
		books.add(1,new String("敏捷开发实战"));
		for(int i =0;i<books.size();++i){
			System.out.println(books.get(i));
		}
		
		books.remove(2);
		System.out.println(books);
		System.out.println(books.indexOf(new String("敏捷开发实战")));
		books.set(1, new String("权威指南2"));
		System.out.println(books);
		System.out.println(books.subList(1, 2));
	}

}
