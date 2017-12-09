package chapter06;
/*
 * 三个要求：
 * 1.倒序遍历
 * 2.大小互换
 * 3.StringBuffer对象的使用
 */
public class HomeWork6_1 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "HelloWorld", str2;
		StringBuffer str3 = new StringBuffer() ;
		
		char ch ;
		for (int i = str1.length()-1; i >= 0; i--) {
			
			ch = str1.charAt(i) ;
			
			str2 = String.valueOf(ch) ;
			
			if (ch > 'A' && ch < 'Z') {
				str2.toLowerCase() ;
				str3.append(str2.toLowerCase()) ;
			}
			else if (ch > 'a' && ch < 'z') {
				str2.toUpperCase() ;
				str3.append(str2.toUpperCase()) ;
			}
		
		}
		str3.toString() ;
		System.out.println(str3);
	}
	
}
