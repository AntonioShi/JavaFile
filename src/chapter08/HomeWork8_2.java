package chapter08;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * 玩游戏的啦
 */
import java.util.Scanner;
public class HomeWork8_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);    //	
		String file = "pw.txt" ;//从文件中读取密码
		BufferedReader br = new BufferedReader(new FileReader(file)) ;
		String str = br.readLine() ;
		String btr = in.nextLine() ;
		for (int i = 1; i < 5; i++) {
			if (str.equals(btr)) {
				System.out.println("恭喜你进入游戏");
				System.exit(0);	
			}
			else {
				System.out.println("密码错误，请重新输入");
				btr = in.nextLine() ;
			}
		}
		System.out.println("密码错误，结束游戏");
		System.exit(0);	
	}

}
