package project02;
import java.awt.Event;
import java.lang.*;
import java.util.*;
/*
 * MyIntefer class
 */

class MyInteger{
	static int value ;
	
	
	
	public MyInteger(int value) {
		super();
		this.value = value;
	}

	public int getInt() {
		return value ;
	}

	
	static public boolean isEven() {//如果是偶数
			
			return value % 2 == 0;
		}
		
	static public boolean isOdd() {//如果奇数
			
			return value % 2 == 0 ;
		}
		
	static	public boolean isPrime() {//如果素数
		  for (int i = 2; i < value-1; i++) {
			  if (value % i == 0 && i != value) {
				  	return true ;
			}
		}
			
			return false ;
		}
		
	static public boolean isEven(int value) {//如果是偶数
			
			return value % 2 == 0;
		}
		
	static public boolean isOdd(int value) {//如果奇数
			
			return value % 2 == 0 ;
		}
		
	static	public boolean isPrime(int value) {//如果素数
		  for (int i = 2; i < value-1; i++) {
			  if (value % i == 0 && i != value) {
				  	return true ;
			}
		}
			
			return false ;
		}
	
	
	static public boolean isEven(MyInteger a) {//如果是偶数
	
		return isEven(a.value) ;
	}
	
	static public boolean isOdd(MyInteger a) {//如果奇数
	
		return isOdd(a.value) ;
	}
	
	static	public boolean isPrime(MyInteger a) {//如果素数
	  for (int i = 2; i < a.value-1; i++) {
		  if (a.value % i == 0 && i != value) {
			  	return true ;
		}
	}
		
		return false ;
	}
	
	static boolean equals(int obj) {
		// TODO Auto-generated method stub
		if (value == obj) {
			return true ;
		}
		return false ;
	}
	
	static boolean equals(MyInteger obj) {
		if (obj.getInt() == value) {
			return true ;
		}
		return false ;
	}
	
	static int[] parseInt(char a[]) throws Exception{
		int []num = new int [a.length];
		try {
			
					for (int i = 0; i < a.length; i++) {
					num[i] = a[i] - '0' ;//直接相减， 通过内部转换成integer
				}
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return num ;
	}
	
	static int[] parseInt(String a) throws Exception{
		int []num = new int [a.length()];
		char []ch ;
		try {
			ch = a.toCharArray() ;
			num = parseInt(ch);
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return num ;
	}

}

public class Example2 {//测试搜有的方法```

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int value = 66 ;
		MyInteger myInteger = new MyInteger(value);
		MyInteger obj = new MyInteger(88);
		
		if (myInteger.isEven()) {//66
			System.out.println("Even");
		}
		else if (myInteger.isOdd()) {
			System.out.println("Odd");
		}
		if (myInteger.isPrime()) {
			System.out.println("Prime");
		}
		
		if (myInteger.isEven(value)) {//66
			System.out.println("Even(value)");
		}
		if (myInteger.isOdd(value)) {
			System.out.println("Odd(value)");
		}
		if (myInteger.isPrime(value)) {
			System.out.println("Prime(value)");
		}
		if (myInteger.isEven(obj)) {
			System.out.println("Even(obj)");
		}
		if (myInteger.isOdd(obj)) {
			System.out.println("Odd(obj)");
		}
		if (myInteger.isPrime(obj)) {
			System.out.println("Prime(obj)");
		}
		
		if (myInteger.equals(88)) {//99
			System.out.println("equal Int");
		}
		if (myInteger.equals(obj)) {//88
			System.out.println("equal MyInteger");
		}
		
		char []a = {'9', '8', '7'} ;
		int []num = new int [a.length];
		num = obj.parseInt(a) ;
		System.out.println(num);//987
		
		String bString = "9527" ;
		num = obj.parseInt(bString) ;
		System.out.println(num);//9527
	}

}
