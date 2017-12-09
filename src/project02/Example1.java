package project02;
import java.util.Date;//得到当前系统时间的包
/*
 * Project: The Account Class


Problem Description:
(The Account class) Design a class named Account that contains: 
A private int data field named id for the account (default 0).
A private double data field named balance for the account (default 0).
A private double data field named annualInterestRate that stores the current interest rate (default 0).
Assume all accounts have the same interest rate.
A private Date data field named dateCreated that stores the date when the account was created.
A no-arg constructor that creates a default account.
A constructor that creates an account with the specified id and initial balance.
The accessor and mutator methods for id, balance, and annualInterestRate. 
The accessor method for dateCreated. 
A method named getMonthlyInterestRate() that returns the monthly interest rate.
A method named withdraw that withdraws a specified amount from the account.
A method named deposit that deposits a specified amount to the account.

Draw the UML diagram for the class. 
Implement the class. 
Write a test program that creates an Account object 
with an account ID of 1122, a balance of $20,000, and an annual interest rate of 4.5%. 
Use the withdraw method to withdraw $2,500, use the deposit method to deposit $3,000, 
and print the balance, the monthly interest, and the date when this account was created.

 */


class Account{//帐户类
	private int account = 0 ;
	private double balance = 0 ;
	private double annuallnterestRate = 0 ;//假设所有的账户具有相同的利率
	private Date dateCreated ;//date package
	
	//无参构造
	public Account() {
		super();
		this.dateCreated = new Date() ;
		
	}	
	
	//有参构造
	public Account(int account, double balance) {
		super();
		this.account = account;
		this.balance = balance;
		this.dateCreated = new Date() ;
	   
	}
	//访问器
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnuallnterestRate() {
		return annuallnterestRate;
	}
	public void setAnnuallnterestRate(double annuallnterestRate) {
		this.annuallnterestRate = annuallnterestRate * 0.01;
	}
	public Date getDateCreated() {
		return dateCreated;
	}


	//
	public double getMonthlyInterestRate() {
		return (annuallnterestRate / 12) ;//返回月利率
	}
	public int withdraw(int money) {//提款
		balance -= money ;
		return money ;
	}
	public void save(int money) {
		balance += money ;
		
	}
}


public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account account = new Account(1122, 20000) ;
		account.setAnnuallnterestRate(4.5);
		
		//withdraw
		account.withdraw(2500) ;
		account.save(3000);
		
		//print
		System.out.println("提取金额" +2500 +"   余额" + account.getBalance()+ "   每月利息" + account.getMonthlyInterestRate() + "   创建日期" + account.getDateCreated());
		
	}

}

