package project04;
/*
 * 银行排号系统
* 很多银行在办理业务的时候，由于资源有限，会对顾客进行排号。
* 银行会开若干个窗口办理业务；
* 当顾客进入银行办理业务时，会被要求到取号机取一个号；
* 窗口空闲时会进行叫号，叫号会按顺序进行，一般来说是先拿到号先被叫到；
*VIP客户拿到的号会优先于所有普通客户，最可能先被叫到；
*VIP客户之间一样有个先后顺序，一般先拿号先被叫到；
*无论如何，都要至少保证30%左右的窗口在办理普通客户的业务，即不能让普通客户无限期等待；
*有的窗口操作员可能会中途休息，即暂停办理业务；
*当天必需办理完所有拿到号的客户的业务才能下班；
*当业务量很大时，会停止取号。
 */

class Person{
	//default: flag = 0, id = tickets ;
	private int flag ;//0-->普通顾客          1-->vip顾客
	private int id ;//得到的票的编号
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(int flag, int id) {
		super();
		this.flag = flag;
		this.id = id;
	}

	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}


class TicketWindow implements Runnable{
	private int tickets = 1 ;
	private int MaxTickets = 200 ;//最大额度的客户量，超出则停止发号
	Person person = new Person(1, 0) ;//1 0
	int count = 0 ;
	
	public void run() {
		while(true) {
			if (tickets >= 1 && tickets < MaxTickets) {
				person.setId(tickets);
				if (person.getFlag() == 0) {
					System.out.println(Thread.currentThread().getName() + "正在呼叫" +  tickets++ + "号普通顾客");
					count++ ;
				}
				else {
						System.out.println(Thread.currentThread().getName() + "正在呼叫" +  tickets++ + "号vip顾客");
						count++ ;
				}
		
				//当tickers = 500, vip顾客服务都已结束，接下来是普通顾客
				while(count == 50) {
					person.setFlag(0);
					System.out.println(Thread.currentThread().getName() + "暂停业务活动，请稍候");
					return ;
				}
				
			}
			
			else {
				System.out.println("当前顾客量较大， 暂时停止取号服务，请择日光临");
				break ;
			}
			
			
			
			try {
				Thread.sleep(100);//sleep
			} catch (InterruptedException e) {//线程休眠时， 错误预警
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}
}

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketWindow tw = new TicketWindow() ;//创建一个实例对象
		new Thread(tw, "窗口 A").start();//创建线程对象并命名为窗口1, 开启线程
		new Thread(tw, "窗口 B").start();//创建线程对象并命名为窗口2, 开启线程
		new Thread(tw, "窗口 C").start();//创建线程对象并命名为窗口3, 开启线程
		new Thread(tw, "窗口 D").start();//创建线程对象并命名为窗口4, 开启线程
	}

}
