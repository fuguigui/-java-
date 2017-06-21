import java.text.NumberFormat;
import java.util.Locale;

public class TestNumberFormat {
	public static void main(String[] args) {
		double db = 1234000.567;
		Locale[] locales = {Locale.CHINA,Locale.JAPAN,Locale.KOREA,Locale.GERMAN,Locale.US};
		NumberFormat[] nf = new NumberFormat[15];
		for(int i = 0;i<locales.length;++i){
			nf[i*3] = NumberFormat.getNumberInstance(locales[i]);
			nf[i*3+1] = NumberFormat.getPercentInstance(locales[i]);
			nf[i*3+2] = NumberFormat.getCurrencyInstance(locales[i]);
		}
		for(int i = 0;i<locales.length;++i){
			switch(i){
			case 0:System.out.println("----------�й���ʽ------------");
			break;
			case 1:System.out.println("----------�ձ���ʽ------------");
			break;
			case 2:System.out.println("----------������ʽ------------");
			break;
			case 3:System.out.println("----------�¹���ʽ------------");
			break;
			case 4:System.out.println("----------������ʽ------------");
			break;
			}
			System.out.println("ͨ����ֵ��ʽ��"+nf[i*3].format(db));
			System.out.println("�ٷֱ���ֵ��ʽ��"+nf[i*3+1].format(db));
			System.out.println("������ֵ��ʽ��"+nf[i*3+2].format(db));
		}
	}
}
