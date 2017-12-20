package project06;
import java.io.* ;
import java.lang.reflect.WildcardType;

public class AddressBookStorage {
	
	private FileReader reader ;//= new FileReader("reader.txt") 
	private FileWriter ObjectOutputStream ;
	private BufferedReader br;//输入缓冲区
	private BufferedWriter bw;
	
	public AddressBookStorage(String str, BufferedReader br) throws IOException {
		super();
		this.reader = new FileReader(str);
		this.br = new BufferedReader(this.reader) ;
	}
	
	public AddressBookStorage(String str, BufferedWriter bw) throws IOException {
		super();
		this.ObjectOutputStream = new FileWriter(str) ;
		this.bw = new BufferedWriter(ObjectOutputStream) ;
	}
	
	public AddressBookStorage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileReader getReader() {
		return reader;
	}
	public void setReader(FileReader reader) {
		this.reader = reader;
	}
	public FileWriter getObjectOutputStream() {
		return ObjectOutputStream;
	}
	public void setObjectOutputStream(FileWriter objectOutputStream) {
		ObjectOutputStream = objectOutputStream;
	}
	
	public void setBr(BufferedReader br) {
		this.br = br ;
	}
	public BufferedReader getBr() {
		return br;
	}
	public void setBw(BufferedWriter bw) {
		this.bw = bw;
	}
	public BufferedWriter getBw() {
		return bw;
	}


}
