/*
 *������
 *2017/4/29
 * */
import java.util.*;
public class TestForeach {
	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add(new String("������J2EE��ҵӦ��ʵս"));
		books.add(new String("Struts2Ȩ��ָ��"));
		books.add(new String("����J2EE��AJAX����"));
		for(Object obj: books){
			String book = (String)obj;
			System.out.println(book);
			if(book.equals("Struts2Ȩ��ָ��")){
				books.remove(book);
				//��仰�������쳣����ʹ��foreachʱҲ�����޸ļ��ϵ�ֵ
				//��ô˵��foreach�ǲ��ǲ���iterator�ã��������룬��������remove
			}
			System.out.println("books");
		}
	}

}
