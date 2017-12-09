package chapter05;

/**
 * 线程初体验
 * @author antonio
 *
 */

class MyThread1 implements Runnable{
	static int i = 0 ;
	public void run() {
		while(true) {
			System.out.println("MyThread's run() is running!"+i);
		}
	}
	
}

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread6 mythread = new MyThread6() ;
		Thread thread = new Thread(mythread) ;//此类为java自带的
		thread.start();//起动线程
		
		//mythread.run();
		
		while(true) {
			System.out.println("Main() is running!");
		}
	}

}
