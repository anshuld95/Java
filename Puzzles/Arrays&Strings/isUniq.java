import java.util.HashSet;

public class isUniq {
	public static Boolean isUniqds(String s)
	{
		HashSet<Character> h = new HashSet<Character>();
		for(int i=0; i<s.length(); i++)
		{
			char c = s.charAt(i);
			if(h.contains(c))
			{
				return false;
			}
			h.add(c);
		}
		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(isUniqds("wrong"));
		System.out.println(isUniqds("hello"));
	}

}