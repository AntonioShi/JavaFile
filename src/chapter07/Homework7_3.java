package chapter07;
/*
 * Map集合
 */
import java.util.*;

public class Homework7_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap tMap = new TreeMap() ;//key value的映射
		tMap.put("1", "Lucy") ;
		tMap.put("4", "Amimee") ;
		tMap.put("5", "Amanda") ;
		tMap.put("2", "John") ;
		tMap.put("3", "Smith") ;
		Set keyset = tMap.keySet() ;//键的集合
		Iterator iterator = keyset.iterator() ;//获取迭代器对象
		
		while (iterator.hasNext()) {
			Object key = (Object) iterator.next();
			Object value = tMap.get(key) ;
			System.out.println(key + " : " + value);
		}
	}

}
