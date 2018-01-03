package chapter05;
/*
 * 多线程同步问题：多个线程先后对统一共享数据进行操作，由于休眠方法的作用，他们会抢占式的修改数据，发生不可预料的数据错误
 * 同步代码块：一次仅允许一个线程操作，而且必须要等到上一个线程完成后才可以进行下一个
 * 共享资源代码块
 * 
 */

class Ticket implements Runnable{
	private int tickets = 100 ;
	Object lock = new Object() ;//定义Object 锁对象，作用同步代码块的锁
	
	public void run() {
		while (true) {
			synchronized (lock) {//定义同步代码块
			
				if (tickets > 0) {
					Thread thread = Thread.currentThread() ;
					String th_name = thread.getName() ;
					
					try {
						System.out.println(th_name + "------卖出票" + tickets--);//由于cpu的原因，运行时可能只会出现001号售票员
						Thread.sleep(0);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
				}else {
					break ;//完成任务后跳出
				}
				
			}
			
		}
	}
}

public class Example5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket ticket = new Ticket() ;
		
		new Thread(ticket, "售票员001").start();
		new Thread(ticket, "售票员002").start();
		new Thread(ticket, "售票员003").start();
		new Thread(ticket, "售票员004").start();
	}

}
