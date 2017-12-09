package project03;
import java.util.*;
import java.text.*;

public class LibraryBook {

   // default values
   private static final double CHARGE_PER_DAY = 0.50;//每天单价
   private static final double MAX_CHARGE = 50.00;    //最大额度
   private static final String DEFAULT_TITLE = "Title unknown";//错误条目
 
   private GregorianCalendar dueDate;   //过期日期
   private String title;//条目
   private double chargePerDay; //过期单价
   private double maximumCharge;//最大价格
   
   double  getChargePerDay( ) {
	   return 0;
}
   GregorianCalendar getDueDate( ) {
	   return dueDate;
}
   double  getMaxCharge( ) {
	   return 0;
}
   String  getTitle( ) {
	   return title;
}

   void setChargePerDay(double b) {
	   return ;
}
   void setDueDate(GregorianCalendar gCalendar ) {
	   return ;
}
   void setMaxCharge(double d) {
	   return ;
}
   void  setTitle(String str) {
	   return ;
}

   public String toString( ) {     

	      String tab = "\t";
	        
	      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
	      DecimalFormat     df = new DecimalFormat("0.00");
	        
	      return getTitle() + tab + "$ " + 
	             df.format(getChargePerDay()) + tab + "$ " +
	             df.format(getMaxCharge()) + tab + 
	             sdf.format(dueDate.getTime());
	   }
   
   // Constructors构造函数:
   public LibraryBook(GregorianCalendar dueDate) {  
      this(dueDate, CHARGE_PER_DAY);
   }
    
   public LibraryBook(GregorianCalendar dueDate, 
                      double chargePerDay) {                        
      this(dueDate, chargePerDay, MAX_CHARGE);
   }

   public LibraryBook(GregorianCalendar dueDate, 
                      double chargePerDay, 
                      double maximumCharge) {       
      this(dueDate, chargePerDay,
           maximumCharge, DEFAULT_TITLE);
   }

   public LibraryBook(GregorianCalendar dueDate, 
           double chargePerDay, 
           double maximumCharge,
           String title) {                            
		setDueDate(dueDate);
		setChargePerDay(chargePerDay);
		setMaximumCharge(maximumCharge);
		setTitle(title);
}
   
public void setMaximumCharge(double maximumCharge2) {
	// TODO Auto-generated method stub
	System.out.println(DEFAULT_TITLE);
}

}






