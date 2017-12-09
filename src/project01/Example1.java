package project01;
import javax.swing.JOptionPane;
/*
 * 框架式信息处理
 */

public class Example1 {
	public static void main(String []args) {
		String name, first, middle, last, space, monogram;

		space = " ";
		// Input the full name
		//name = JOptionPane.showInputDialog(null, "Enter your full name (first, middle, last): ");

		name = JOptionPane.showInputDialog(null, "Enter your full name (first + space + middle + space +last): ");
		// Extract first, middle, and last names
		first = name.substring(0, name.indexOf(space));
		name = name.substring(name.indexOf(space) + 1, name.length());
		middle = name.substring(0, name.indexOf(space));
		last = name.substring(name.indexOf(space) + 1, name.length());
		// Compute the monogram
		monogram = first.substring(0, 1) + middle.substring(0, 1) + last.substring(0, 1);
		// Output the result
		JOptionPane.showMessageDialog(null, "Your 	monogram is " + monogram);
		
		System.out.println(monogram);
	}

}
