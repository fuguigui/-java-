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
		//���ֻд�������䣬��û������throws�쳣�׳�ǩ����������ͨ�����ġ�
		//FileInputStream fis= new FileInputStream("a.txt");
	}
}	
