
public class BeautifulDaysAtMovies {
	static int beautifulDays(int i, int j, int k) {
		int beautifulDays=0;
		int reversed;
		for(int x=i;x<=j;x++) {
			reversed = reverse(x);
			if (Math.abs(x-reversed)%k==0)
				beautifulDays++;
		}
		return beautifulDays;
    }
	
	static int reverse(int x) {
		String stringX = Integer.toString(x);
		String reversed = "";
		for(int i=stringX.length()-1;i>=0;i--) {
			if(reversed.length()!=stringX.length()-1 || stringX.charAt(i) != '0')
				reversed+=stringX.charAt(i);
		}
		return Integer.parseInt(reversed);
	}
	
	public static void main(String[] args) {
		System.out.println(beautifulDays(20, 23, 6));
	}
}
