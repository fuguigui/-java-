import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSimpleDateFormat {
	public static void main(String[] args) throws ParseException {
		Date d = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("Gyyy���е�D��");
		String dateStr = sdf1.format(d);
		System.out.println(dateStr);
		
		String str = "17###����##8";
		SimpleDateFormat sdf2 = new SimpleDateFormat("y###MMM##d");
		System.out.println(sdf2.parse(str));
	}
}
