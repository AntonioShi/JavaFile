package project03;
import java.util.*;
import project03.LibraryBook;


public class Example02 {

	public static void main(String[] args) {     
		    //Create 4 LibraryBook objects and output them
		    GregorianCalendar dueDate, returnDate;
		    LibraryBook book1, book2, book3, book4;
		        
		    returnDate = new GregorianCalendar(2004, 
		                               Calendar.MARCH, 15);
		        
		    dueDate = new GregorianCalendar(2004,
		                               Calendar.MARCH, 14);
		    book1   = new LibraryBook(dueDate);
		        
		    dueDate = new GregorianCalendar(2004,
		                             Calendar.FEBRUARY, 13);
		    book2   = new LibraryBook(dueDate, 0.75);
		    book2.setTitle("Introduction to OOP with Java");
		    
		    dueDate = new GregorianCalendar(2004,
                    Calendar.JANUARY, 12);
					book3   = new LibraryBook(dueDate, 1.00, 100.00);
					book3.setTitle("Java for Smarties");
					
					dueDate = new GregorianCalendar(2004, 
					                    Calendar.JANUARY, 1);
					book4   = new LibraryBook(dueDate, 1.50, 230.00,
					                     "Me and My Java");
					
					System.out.println(book1);
					System.out.println(book2);
					System.out.println(book3);
					System.out.println(book4);
	}

}
