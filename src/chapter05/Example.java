package chapter05;
/*
 * 线程让步
 */

class YieldThread extends Thread{

	public YieldThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "---" + i);
			if (i== 3) {
				System.out.print("线程让步");
				Thread.yield();//线程运行到此，作出让步
				
				
				try {//由于处理器速度太快，素以需要休眠函数去辅助，才能让让步效果比较明显
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				
			}
		}
	}
}

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new YieldThread("线程A");
		Thread t2 = new YieldThread("线程B");
		
		t1.start();
		t2.start();
	}

}
