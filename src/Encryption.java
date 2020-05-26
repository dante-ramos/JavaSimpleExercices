
public class Encryption {

	public static void main(String[] args) {
		System.out.println(encryption(" have a nice day ")); // expected: hae and via ecy
		System.out.println(encryption("feedthedog")); // expected: fto ehg ee dd
		System.out.println(encryption("chillout")); // clu hlt io
		System.out.println(encryption("iffactsdontfittotheorychangethefacts")); // isieae fdtonf fotrga anoyec cttctt tfhhhs
	}
	
	static String encryption(String s) {
        s=s.replaceAll(" ", ""); // clean the string of spaces
        
        int len = s.length();
        int rows = (int) Math.sqrt(len);
        int cuts = rows*rows==len ? rows : rows+1;
        if(len>cuts*rows) {
        	rows++;
        }
        
        if(cuts*rows>len) {
        	StringBuilder spaces = new StringBuilder();
        	for(int i=0;i<(cuts*rows)-len;i++) {
        		spaces.append(' ');
        	}
        	s+=spaces.toString();
        }
        
        String[] rowArray=new String[rows];
        for(int i=0;i<rows;i++) {
        	rowArray[i] = s.substring(cuts*i,cuts*(i+1));
        }
        
        StringBuilder result=new StringBuilder();
        char character;
        for(int i=0;i<cuts;i++) {
        	for(int j=0;j<rows;j++) {
        		character = rowArray[j].charAt(i);
        		if(character!=' ')
        			result.append(character);
        	}
        	result.append(' ');
        }
        return result.toString();
    }
}
