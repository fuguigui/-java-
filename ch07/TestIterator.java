/*
 *������
 *2017/4/29
 * */
import java.util.*;
public class TestIterator {
	public static void main(String[] args) {
		Collection books = new HashSet();
		books.add("������J2EE��ҵӦ��ʵս");
		books.add("Struts2Ȩ��ָ��");
		books.add("����J2EE��AJAX����");
		//��ȡbooks���϶�Ӧ�ĵ�����
		Iterator it = books.iterator();
		while(it.hasNext()){
			String book = (String)it.next();
			System.out.println(book);
			if(book.equals("Struts2Ȩ��ָ��")){
				it.remove();
				//�����˾��Ϊbooks.remove(book);��������쳣��������
				//ʹ��iterator���������У��޸ļ���Ԫ��
				
				System.out.println("��ɾ��");
			}
			book = "�����ַ���";
			//����Ԫ�ز�����ı䣬��˵���������ǰѼ���Ԫ�ص�ֵ�����˱����������Ǳ���
			//����Ԫ�ص�˳�������ʱ��ͬ
		}
		System.out.println(books);
	}
}
