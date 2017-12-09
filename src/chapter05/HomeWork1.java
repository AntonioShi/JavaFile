package chapter05;
/*
 * 123
 */
  
class MyThread6 extends Thread{
	int i = 0 ;
	private int note = 1 ;
	
	public void run() {
		while(true) {
			if (note <= 80) {
				Thread th = Thread.currentThread() ;
				String th_name = th.getName() ;
				System.out.println(th_name + "正在分发第" +  (note++) + "份卷子");
				
				try {//线程睡眠
					Thread.sleep(100);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					
				}
			}
		}
	}
	
}

class MyRunnable implements Runnable{
	int i = 0 ;
	public void run() {
		while(i < 50) {
			System.out.println("new");
			i ++ ;
		}
	}
}

public class HomeWork1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread6 myThread = new MyThread6() ;//生成一个实例对象
		

		
		//打印
		MyRunnable myRunnable = new MyRunnable() ;
		//main线程打印
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName());//得到当前线程的名字[main]
		}
		
		//开启有限次的线程:3个老师
		new Thread(myThread, "Teacher1").start();//创建并开启线程，命名
		new Thread(myThread, "Teacher2").start();
		new Thread(myThread, "Teacher3").start();
		
		

		
	}

}


