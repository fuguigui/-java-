import java.io.*;
public class TestReturn {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try{
			System.out.println("�˾���try��return֮ǰ����ִ��");
			fis = new FileInputStream("a.txt");
			return;
			//System.out.println("�˾���try��return֮�󣬻ᱻִ��");
		}
		catch(IOException ios){
			System.out.println(ios.getMessage());
		}
		finally{
			System.out.println("ִ����finally�е�return����");
			return;
		}
	}
}
