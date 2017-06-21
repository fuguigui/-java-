import java.util.*;

public class TestGenericMethod {
	static <T> void fromArrayToCollection(T[] a,Collection<T> c){
		for(T o:a){
			c.add(o);
		}
	}
	public static void main(String[] args) {
		Object[] oa = new Object[10];
		Collection<Object> co = new ArrayList<Object>();
		fromArrayToCollection(oa,co);
		System.out.println(co);
		
		String [] sa= new String[100];
		Collection<String> cs = new ArrayList<String>();
		fromArrayToCollection(sa,cs);
		System.out.println(cs);
		
		Integer[] ia = new Integer[100];
		Collection<Float> cf = new ArrayList<Float>();
		/*
		 * 这条会出错
		 */
		//fromArrayToCollection(ia,cf);
		System.out.println(cf);
	}

}
