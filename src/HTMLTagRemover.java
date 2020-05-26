import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLTagRemover {
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
        String regex="<(.+)>[\\s]?([^<]+)[\\s]?<(\\/\\1)>", line;
        Matcher m;
        boolean found;
        while (testCases-- > 0) {
        	found = false;
            line = in.nextLine();
            m = Pattern.compile(regex).matcher(line);
            while (m.find()){
                System.out.println(m.group(2));
                found=true;
            } 
            if (!found)
                System.out.println("None");
            System.out.println("ciclo!");
        }
        in.close();
	}
}
