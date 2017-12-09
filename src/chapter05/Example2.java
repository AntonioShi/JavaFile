package chapter05;

/**
 * 多线程
 * 创建线程
 * 死循环，，cpu轮番交替的调用两段线程。
 */

class MyThread extends Thread{
	public void run() {
		while(true) {
			System.out.println("MyTread's run() is running!");
		}
	}
}

public class Example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread mythread = new MyThread() ;
		mythread.start();
		while(true) {
			System.out.println("Main() is running!");
			
		}
	}

}

