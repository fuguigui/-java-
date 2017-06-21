import java.text.MessageFormat;
import java.util.*;

public class HelloArg {
	public static void main(String[] args) {
		Locale currentLocale = null;
		if(args.length == 2){
			currentLocale = new Locale(args[0],args[1]);
		}
		else{
			currentLocale = Locale.getDefault();
		}
		ResourceBundle bundle = ResourceBundle.getBundle("MyResource",currentLocale);
		String msg = bundle.getString("msg");
		System.out.println(MessageFormat.format(msg, "¸£¹ó",new Date()));
	}
}
