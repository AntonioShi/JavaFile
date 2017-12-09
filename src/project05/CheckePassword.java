package project05;
/*
* 问题描述：
一些网站对密码施加了一定的规定。 编写一个方法来检查一个字符串是否是一个有效的密码。 假设密码规则如下：

密码必须至少有八个字符。+
密码仅由字母和数字组成。+
密码必须至少包含两位数字。

编写一个程序，提示用户输入密码，如果遵守规则则显示“有效密码”，否则显示“无效密码”。

样品1
输入密码的字符串：wewew43x
有效的密码

样品2
输入密码字符串：343a
无效的密码
 */

import java.io.*;
import java.util.*;

public class CheckePassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len ;
		int number = 0 ;
		int character = 0 ;
		int count = 0 ;//计数器
		
		Scanner in = new Scanner(System.in) ;
		String password = in.nextLine() ;
		
		char ch[] = password.toCharArray() ;
		len = ch.length ;
		if (len < 8) {
			System.out.println("无效密码");
		}
		
		for (int i = 0; i < ch.length; i++) {
			
			if (ch[i] >= '0' && ch[i] <= '9') {
				number++ ;
			}
			
			else if (ch[i] >= 'A' && ch[i] <= 'Z' || ch[i] >= 'a' && ch[i] <= 'z') {
				character++ ;
			}
			
			else {
				System.out.println("无效密码");
				return ;
			}
		}
		
		if (number < 2) {
			System.out.println("无效密码");
			return ;
		}
		
		System.out.println("有效密码");
	}

}
