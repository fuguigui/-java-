import java.io.*;
public class TestReturn {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try{
			System.out.println("此句在try的return之前，被执行");
			fis = new FileInputStream("a.txt");
			return;
			//System.out.println("此句在try的return之后，会被执行");
		}
		catch(IOException ios){
			System.out.println(ios.getMessage());
		}
		finally{
			System.out.println("执行了finally中的return方法");
			return;
		}
	}
}
