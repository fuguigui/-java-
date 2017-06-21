import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TestDateFormat {
	public static void main(String[] args) {
		Date dt = new Date();
		Locale[] locales = {Locale.CHINA,Locale.US};
		DateFormat[] df = new  DateFormat[16];
		for(int i =0;i<locales.length;++i){
			df[i*8] = DateFormat.getDateInstance(DateFormat.SHORT,locales[i]);
			df[i*8+1] = DateFormat.getDateInstance(DateFormat.MEDIUM,locales[i]);
			df[i*8+2] = DateFormat.getDateInstance(DateFormat.LONG,locales[i]);
			df[i*8+3] = DateFormat.getDateInstance(DateFormat.FULL,locales[i]);
			df[i*8+4]=DateFormat.getTimeInstance(DateFormat.SHORT,locales[i]);
			df[i*8+5]=DateFormat.getTimeInstance(DateFormat.MEDIUM,locales[i]);
			df[i*8+6]=DateFormat.getTimeInstance(DateFormat.LONG,locales[i]);
			df[i*8+7]=DateFormat.getTimeInstance(DateFormat.FULL,locales[i]);
		}
		for(int i = 0;i<locales.length;++i){
			switch(i){
			case 0:System.out.println("------中国的日期格式--------");break;
			case 1:System.out.println("------美国的日期格式--------");break;
			}
			for(int j = 0;j<8;++j){
				System.out.println(df[i*8+j].format(dt));
			}
		}
	}
}
