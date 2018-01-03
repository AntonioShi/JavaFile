package chapter05;

/**
 * 线程初体验
 * @author antonio
 *
 */

class MyThread1 implements Runnable{//实现RUnnable
	int i = 0 ;
	public void run() {
		while(true) {
			System.out.println("MyThread's run() is running! " + i);
			i++ ;
		}
	}
	
}

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread1 mythread = new MyThread1() ;
		Thread thread = new Thread(mythread) ;//此类为java自带的
		thread.start();//起动线程

		
		while(true) {
			System.out.println("Main() is running!");
	
		}
	}

}
