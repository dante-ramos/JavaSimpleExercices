
public class HappyLabybugs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(happyLadybugs("AABCBC"));
		// System.out.println(happyLadybugs("RBY_YBR"));
	}

	static String happyLadybugs(String b) {
        String ret = "YES";
        String bEmpty;
        if(b.contains("_") || alreadyHappyLadyBugs(b))
        {
            b=b.replace("_","");
            while(b.length()>0)
            {
            	bEmpty = b.replace(b.substring(0,1),"");
                if(b.length() - bEmpty.length() == 1 )
                {
                    ret = "NO";
                    break;
                }
                b = bEmpty;
            }
        }
        else
        {
            ret = "NO";
        }
        return ret;
    }
	
	static boolean alreadyHappyLadyBugs(String b)
	{
		boolean ret = true;
		boolean partOfContinuousGroup;
		partOfContinuousGroup = false;
		for (int i = 1 ; i < b.length() ; i++)
		{
			if(b.charAt(i) == b.charAt(i-1))
			{
				partOfContinuousGroup = true;
			}
			else
			{
				if(partOfContinuousGroup)
				{
					partOfContinuousGroup = false;
				}
				else
				{
					ret = false;
					break;
				}
			}
			
		}
		
		return ret;
	}
}
