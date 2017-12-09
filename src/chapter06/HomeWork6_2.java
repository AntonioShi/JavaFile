package chapter06;
import java.util.Date;//Date
import java.util.Calendar;//Calender
import java.text.DateFormat;//DateForm
import java.time.Year;
//P222
public class HomeWork6_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance() ;
		int year = calendar.get(Calendar.YEAR) ;
		int month = calendar.get(Calendar.MONDAY) + 1 ;
		int day = calendar.get(Calendar.DATE) ;
		System.out.println(year +" " + month + " " + day);
		calendar.add(Calendar.DATE, 100);
		Date date = calendar.getTime() ;
		System.out.println(date);
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL) ;
		System.out.println("FULL时间格式" + dateFormat.format(date));
	}

}
