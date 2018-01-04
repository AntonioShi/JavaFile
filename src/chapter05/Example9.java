package chapter05;
/**
 * 
* @ClassName: Example9 
* @Description: 验证线程的run方法和Start方法的启动方式
* java中thread的start()和run()的区别：
* 
	1.start（）方法来启动线程，真正实现了多线程运行，
	这时无需等待run方法体代码执行完毕而直接继续执行下面的代码：
	通过调用Thread类的start()方法来启动一个线程，
	这时此线程是处于就绪状态，
	并没有运行。
	然后通过此Thread类调用方法run()来完成其运行操作的，
	这里方法run()称为线程体，
	它包含了要执行的这个线程的内容，
	Run方法运行结束，
	此线程终止，
	而CPU再运行其它线程.
	
	2.run（）方法当作普通方法的方式调用，程序还是要顺序执行，
	还是要等待run方法体执行完毕后才可继续执行下面的代码：
	而如果直接用Run方法，
	这只是调用一个方法而已，
	程序中依然只有主线程--这一个线程，
	其程序执行路径还是只有一条，
	这样就没有达到写线程的目的。

* @author antonio
* @date 2018年1月4日 下午8:59:27 
*
 */

class myth implements Runnable{
	public void run() {
		while (true) {
			System.out.println("你是谁，你在哪，你来自哪里");
		}
	}
}
public class Example9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new myth(), "001").start();
//		new Thread(new myth(), "001").run();
	}

}
