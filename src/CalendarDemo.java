import java.time.LocalDate;

public class CalendarDemo {
	public static String findDay(int month, int day, int year) {
		LocalDate date = LocalDate.of(year, month, day);
//		Calendar date = new GregorianCalendar(year,month-1,day);
//		int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
//		return new SimpleDateFormat("EEEE").format(dayOfWeek).toUpperCase();
		return date.getDayOfWeek().toString();
    }
	public static void main(String[] args) {
		System.out.println(findDay(8,5,2015)); 
	}
}
