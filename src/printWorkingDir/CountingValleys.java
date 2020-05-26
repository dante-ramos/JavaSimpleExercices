package printWorkingDir;

public class CountingValleys {
	
	public static void main(String[] args) {
		System.out.println(countingValleys(8, "UDDDUDUU"));
		System.out.println(countingValleys(8, "DDUUUUDD"));
	}
	
	static int countingValleys(int n, String s) {
		int valleys = 0;
		int level = 0; // starting level, "sea level"
		
		for(int i=0;i<n;i++) {
			level = s.charAt(i) == 'D' ? level-1 : level+1;
			if (level==0 && s.charAt(i) == 'U') // going up to sea level
				valleys++;
		}
		return valleys;
    }
}
