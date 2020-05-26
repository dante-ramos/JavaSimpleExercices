
public class Fibbonacci1 {

	public static void main(String[] args) {
//		int n1=0, n2=1, sum=0;
//		System.out.print(n1+" "+n2+" ");
//		for(int i=0;i<20;i++) {
//			sum = n1+n2;
//			System.out.print(sum+" ");
//			n1=n2;
//			n2=sum;	
//		}
		
		int n1=0, n2=1;
		for(int i=0;i<100;i++) {
			System.out.print(n1+" ");
			i = n1+n2;
			n1=n2;
			n2=i;
		}
		System.out.println(System.getProperty("user.dir")+"/");
	}
}
