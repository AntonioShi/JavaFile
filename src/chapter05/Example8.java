package chapter05;
/**
 * 多线程通信问题：一个放入数据，一个取数据，必须步调一致才好
 * 问题解决方法：
 * void wait():当前线程进入等待
 * void notify():唤醒第一个等待同步锁的线程
 * void notifyAll():唤醒次同步锁上调用wait的所有线程
 * @author antonio
 *
 */

class Storage{
	private int[] cells = new int[10] ;//数据存储数组
	private int inPos, outPos ;//存放和提取的下坐标
	private int count ;//number
	
	public synchronized void put(int num) {
		try {
			
			Thread.sleep(100);
			//如果存放数据个数等于cell长度（满咯），此线程等待
			while (count == cells.length) {
				this.wait();
			}
			cells[inPos] = num ;//向数组中存放数据
			System.out.println("在cell["+ inPos+"]中放入数据---" + cells[inPos]);
			inPos++ ;
			if (inPos == cells.length) {
				inPos = 0 ;
			}
			count++ ;
			this.notify();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public synchronized void get() {
		try {
			Thread.sleep(100);
			while (count == 0) {
				this.wait();
			}
			
			int data = cells[outPos] ;
			System.out.println("从cells["+ outPos + "]中取出数据" + data);
			cells[outPos] = 0 ;
			outPos++ ;
			if (outPos == cells.length) {
				outPos = 0 ;
			}
			count-- ;
			this.notify();
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}

class Begin implements Runnable{
	private Storage storage ;
	private int num ;
	
	Begin(Storage st) {
	// TODO Auto-generated constructor stub
	this.storage = st ;
	
	}
	
	public void run() {
		while (true) {
			storage.put(num++);
			storage.get();
		}
	}
}


class Over implements Runnable{
	private Storage storage ;
	
	
	Over(Storage st) {
	// TODO Auto-generated constructor stub
	this.storage = st ;
	
	}
	
	public void run() {
		while (true) {
			//storage.put(num++);
			storage.get();
		}
	}
}

public class Example8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Storage storage = new Storage() ;
		Begin begin = new Begin(storage);
		Over over = new Over(storage);
		new Thread(begin).start();
		new Thread(over).start();
		
	}

}
