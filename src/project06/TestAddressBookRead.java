package project06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import project06.AddressBookStorage;

public class TestAddressBookRead {
	//读取文件
	static void read(String file) throws IOException {
		
		int ch, index = 0;
		BufferedReader bReader = null ;//传参前必须要初始化
		AddressBookStorage reader = new AddressBookStorage(file, bReader);
		
		String str ;
		while ((str = reader.getBr().readLine()) != null) {
			System.out.println(str);
		}

//		while((ch = reader.getReader().read()) != -1) {
//			System.out.print(ch + "    ");
//			index++ ;
//			if (index == 10) {
//				System.out.println();
//				index = 0 ;
//			}//把文件信息转换成int输出
//		}
		reader.getBr().close();//关闭内置的读缓冲区
		reader.getReader().close();//关闭内置文件端口
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		read("write.txt") ;
	}
}
