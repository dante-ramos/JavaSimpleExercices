import java.util.Scanner;

public class RegularExIntroDemo {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] result = s.split("[^a-zA-Z]+");
        System.out.println(result.length);
        for (String subString: result)
            System.out.println(subString);
        scan.close();
    }
}
