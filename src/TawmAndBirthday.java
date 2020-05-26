
public class TawmAndBirthday {

	public static void main(String[] args) {
		System.out.println(taumBday(3, 5, 3, 4, 1)); // exp 29
		System.out.println(taumBday(10, 10, 1, 1, 1)); // exp 20
		System.out.println(taumBday(5, 9, 2, 3, 4)); // exp 37
		System.out.println(taumBday(3, 6, 9, 1, 1)); // exp 12
		System.out.println(taumBday(7, 7, 4, 2, 1)); // exp 35
		System.out.println(taumBday(3, 3, 1, 9, 2)); // exp 12
		System.out.println(taumBday(27984, 1402, 619246, 615589, 247954)); // 18192035842
	}
	
	// Complete the taumBday function below.
    static long taumBday(int b, int w, int bc, int wc, int z) {
    	long blc = Math.min(bc, wc+z); // establishes a long variable with the min of bc vs wc+z
    	long whc = Math.min(wc, bc+z); // establishes a long variable with the min of wc vs bc+z

    	return b*blc+w*whc; // discovered that it have to be long
    }

}
