public class PagesToTurn {

	public static void main(String[] args) {
		System.out.println(pageCount(6, 2));
		System.out.println(pageCount(5, 4));
	}
	
	static int pageCount(int n, int p) {
        int turnsFromFront=getTurnsFromFront(n,p);
        int turnsFromBack=getTurnsFromBack(n,p);
        
		return Math.min(turnsFromBack, turnsFromFront);
    }
	
	static int getTurnsFromFront(int tpages, int opage) {
		tpages = tpages%2==0 ? tpages+1 : tpages;
		int turns =0;
		for (int i=1;i<=tpages; i+=2) {
			if (i>=opage)
				return turns;
			turns++;
		}
		return -1 ; // page not encountered
	}
	
	static int getTurnsFromBack(int tpages, int opage) {
		tpages = tpages%2!=0 ? tpages-1 : tpages;
		int turns = 0;
		for (int i=tpages;i>=0; i-=2) {
			if (i<=opage)
				return turns;
			turns++;
		}
		return -1; // page not encountered
	}
}
