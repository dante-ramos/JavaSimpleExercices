import java.util.Scanner;

public class StdInWScanner{
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		double d = scan.nextDouble();
		scan.nextLine();
		String s = scan.nextLine();
		int i2 = scan.nextInt();
		String s2 = scan.nextLine();
		System.out.println("Outputs!!");
		System.out.println(s);
		System.out.println(d);
		System.out.println(i);
		System.out.println(s2);System.out.println(i2);
		scan.close();
	}
}
