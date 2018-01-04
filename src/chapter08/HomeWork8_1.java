package chapter08;
/**
 * 
* @ClassName: HomeWork8_1 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author antonio
* @date 2017年12月29日 上午8:44:05 
*
 */
import java.io.*;

public class HomeWork8_1 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String infile = "infile.txt", outfile = "outfile.txt" ;
		FileInputStream in = new FileInputStream(infile) ;//byte read
		FileOutputStream out = new FileOutputStream(outfile) ;//byte write
		int ch = 0 ;
		
		//byte read and write stream -- > copy file
		while (true) {
			ch = in.read() ;
			
			if (ch == -1) {
				break ;
			}
			out.write(ch);//
			System.out.println(ch); // 
		}
		System.out.println("byte read and write stream -- > copy file");
		in.close();
		out.close();	
		
		//char read and write stream -- > copy file
		String str1 = "src.txt", str2 = "des.txt" ;
		FileWriter fw = new FileWriter(str2) ;//char write	
		FileReader fr = new FileReader(str1) ;//char read
		BufferedWriter bw = new BufferedWriter(fw) ;//char write buffer
		BufferedReader br = new BufferedReader(fr) ;//char read buffer
		byte []s = new byte [1024];//read buffer 
		String str ;
		int len ;
		
		while ((str = br.readLine()) != null) {
			bw.write(str);
			bw.newLine();//
		}
		System.out.println("char read and write stream -- > copy file");
		br.close();
		bw.close();
	}
	
}
