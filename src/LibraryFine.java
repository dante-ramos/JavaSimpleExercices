
public class LibraryFine {

	public static void main(String[] args) {
		System.out.println(libraryFine(15, 7, 2014, 1, 7, 2015));
		System.out.println(libraryFine(9, 6, 2015, 6, 6, 2015));
		System.out.println(libraryFine(1, 1, 2018, 31, 12, 2017));
	}
	
	static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
		if (y1>y2)
			return 1000;
		else if(y1==y2) {
			if(m1>m2)
				return (m1-m2)*500;
			else if(m1==m2)
				if(d1>d2)
					return (d1-d2)*15;
			
		}
		return 0;
    }

}
