package chapter05;

public class Example10 extends Thread {
		private int stratNum;
		public static int sum;
		public Example10(int startNum) {
			this.stratNum = startNum;
		}
		public static synchronized void add(int num) {
			sum += num;
		}
		public void run() {
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				sum += stratNum + i;
			}
			add(sum);
		}
		
		public static void main(String[] args) throws Exception {
			Thread[] threadList = new Thread[10];//线程数组
			
			for (int i = 0; i < 10; i++) {
				threadList[i] = new Example10(10 * i + 1);
				threadList[i].start();
			}
			for (int i = 0; i < 10; i++) {
				threadList[i].join();
			}
			System.out.println("Sum is : " + sum);
		}
	}