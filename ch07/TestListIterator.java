import java.util.*;

public class TestListIterator {
public static void main(String[] args) {
	String []books = {
			"Ȩ��ָ��","Ӧ��ʵս"
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
		lit.add("------�ָ���---------");
		System.out.println(lit);//Q1
	}
	System.out.println(bookList);
	System.out.println("--------�������-----------");
	while(lit.hasPrevious()){
		System.out.println(lit.previous());
	}
	//��1�����ʵ�ֵ�������ǰ�ƶ��ģ�����lit.previous()֮��lit���Զ���ǰ�ƶ���
	//Q1:������ʾ��litֵû�б䣬��ôlit����û�䣬��ʲô��������֪����ǰָ���Ǹ�ֵ�أ�
	
}
}
