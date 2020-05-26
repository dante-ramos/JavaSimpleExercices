import java.util.Scanner;

public class StringReverseDemo {
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        sc.close();
        StringBuilder reversedA = new StringBuilder();
        for (int i=A.length()-1;i>=0;i--){
            reversedA.append(A.charAt(i));
        }
        
        System.out.println(A + " reversed: " + reversedA);
        
        
        if (A.contentEquals(reversedA))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
