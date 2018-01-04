package project02;
import java.awt.Event;
import java.lang.*;
import java.util.*;
/*
 * MyIntefer class
 * 期中考试手写题
 */

class MyInteger{
	int value ;
	
	public MyInteger(int value) {
		this.value = value;
	}

	public int getInt() {
		return value ;
	}

	
	public boolean isEven() {//如果是偶数
			
			return (value % 2 == 0);
		}
		
	public boolean isOdd() {//如果奇数
			
			return (value % 2 == 0) ;
		}
		
	public boolean isPrime() {//如果素数
		  for (int i = 2; i < value-1; i++) {
			  if (value % i == 0 && i != value) {
				  	return true ;
			}
		}
			
			return false ;
		}
		
	public boolean isEven(int value) {//如果是偶数
			
			return value % 2 == 0;
		}
		
	public boolean isOdd(int value) {//如果奇数
			
			return value % 2 == 0 ;
		}
		
	public boolean isPrime(int value) {//如果素数
		  for (int i = 2; i < value-1; i++) {
			  if (value % i == 0 && i != value) {
				  	return true ;
			}
		}
			
			return false ;
		}
	
	
	public boolean isEven(MyInteger a) {//如果是偶数
	
		return isEven(a.value) ;
	}
	
	public boolean isOdd(MyInteger a) {//如果奇数
	
		return isOdd(a.value) ;
	}
	
	public boolean isPrime(MyInteger a) {//如果素数
	  for (int i = 2; i < a.value-1; i++) {
		  if (a.value % i == 0 && i != value) {
			  	return true ;
		}
	}
		
		return false ;
	}
	
	boolean equals(int obj) {
		// TODO Auto-generated method stub
		if (value == obj) {
			return true ;
		}
		return false ;
	}
	
	boolean equals(MyInteger obj) {
		if (obj.getInt() == value) {
			return true ;
		}
		return false ;
	}
	
	int[] parseInt(char a[]) throws Exception{
		int []num = new int [a.length];//char[] -- > int
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
	
	 int[] parseInt(String a) throws Exception{
		int []num = new int [a.length()];//string -- > int
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

public class Example2 {//测试所有的方法

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int value = 66 ;
		MyInteger myint = new MyInteger(77);
		MyInteger myInt = new MyInteger(88);
		
		if (myint.isEven()) {//77
			System.out.println(myint.getInt() + "is Even");
		}
		else if (myint.isOdd()) {
			System.out.println(myint.getInt() + " is odd");
		}
		
		if (myint.isPrime()) {
			System.out.println(myint.getInt() + "Prime");
		}
		
		if (myint.isEven(value)) {//66
			System.out.println(value + "is Even");
		}
		else if (myint.isOdd(value)) {
			System.out.println(value + "is Odd");
		}
		
		if (myint.isPrime(value)) {
			System.out.println(value + "is Prime");
		}
		
		if (myint.isEven(myInt)) {
			System.out.println(myInt.getInt() + "is Even(obj)");
		}
		else if (myint.isOdd(myInt)) {
			System.out.println(myInt.getInt() + "is Odd(obj)");
		}
		if (myint.isPrime(myInt)) {
			System.out.println(myInt.getInt() + "is Prime(obj)");
		}
		
		if (myint.equals(99)) {//99
			System.out.println(88 + "is equal with" + myint.getInt());
		}
		if (myint.equals(myInt)) {//88
			System.out.println(myInt.getInt() + "is equal with" + myint.getInt());
		}
		System.out.println("接下来的是类型转换");
		char []a = {'x', 'y', 'z'} ;
		String str = String.valueOf(a) ;//你要记住!!!
		int []num = new int [a.length];
		num = myInt.parseInt(a) ;
		System.out.println(str);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);//987
		}
		
		System.out.println();
		String bString = "9527" ;
		num = myInt.parseInt(bString) ;
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);//987
		}
	}

}
