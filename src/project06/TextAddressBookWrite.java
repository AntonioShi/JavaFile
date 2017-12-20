package project06;
import java.io.*;
import java.util.*;
import project06.AddressBookStorage;

public class TextAddressBookWrite {
	 //写入文件
	static int write(String file) throws IOException {
		BufferedWriter bWriter = null ;//传参前必须要初始化
		AddressBookStorage ObjectOutputStream = new AddressBookStorage(file, bWriter) ;
		
		Scanner in = new Scanner(System.in);    //		Scanner in ;//输入包
		String str = in.nextLine() ;//
		//希望自主输入
		ObjectOutputStream.getObjectOutputStream().write(str);
		ObjectOutputStream.getObjectOutputStream().close();
		System.out.println("写入完成");
		return 1;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int ch = write("write.txt") ;
	}
	


}
