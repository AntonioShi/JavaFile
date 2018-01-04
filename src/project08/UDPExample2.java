package project08;
import java.io.IOException;
import java.net.*;
/**
 * 
* @ClassName: UDPExample2 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author antonio
* @date 2018年1月2日 下午5:41:29 
*sender
 */
public class UDPExample2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DatagramSocket dSocket = new DatagramSocket(3000) ;
		String str = "Hello Worth" ;
		/*
		 * data length ip packet
		 */
		DatagramPacket dPacket = new DatagramPacket(str.getBytes(), str.length(),
								InetAddress.getByName("localhost"), 8954) ;
		System.out.println("i'm sending manages to you, boy");
		dSocket.send(dPacket);
		dSocket.close();
	}

}
