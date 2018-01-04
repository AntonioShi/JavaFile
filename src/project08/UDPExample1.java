package project08;
import java.io.IOException;
import java.net.*;
/**
 * 
* @ClassName: UDPExample1 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author antonio
* @date 2018年1月2日 下午5:24:58 
*reciver
 */
public class UDPExample1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		byte[] buf = new byte[1024] ;//recive data
		DatagramSocket dSocket = new DatagramSocket(8954) ;
		DatagramPacket dPacket = new DatagramPacket(buf, 1024) ;
		System.out.println("i'm waiting your data");
		dSocket.receive(dPacket);
		
		String str = new String(dPacket.getData(), 0, dPacket.getLength()) 
				+ " From " + dPacket.getAddress().getHostAddress()
				+ " : " + dPacket.getPort() ;
		System.out.println(str);//display
		dSocket.close();//free
				
	}

}
