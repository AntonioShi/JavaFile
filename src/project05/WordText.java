package project05;
/**
 * 
* @ClassName: WordText 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author antonio
* @date 2017年12月10日 下午9:28:35 
*
 */

import java.io.*;

//管理其他对象来构建单词表
class WordConcordance {

	private String str = null;
	private FileManager fManager = new FileManager();
//	private WordList wList = new WordList();
	private Pattern pt = new Pattern();
	private int[] count = new int[26];

	public void run() {
		FileManager fManager = new FileManager();

		str = fManager.openFile("wL.txt");

		pt.patternWords(str, count);	//匹配
		
		fManager.saveFile("concordance.txt", count);
	}
}

// 文件管理
class FileManager {

	// 读取文件
	public String openFile(String fileName) {
		BufferedReader bufr = null;

		String str = "", line = null;

		try {
			bufr = new BufferedReader(new FileReader(fileName));
			while ((line = bufr.readLine()) != null) {
				
				str += line;
			}
			str.replaceAll(" ", "");
			return str;
		} catch (IOException e) {
			throw new RuntimeException("读取失败");
		} finally {
			try {
				if (bufr != null)
					bufr.close();
			} catch (IOException e) {
				throw new RuntimeException("读取关闭失败");
			}
		}
	}

	public void saveFile(String fileName, int[] count) {
		FileWriter fw = null;
		try {
			char alpet='a';
			fw = new FileWriter(fileName);
			for (int i = 0; i < 26; i++) {
//				System.out.println((alpet++) + ":" + count[i]);

				fw.write((alpet++) + ":" + count[i] + "\r\n");
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}
		}
	}
}


// 模式匹配操作的类
class Pattern {

	public void patternWords(String str, int[] count) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
				count[str.charAt(i) - 'a']++;
			else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
				count[str.charAt(i) - 'A']++;
		}
	}
}

public class WordText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordConcordance wc = new WordConcordance();
		wc.run();
	}

}