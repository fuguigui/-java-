import java.util.Locale;

public class LocaleList {
	public static void main(String[] args) {
		Locale[] localelist = Locale.getAvailableLocales();
		//遍历数组的每个元素，依次获取所支持的国家和语言
		/*for(int i =0;i<localelist.length;++i){
			System.out.println(localelist[i].getDisplayCountry()+"="+localelist[i].getCountry()
					+" "+localelist[i].getDisplayLanguage()+"="+localelist[i].getLanguage());
		}*/
		for(Locale tmp:localelist){
			System.out.println(tmp.getDisplayCountry()+"="+tmp.getCountry()+"\t"+tmp.getDisplayLanguage()+"="+tmp.getLanguage());
		}
	}
}
