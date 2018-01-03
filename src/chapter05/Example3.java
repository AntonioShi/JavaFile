	/**
	 * 
	 * @author antonio
	 * @time 2017年10月10日下午5:21:50
	 * @conent 为实现多个线程共享同一数据资源
	 */

package chapter05;
//import org.omg.PortableServer.THREAD_POLICY_ID;
	
public class Example3 {
		public static void main(String []args) {
			TicketWindow tw = new TicketWindow() ;//创建一个实例对象
			new Thread(tw, "窗口 1").start();//创建线程对象并命名为窗口1, 开启线程
			new Thread(tw, "窗口 2").start();//创建线程对象并命名为窗口2, 开启线程
			new Thread(tw, "窗口 3").start();//创建线程对象并命名为窗口3, 开启线程
			new Thread(tw, "窗口 4").start();//创建线程对象并命名为窗口4, 开启线程
		}
	}

	class TicketWindow implements Runnable{
		private int tickets = 1000;
		public void run() {
			while(true) {
				if (tickets > 0) {
					Thread th = Thread.currentThread() ;//获取当前线程
					String th_name = th.getName() ;//获取当前线程的名字
					System.out.println(th_name + "正在发售第" + tickets -- +"票");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}