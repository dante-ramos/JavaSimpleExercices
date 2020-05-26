
public class SaveThePrisoner {

	public static void main(String[] args) {
		System.out.println(saveThePrisoner(5,2,1));
		System.out.println(saveThePrisoner(5,2,2));
		System.out.println(saveThePrisoner(7,19,2));
		System.out.println(saveThePrisoner(3,7,3));
		System.out.println(saveThePrisoner(46934, 543563655, 46743)); // 20809
		System.out.println(saveThePrisoner(999999999, 999999998, 999983945)); // 999983943
		System.out.println(saveThePrisoner(2, 739424390, 2)); // 1
		System.out.println(saveThePrisoner(5, 10, 1)); // 5
	}
	
	static int saveThePrisoner(int n, int m, int s) {
		if (m>n)
			m%=n;
		if (m==0)
			m=n;
		int warned = s-1+m;
		if (warned>n)
			warned-=n;
		return warned;
    }

}
