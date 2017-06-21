import java.util.Arrays;
import java.util.regex.*;
public class TestExpress {
	public static void main(String[] args) {
		
		//练习使用Find group
		System.out.println("------练习find group--------");
		Matcher m1 = Pattern.compile("\\w+").matcher("Java is very easy!");
		while(m1.find()){//find代表是否包含匹配的子串，从这个循环得知，调用find函数默认从上一次结束的位置开始
			System.out.println(m1.group());
			//group返回上一次匹配的子串，所以说这里是“上一次”匹配，因为这时，m1中有个假象的指针已经在此字符串后面了。
		}
		int i=0;
		while(m1.find(i)){
			System.out.println(m1.group()+"\t");
			i++;
		}
		
		//练习使用start end
		System.out.println("------练习start end--------");
		String regStr = "Java is very easy";
		System.out.println("目标字符串是 "+regStr);
		Matcher m2 = Pattern.compile("\\w+").matcher(regStr);
		while(m2.find()){
			System.out.println(m2.group()+" 的起始位置是："+m2.start()+" 结束位置是： "+m2.end());
			//可以看出end返回的是结束位置+1
		}
		
		
		//练习使用matches、reset
		System.out.println("------练习matches reset-------");
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
				System.out.println(mail+"是一个有效的地址！");
			else System.out.println(mail+"是一个无效的地址！");*/
			
			//据说可以直接使用String来匹配正则表达式
			if(mail.matches(mailRegEx))System.out.println(mail+": 有效！");
			else System.out.println(mail+": 无效！");
			//这种比第一种方便多了
		}
		
		
		//练习使用替换，切割等
		System.out.println("------练习replaceAll,split--------");
		String[] msgs = {"this sentence includes words starting with in",
				"I am in the Yuanpei Study room",
				"Monkey Pumpkin King a story i made up"
				};
		String msgRegEx1 = "in\\w+";
		for(String msg : msgs){
			System.out.println(msg.replaceAll(msgRegEx1, "哈哈\2"));
		}
		String msgRegEx2 = "in\\w*";
		for(String msg : msgs){
			System.out.println(msg.replaceAll(msgRegEx2, "哈哈\2"));
			System.out.println(Arrays.toString(msg.split(" ")));
		}
	}
}
