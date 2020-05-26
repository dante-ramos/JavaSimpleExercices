import java.util.Scanner;

public class SumStrings {
	public static void main(String[] args) {
		String num = "16";
		System.out.println("Original: "+ num +" suma: "+ sumstrings(num) +" esperado 23");
		num = "123";
		System.out.println("Original: "+ num +" suma: "+ sumstrings(num) +" esperado 164");
		num = "6543";
		System.out.println("Original: "+ num +" suma: "+ sumstrings(num) +" esperado 7920");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number! ");
		String n = sc.next().trim();
		sc.close();
		System.out.println("suma: "+ sumstrings(n) +" esperado 856765586");
	}
	static long sumstrings (String n) {
		Long sum=0l;
		Long mod=1000000007l;
        String[] s = n.split("");
        Long multiplier=1l;
        int num;
        for(int i=s.length-1; i>=0;i--) {
        	num=Integer.valueOf(s[i]);
        	sum+=(num*multiplier*(i+1))%mod;
        	System.out.println(sum +" con el número "+ num + " el multiplicador "+ multiplier + " y las veces "+ (i+1));
        	multiplier = (multiplier*10+1)%mod;
        }
        
        return Integer.parseInt(Long.toString(sum))%mod;
	}
}
