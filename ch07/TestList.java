import java.util.*;

public class TestList {
	public static void main(String[] args) {
		List books = new ArrayList();
		books.add(new String("Ӧ��ʵս"));
		books.add(new String("Ȩ��ָ��"));
		books.add(new String("����"));
		System.out.println(books);//����ʲô��ʽ�أ�
		
		books.add(1,new String("���ݿ���ʵս"));
		for(int i =0;i<books.size();++i){
			System.out.println(books.get(i));
		}
		
		books.remove(2);
		System.out.println(books);
		System.out.println(books.indexOf(new String("���ݿ���ʵս")));
		books.set(1, new String("Ȩ��ָ��2"));
		System.out.println(books);
		System.out.println(books.subList(1, 2));
	}

}
