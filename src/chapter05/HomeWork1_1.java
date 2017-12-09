package chapter05;
/*
 * 线程相加：第4问 he 1
 */
public class HomeWork1_1 {

	public static void main(String[] args) {
		
		MyThread7 myThread = new MyThread7() ;
		new Thread(myThread, "我是线程1").start();//创建两个线程，在构造方法中制定名字， 并要求打印名字
		new Thread(myThread, "我是线程2").start();
		//new Thread(myThread, "我是线程2") ;
		
		
		int i = 0;
		for(; i < 10; i++){
			int orgin = 1 + 10 * i;
			Gettotal p = new Gettotal(orgin);
			p.start();
	}
		
	try {
		Thread.sleep(30);
	} catch (InterruptedException e){
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	System.out.println("10个线程结果相加得：" + Gettotal.total);
	}
		
}

class MyThread7 extends Thread{
	public void run() {
		Thread th = Thread.currentThread() ;
		String th_name = th.getName() ;
		System.out.println(th_name);
 	}
	
	
}

class Gettotal extends Thread{
    public static int total;
    private int num;

    public Gettotal(int n){
    	num = n;
    }
    
    public void run(){
    	
    int tempsum = 0;
    for(int i=0; i<10; i++){
    	tempsum = tempsum + num + i;  //该线程的和求算
    }
    System.out.println( num + " +" +(num +1)+"+"+(num+2)+"+"+(num+3)+"+"+(num+4)+"+"+(num+5)+
    		"+"+(num+6)+"+"+(num+7)+"+"+(num+8)+"+"+(num+9)+"="+tempsum);
    
    total = total + tempsum;//累加计算总和
	
	}
}

