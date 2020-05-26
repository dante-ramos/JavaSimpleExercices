/// https://www.hackerrank.com/challenges/angry-professor/problem
import java.util.Scanner;

public class AngryProfessor {
	static String angryProfessor(int k, int[] a) {
		for(int arrival : a) {
			if(arrival<0)
				k--;
		}
		if(k>0)
			return "YES";
		return "NO";
    }
	
	public static void main (String[] args) {
		Scanner scann = new Scanner(System.in);
		int minStudents;
		String arrivalsString;
		String[] arrivalsStringArr;
		int[] arrivals;
		do {
			System.out.println("Whats the minimum of students? ");
			minStudents = scann.nextInt();
			System.out.println("Enter a string of arrivals separated with blanc spaces ");
			scann.nextLine();
			arrivalsString = scann.nextLine();
			
			if (arrivalsString.length()==0)
				break;
			
			arrivalsStringArr = arrivalsString.split(" ");
			arrivals = new int[arrivalsStringArr.length];
			for (int i=0;i<arrivals.length;i++)
				arrivals[i] = Integer.parseInt(arrivalsStringArr[i]);
				
			System.out.println("Cancelled class? " + angryProfessor(minStudents, arrivals));
		} while (true);
		
		scann.close();
	}
}

/*10 4
-93 -86 49 -62 -90 -63 40 72 11 67
NO
10 10
23 -35 -2 58 -67 -56 -42 -73 -19 37
YES
10 9
13 91 56 -62 96 -5 -84 -36 -46 -13
YES
10 8
45 67 64 -50 -8 78 84 -51 99 60
YES
---------    10 7
26 94 -95 34 67 -97 17 52 1 86
YES
10 2
19 29 -17 -71 -75 -27 -56 -53 65 83
NO
10 10
-32 -3 -70 8 -40 -96 -18 -46 -21 -79
YES
10 9
-50 0 64 14 -56 -91 -65 -36 51 -28
YES
10 6
-58 -29 -35 -18 43 -28 -76 43 -13 6
NO
10 1
88 -17 -96 43 83 99 25 90 -39 86
NO
*/