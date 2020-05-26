
public class KangarooJumps {
	static String kangaroo(int x1, int v1, int x2, int v2) {
        if((x1>x2 && v1>v2) || (x1<x2 && v1<v2)) return "NO";
        float result = (x2-x1), resultdown=(v1-(float)v2);
        System.out.println(result);
        result /=resultdown;
        System.out.println(resultdown);
        System.out.println(result);
        if (result >=0.0 && result%1==0.0) return "YES";
        else return "NO";
    }
	public static void main(String[] args) {
		System.out.println(kangaroo(1817, 9931, 8417, 190));
	}
}
