package chapter07;
/*
 * 集合类
 * 很重要的
 */
import java.util.*;
//import java.util.*;
public class HomeWork7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList() ;//空集合
		for (int i = 0; i < 10; i++) {
			list.add("客服  " +i+ "号，为您服务") ;
		}
		Iterator iterator = list.iterator() ;//获取对象
		while (iterator.hasNext()) {
			Object object = iterator.next() ;//取出集合中的元素
			System.out.println(object);
		}
	}

}
