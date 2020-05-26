public class DayOfTheprogrammer {
	
	public static void main(String[] args) {
		System.out.println("The date of the day of the programmer for year 1800 is "  + dayOfProgrammer(1800));
		System.out.println("The date of the day of the programmer for year 2016 is "  + dayOfProgrammer(2016));
		System.out.println("The date of the day of the programmer for year 1918 is "  + dayOfProgrammer(1918));
	}

	static String dayOfProgrammer(int year) {
		int[] daysPMonth = {31,0,31,30,31,30,31,31,30,31,30,31}; // days per month by default 
		String calendar; // will contain the calendar name given the year
		
		calendar = defineCalendar(year);
		switch (calendar) {
		case "julian":
			daysPMonth[1] = year%4.0 == 0 ? 29 : 28;
			return getDate(daysPMonth, year);
		case "gregorian":
			daysPMonth[1] = (year%400.0==0 || (year%4.0==0 && year%100.0 !=0))  ? 29 : 28;
			return getDate(daysPMonth, year);
		case "transition":
			daysPMonth[1] = 15;
			return getDate(daysPMonth, year);
		default:
			return "Invalid year!!";
		}
    }
	
	static String defineCalendar(int year) {
		String result = year<1918 ? "julian" : "gregorian";
		result = year==1918 ? "transition" : result;
		return result;		
	}
	
	static String getDate(int[] daysPMonth, int year) {
		int sum=0;
		int day,month=0;
		for (int i=0;i<12;i++) {
			sum+=daysPMonth[i];
			if (sum>256) {
				month = i+1;
				sum-=daysPMonth[i];
				break;
			} 
		}
		day = 256 -sum;
//		SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
		return String.format("%02d.%02d.%d", day,month,year);
	}
}
