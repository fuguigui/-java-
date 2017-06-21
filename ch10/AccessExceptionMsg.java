import java.io.*;

public class AccessExceptionMsg {
	public static void main(String[] args) {
		try{
			FileInputStream fis = new FileInputStream("a.txt");
		}
		catch(IOException ioe){
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
		//如果只写下面的语句，而没有增加throws异常抛出签名，编译是通不过的。
		//FileInputStream fis= new FileInputStream("a.txt");
	}
}	
