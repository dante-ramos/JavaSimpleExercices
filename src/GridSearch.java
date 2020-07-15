/// https://www.hackerrank.com/challenges/the-grid-search/problem
public class GridSearch {

	public static void main(String[] args) {
		System.out.println(GridSearch.gridSearch(
				new String[]{"444444","433224","422224","411114","433224","444444"},
				new String[]{"22","11","22"}));
		System.out.println(GridSearch.gridSearch(
				new String[]{"999999","121211"},
				new String[]{"99","11"}));
	}

	@SuppressWarnings("unused")
	static String gridSearch(String[] G, String[] P) {
		String ret = "NO";
		int posG = 0; // walk each G line
		int posGFoundH; // character where the pattern has been found
		int p0Len;
		
		int matchingLines;
		
		String tmpLine;
		String tmpLineSub;
		String pLine;
				
		p0Len = P[0].length();
		// walk the G array until there's no room for a patter coincidence
		mainLoop:
		while(posG + P.length <= G.length)
		{
			// look if patter occurs starting in this line
			posGFoundH = 0;
			tmpLine = G[posG];
			// for each occurrence of P in current line of G
			while(G[posG].substring(posGFoundH).contains(P[0])) 
			{
				matchingLines = 1;
				posGFoundH = G[posG].substring(posGFoundH).indexOf(P[0]) + posGFoundH; // get occurrence first character position
				tmpLineSub = G[posG].substring(posGFoundH, posGFoundH + p0Len);
				for(int i=1 ; i<P.length ; i++) // check if each line from G[posG +i] is equal to P[i] where i starts in 1 (0 is obvious)
				{
					pLine = P[i];
					tmpLineSub = G[posG+i].substring(posGFoundH, posGFoundH + p0Len);
					if(G[posG+i].substring(posGFoundH, posGFoundH + p0Len).equals(P[i])) // matches
					{
						matchingLines ++;
					}
					else
					{
						break;// try the next occurrence
					}
				}
				// if the number of matching lines are equal to the P array length, there's a complete match!!
				if(matchingLines == P.length)
				{
					ret = "YES";
					break mainLoop;
				}
				
				// know if there could be another occurrence in this G line
				posGFoundH++;
				if(posGFoundH + P[0].length() -1 == G[0].length()) // if there isn't room for more occurrences
				{
					break; // goes to next G line
				}
				// else go to next occurrence in this G line
			}
			posG++; // goes to next G line
		}
		return ret;
    }
}
