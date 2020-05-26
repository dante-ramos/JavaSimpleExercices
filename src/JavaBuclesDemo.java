import java.util.Scanner;

public class JavaBuclesDemo {
	public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            System.out.printf("a: %d b: %d y n: %d%n", a,b,n);
            int suma = a;
            for (int j=0;j<n;j++) {
            	suma+=Math.pow(2, j)*b;
            	System.out.print(suma+" ");
            }
            System.out.println();
        }
        in.close();
    }
}
