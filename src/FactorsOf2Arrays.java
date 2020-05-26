
public class FactorsOf2Arrays {

	static int getTotalX(int[] a, int[] b) {
        int factors =0;
        int candidate = a[a.length-1];
        int basenumber = candidate;
        whileloop:
        while (candidate<=b[b.length-1]){
        	System.out.println("Candidate: "+candidate);
            for(int i=a.length-1;i>=0;i--){
            	System.out.println("Compared with a[] " + a[i]);
                if (candidate%a[i]!=0){
                    candidate+=basenumber;
                    System.out.println("Don't!"); 
                    continue whileloop;
                } 
            }
            for (int number : b){
            	System.out.println("Compared with b[] "+ number);
                if (number%candidate!=0){
                    candidate+=basenumber;
                    System.out.println("Dont't!");
                    continue whileloop;
                }
            }
            System.out.println(candidate + " is a factor!!");
            factors++;
            candidate+=basenumber;
        }
        return factors;
    }
	
	public static void main(String[] args) {
		System.out.println(getTotalX(new int[]{3,4}, new int[]{24,48}));
	}
}
