package project02;
import java.util.Scanner;
import java.math.*;

/*
 * Problem statement:
	* Write a loan calculator program that 
	* computes both monthly and total payments for a given loan amount, 
	* annual interest rate, and loan period.
	* 首先在做这道题之前要端正态度，这不是一道题，而是从无到有的一个客户需求的设计到测试到完善的过程。
	* 不可能很快就完成，所以要有耐心
 */

class LoanCalculator{
	
	double Amount, Rate, Period ;//贷款金额，年利率，期限
	double MonthlyPayment, TotalPayment ;

	
	public double getMonthlyPayment() {
		return MonthlyPayment;
	}

	public double getTotalPayment() {
		return TotalPayment;
	}

	
	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public double getRate() {
		return Rate;
	}

	public void setRate(double rate) {
		Rate = rate;
	}

	public double getPeriod() {
		return Period;
	}

	public void setPeriod(double period) {
		Period = period;
	}


	public LoanCalculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void computePayment(double amount, double rate, double period){
		double month, monthly ;
		month = period * 12 ;
		monthly = rate * 0.01 / 12 ;
	
		//等额本息计算公式：〔贷款本金×月利率×（1＋月利率）＾还款月数〕÷〔（1＋月利率）＾还款月数－1〕
		MonthlyPayment = amount * monthly * Math.pow((1 + monthly), month) / ( Math.pow((1 + monthly), month) - 1 );
		
		TotalPayment = MonthlyPayment * 12 + amount;//要付的总钱数
	}
	
	private void describeProgram() {//描述功能
		System.out.println("computePayment 的功能是得到三个参数，计算每月的应付的钱和总共要付的钱");
		System.out.println("start() 的功能是开启小程序，调用其他的方法，开始计算") ;
		System.out.println("displayOutput() 的功能是显示");
		System.out.println("getInput() 的功能得到三个输入进来的参数");
	}
	
	private void displayOutput() {
		

		System.out.println("Monthly payment：" + MonthlyPayment);  
		System.out.println("Total payment：" + TotalPayment); 
	}
	
	private void getInput() {
		//得到三个输入进来的参数
		Scanner inScanner = new Scanner(System.in) ;
		
		//if(inScanner.hasNext()){   
			
			System.out.print("Loan Amount：");  
			Amount = inScanner.nextDouble() ;
			
			System.out.print("Loan Interest Rate："); 
			Rate = inScanner.nextDouble() ;
			
			System.out.print("Loan Period(years)：");  
			Period = inScanner.nextDouble() ;
	     //}  
	}
	
	public void start() {//调用其他方法开始计算
		System.out.println("开始小程序");
		getInput();
		System.out.println() ;
		computePayment(Amount, Rate, Period);
		displayOutput();
		System.out.println() ;
		describeProgram();
		
	}
	
}

public class Example3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoanCalculator loan = new LoanCalculator() ;
		loan.start();
		
		System.out.println();
		
		//为了测试自己输入的数据是否正常
		System.out.println("Loan Amount: $" + loan.getAmount());
		System.out.println("Annual Interest Rate:" + loan.getRate() + "%");
		System.out.println("Loan Period (years):" + loan.getPeriod());
		System.out.println("Monthly payment is         $" +loan.getMonthlyPayment());  
		System.out.println("  Total payment is         $" +loan.getTotalPayment()); 
	}

}


//等额本金计算公式：每月还款金额 = （贷款本金 ÷ 还款月数）+（本金 — 已归还本金累计额）×每月利率






