import java.util.*;

public class TestCollection {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("�����");
		c.add(6);
		System.out.println("c���ϵ�Ԫ�ظ�����"+c.size());
		c.remove(6);
		System.out.println("c���ϵ�Ԫ�ظ�����"+c.size());
		System.out.println("c�����Ƿ����������ַ�����"+c.contains("�����"));
		c.add("������J2EE��ҵӦ��ʵս");
		System.out.println("c���ϵ�Ԫ�أ�"+c);
		
		Collection books = new HashSet();
		books.add("������J2EE��ҵӦ��ʵս");
		books.add("Struts2Ȩ��ָ��");
		System.out.println("c�����Ƿ���ȫ����books���ϣ�"+c.containsAll(books));
		System.out.println("books���ϵ�Ԫ�أ�"+books);
		c.removeAll(books);
		System.out.println("c���ϵ�Ԫ�أ�"+c);
		c.clear();
		System.out.println("c���ϵ�Ԫ�أ�"+c);
		books.retainAll(c);
		System.out.println("books���ϵ�Ԫ�أ�"+books);
		
		
	}

}
