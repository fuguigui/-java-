import java.util.Calendar;

public class TestLazy {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		cal.set(2017, 5,31);
		cal.set(Calendar.MONTH, 8);
	//	System.out.println(cal.getTime());
		cal.set(Calendar.DATE, 5);
		System.out.println(cal.getTime());
	}
}
