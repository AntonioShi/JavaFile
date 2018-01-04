package project08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

import javax.management.RuntimeErrorException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
//
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class GuiChat extends JFrame{

	private static final int DEFAULT_PORT = 8899 ;//default port
	//three
	private JLabel stableLB ;//
	private JTextArea centerTextArea ;
	private JPanel southPanel ;
	private JTextArea inputTextArea ;
	private JPanel bottomPanel ;
	private JTextField ipTextField ;//ip shuru kuang
	private JTextField remoteProtTF ;
	private JButton sendBT ;
	private JButton clearBT ;
	private DatagramSocket dSocket ;
	//jijijijkii
	private void setUI() {
		//chu shi hua 
		setTitle("GUI Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400) ;
		setResizable(true);//chuang kou bu ke tiao zheng
		setLocationRelativeTo(null);//ju zhong
		//chuang kou north bu fen
		stableLB = new JLabel("dang qian hai wei qidong jian ting ") ;
		stableLB.setHorizontalAlignment(JLabel.RIGHT);
		//chuangkou center bufen 
		centerTextArea = new JTextArea() ;
		centerTextArea.setEditable(false);//
		centerTextArea.setBackground(new Color(211, 211, 211));
		//chuangkou south bufen
		southPanel = new JPanel(new BorderLayout()) ;
		inputTextArea = new JTextArea(5, 20) ;//shuru neirong quyu
		bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5)) ;//bottom
		ipTextField = new JTextField("127.0.0.1", 8) ;
		remoteProtTF = new JTextField(String.valueOf(DEFAULT_PORT), 3) ;	//
		sendBT = new JButton("send") ;
		clearBT = new JButton("clear") ;
		//add to bottom
		bottomPanel.add(ipTextField) ;
		bottomPanel.add(sendBT);
		bottomPanel.add(remoteProtTF);
		bottomPanel.add(clearBT);
		//add to south
		southPanel.add(new JScrollPane(inputTextArea), BorderLayout.CENTER) ;
		southPanel.add(bottomPanel, BorderLayout.SOUTH) ;
		//chuangkou  
		add(stableLB, BorderLayout.NORTH) ;
		add(new JScrollPane(centerTextArea), BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		setVisible(true);
	}

	private void setListener() {
		//wei sendBT add shijian Listener
		sendBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//get ip port
				final String ipAddress = ipTextField.getText() ;
				final String remotePort = remoteProtTF.getText() ;
				//adjust ip and port
				if (ipAddress == null || remotePort == null
						|| ipAddress.trim().equals("") 
						|| remotePort.trim().equals("")) {
					JOptionPane.showMessageDialog(GuiChat.this, "please inpput your ip and port");
					return ;
				}
				if (dSocket == null || dSocket.isClosed()) {
					JOptionPane.showMessageDialog(GuiChat.this, "jianting bu chenggong");
					return ;
				}
				//get the message what needed to send
				String sendContent = inputTextArea.getText() ;
				byte[] buf = sendContent.getBytes() ;
				try {
					//show the message what you will send
					centerTextArea.append("I say :   " + inputTextArea.getText() 
											+ "\n" + "to " + ipAddress + ":" + remotePort + "\n\n");
					//after add the message, roll the buttom to the dibu.
					centerTextArea.setCaretPosition(centerTextArea.getText().length());//
					dSocket.send(new DatagramPacket(buf, buf.length, 
													InetAddress.getByName(ipAddress),
													Integer.parseInt(remotePort)));
					inputTextArea.setText("");
					
				} catch (IOException e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(GuiChat.this, 
							"there is sth wrong, the message  send faild");
					e1.printStackTrace(); 
				}
			} ;
		});
		//wei clearBT add Listener
		clearBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				centerTextArea.setText("");
			}
		});
	}

	private void initSocket() {
		int port = DEFAULT_PORT ;
		while (true) {
			try {
				if (dSocket != null && !dSocket.isClosed()) {
					dSocket.close();
				}
				try {
					//adjust port 1 -- 65535
					port = Integer.parseInt(JOptionPane.showInputDialog(this, "please input port",
							"port", JOptionPane.QUESTION_MESSAGE)) ;
					if (port < 1 || port > 65535) {
						throw new RuntimeException("the port is over the arragement") ;
					}
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "what you input is wrong, 1--65535");
					continue ;
				}
				//stat dSocket
				dSocket = new DatagramSocket(port) ;
				startListen() ;//tiao yong
				//zai stateLB zhong show the port
				stableLB.setText("yi zai " + port + "jianting");
				break ;
			} catch (SocketException e) {//port bei zhanyong
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "port bei zhanyong, chongxin shu ru ");
				stableLB.setText("dang qian hai wei qidong jianting");
				
			}
		}
	}

	private void startListen() {
		// TODO Auto-generated method stub
		new Thread() {
			private DatagramPacket p ;//ji zhuang xiang
			public void run() {
				byte[] buf = new byte[1024] ;
				//chuangjian DatagramPacket
				p = new DatagramPacket(buf, buf.length) ;
				while (! dSocket.isClosed()) {
					try {
						dSocket.receive(p);//receive 
						//add to Panel
						centerTextArea.append(p.getAddress().getHostAddress()
											+ ":"
											+ ((InetSocketAddress)p.getSocketAddress()).getPort()
											+ "say to me :\n"
											+ new String(p.getData(), 0, p.getLength())
											+ "\n\n");
						//move the roll to the bottom
						centerTextArea.setCaretPosition(centerTextArea.getText().length());
					} catch (IOException e) {
						// TODO: handle exception
						e.printStackTrace();
					
					}
				}
			}
		}.start(); //!!!
	}


	public GuiChat() {
		setUI() ;
		initSocket();
		setListener();
	}
		
	public static void main(String[] args) {
		new GuiChat() ;
	}
	
}
	





