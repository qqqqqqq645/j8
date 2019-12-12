package calenderEx;
import java.util.Calendar;
import java.time.LocalDateTime;
import java.time.LocalTime;
public class CalenderEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalTime now = LocalTime.now(); 
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"
				+cal.get(Calendar.DATE));
		//System.out.print(now.get(LocalTime.MIN));
		System.out.println(cal.get(cal.HOUR_OF_DAY)+"시"+cal.get(cal.MINUTE)+"분"+cal.get(cal.SECOND));
		
	}

}
