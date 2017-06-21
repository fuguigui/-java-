import java.util.Arrays;
import java.util.regex.*;
public class TestExpress {
	public static void main(String[] args) {
		
		//��ϰʹ��Find group
		System.out.println("------��ϰfind group--------");
		Matcher m1 = Pattern.compile("\\w+").matcher("Java is very easy!");
		while(m1.find()){//find�����Ƿ����ƥ����Ӵ��������ѭ����֪������find����Ĭ�ϴ���һ�ν�����λ�ÿ�ʼ
			System.out.println(m1.group());
			//group������һ��ƥ����Ӵ�������˵�����ǡ���һ�Ρ�ƥ�䣬��Ϊ��ʱ��m1���и������ָ���Ѿ��ڴ��ַ��������ˡ�
		}
		int i=0;
		while(m1.find(i)){
			System.out.println(m1.group()+"\t");
			i++;
		}
		
		//��ϰʹ��start end
		System.out.println("------��ϰstart end--------");
		String regStr = "Java is very easy";
		System.out.println("Ŀ���ַ����� "+regStr);
		Matcher m2 = Pattern.compile("\\w+").matcher(regStr);
		while(m2.find()){
			System.out.println(m2.group()+" ����ʼλ���ǣ�"+m2.start()+" ����λ���ǣ� "+m2.end());
			//���Կ���end���ص��ǽ���λ��+1
		}
		
		
		//��ϰʹ��matches��reset
		System.out.println("------��ϰmatches reset-------");
		String[] mails = {
				"fgr079@126.com","qkhhhh@163.com","loloc@google.cn","wawa@abc.xx"
		};
		String mailRegEx = "\\w{3,20}@\\w+\\.(com|cn|org|net|gov)";
		Pattern mailPattern = Pattern.compile(mailRegEx);
		Matcher matcher = null;
		for(String mail:mails){
			/*
			if(matcher == null){
				matcher = mailPattern.matcher(mail);
			}
			else matcher.reset(mail);
			if(matcher.matches())
				System.out.println(mail+"��һ����Ч�ĵ�ַ��");
			else System.out.println(mail+"��һ����Ч�ĵ�ַ��");*/
			
			//��˵����ֱ��ʹ��String��ƥ��������ʽ
			if(mail.matches(mailRegEx))System.out.println(mail+": ��Ч��");
			else System.out.println(mail+": ��Ч��");
			//���ֱȵ�һ�ַ������
		}
		
		
		//��ϰʹ���滻���и��
		System.out.println("------��ϰreplaceAll,split--------");
		String[] msgs = {"this sentence includes words starting with in",
				"I am in the Yuanpei Study room",
				"Monkey Pumpkin King a story i made up"
				};
		String msgRegEx1 = "in\\w+";
		for(String msg : msgs){
			System.out.println(msg.replaceAll(msgRegEx1, "����\2"));
		}
		String msgRegEx2 = "in\\w*";
		for(String msg : msgs){
			System.out.println(msg.replaceAll(msgRegEx2, "����\2"));
			System.out.println(Arrays.toString(msg.split(" ")));
		}
	}
}
