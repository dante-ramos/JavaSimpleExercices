
public class Hour12to24 {
	public static void main(String[] args) {
		String s="07:05:45PM";
        System.out.println("\nOriginal: "+s+"\nConvertido: "+convertTime(s));
        s="12:40:22PM";
        System.out.println("\nOriginal: "+s+"\nConvertido: "+convertTime(s));
        s="12:40:22AM";
        System.out.println("\nOriginal: "+s+"\nConvertido: "+convertTime(s));
//        s="07:05:45PM";
//        System.out.println("Original: "+s+"\nConvertido: "+convertTime(s));
//        s="07:05:45PM";
//        System.out.println("Original: "+s+"\nConvertido: "+convertTime(s));
	}
	
	static String convertTime(String s) {
		String ampm = s.substring(8);
		String minsec = s.substring(3, 8);
		String hours = s.substring(0,2);
        switch (ampm) {
	        case "AM":
	        	if (hours.equals("12")) hours="00";
	        	break;
	        case "PM":
	        	if(!hours.equals("12")) hours = String.valueOf(Integer.valueOf(hours) + 12);
	        	break;
        }
        return (hours+":"+minsec);
	}
}
