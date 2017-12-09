package chapter05;
/*
 * 同步方法
 */

class Ticket6 implements Runnable{
	private int tickets = 100 ;
	public void run() {
		while(true) {
			saleTicket() ;
			if (tickets <= 0) {
				break ;
			}
		}
	}
	
	private synchronized void saleTicket() {
		if (tickets > 0) {
			
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + "---卖出票" + tickets--);
			
		}
	}
}

public class Example6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket6 ticket = new Ticket6() ;
		
		new Thread(ticket, "001").start() ;
		new Thread(ticket, "002").start() ;
		new Thread(ticket, "003").start() ;
		new Thread(ticket, "004").start() ;
	}

}
