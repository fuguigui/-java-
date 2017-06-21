import java.util.*;

public class TestGenericMethod2 {
	static <T> void test(Collection<? extends T> a, Collection<T> c){
		for(T o:a){
			c.add(o);
		}
	} 
	public static void main(String[] args) {
		List<Object> objList= new ArrayList<Object>();
		List<String> strList=new ArrayList<String>();
		test(strList,objList);
	}

}
