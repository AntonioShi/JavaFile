package chapter05;
/*
 * 后台前台线程
 */
class DamonThread implements Runnable{
		public void run() {
			while(true) {
				System.out.println(Thread.currentThread().getName() + "---is running");
			}
		}
	}

	
public class Example4 {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.out.println("main线程实后台线程吗?" + Thread.currentThread().isDaemon());
			
			DamonThread dt = new DamonThread() ;//创建一个对象
			Thread t = new Thread(dt, "后台线程") ;//创建线程t共享dt资源
			
			System.out.println("t 线程默认是后台线程吗? " + t.isDaemon());//判断事都为后台线程
			t.setDaemon(true);//将线程t设置成后台线程
			t.start();//启动线程
			for(int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		}

	}