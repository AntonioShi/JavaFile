package project01;
import java.util.Scanner;//导入扫描包

import javax.swing.JOptionPane;

import java.lang.Math ;

public class Example2 {
	public static void main(String[] args) {
//		// TODO Auto-generated method stub

				String str = JOptionPane.showInputDialog(null, "输入投资金额：");
				int investmentAmount = Integer.parseInt(str);
				str = JOptionPane.showInputDialog(null, "输入月利率：");
				double monthlyInterestRate = Double.parseDouble(str);
				str = JOptionPane.showInputDialog(null, "输入年数：");
				int numberOfYears = Integer.parseInt(str);


				double futureInvestmentValue = investmentAmount * Math.pow((1 + monthlyInterestRate * numberOfYears/1200), 12);

				
				System.out.println("futureInvestmentValue" + futureInvestmentValue);
		
		
	}

}

