import java.util.Scanner;

public class FibonacciRecursivo {

	public static void main(String[] args) {
		System.out.println("Cuántos numeros en la serie fibonacci?");
		Scanner scann = new Scanner(System.in);
		int numero = scann.nextInt();
		System.out.println();
		for(int i=0;i<numero;i++) {
			System.out.print(fibbo(i)+" ");			
		}
		scann.close();
	}
	
	public static int fibbo(int cantidad) {
		if (cantidad ==0 || cantidad ==1) {
			return 1;
		}
		return fibbo(cantidad-1)+fibbo(cantidad-2);
	}
}
