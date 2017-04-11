import java.util.Hashtable;

public class strCompress {
	public static String strCompress(String a)
	{
		Hashtable<Character, Integer> h = new Hashtable<Character, Integer>();

		for (int i = 0; i < a.length(); i++)
		{
			char c = a.charAt(i);
			if(h.containsKey(c))
			{
				h.put(c, h.get(c)+1);
			}
			else
				h.put(c, 1);
		}

		StringBuilder mystr = new StringBuilder();
		for (char c : h.keySet())
		{
			mystr.append(c);
			mystr.append(h.get(c));
		}

		if (mystr.length() < a.length()) 
			return mystr.toString();
		else
			return a;
	}

	public static String compress(String a)
	{
		char prev = a.charAt(0);
		int curCount = 1;
		StringBuilder str = new StringBuilder();
		str.append(prev);
		for (int i = 1; i < a.length(); i++)
		{
			char c = a.charAt(i);
			if (c != prev)
			{
				str.append(curCount);
				str.append(c);
				curCount = 1;
				prev = c;
			}
			else
			{
				curCount++;
				
			}
		}
		str.append(curCount);

		if (str.length() < a.length())
			return str.toString();
		else
			return a;
	}

	public static void main(String[] args)
	{
		System.out.println(compress("aabcccccaaa"));
	}
}