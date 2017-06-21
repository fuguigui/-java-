import java.io.*;

class SelfException extends Exception{
	public SelfException(){}
	public SelfException(String msg){
		super(msg);
	}
}
public class TestPrintStackTrace {
	public static void main(String[] args) throws SelfException{
		firstMethod();
	}
	public static void firstMethod() throws SelfException{
		secondMethod();
	}
	public static void secondMethod()throws SelfException{
		thirdMethod();
	}
	public static void thirdMethod() throws SelfException{
		throw new SelfException("�Զ����쳣��Ϣ");
	}
}
