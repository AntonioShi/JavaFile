package project06;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import project06.AddressBookStorage;

public class TextAddressBookStorage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//打开文件	
	}
	
	int setFile(String file) throws IOException {
		String str ;
		BufferedReader bReader = null ;//传参前必须要初始化
		AddressBookStorage reader = new AddressBookStorage(file, bReader);
		
		
		while((str = bReader.readLine()) != null) {
			System.out.println(str);
		}
		reader.getReader().close() ;//关闭文件
		bReader.close();//
		return 1 ;
	}
	
	

}
