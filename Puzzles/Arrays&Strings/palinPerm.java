import java.util.Hashtable;

public class palinPerm {
	public static Boolean palinPerm(String s)
	{
		int count;
		int length = s.length();

		Hashtable<Character, Integer> htable = new Hashtable<Character, Integer>();

		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if (c == ' ')
			{
				length--;
			}
			else 
			{
				if(htable.containsKey(c))
				{
					htable.put(c,htable.get(c)+1);
				}
				else
					htable.put(c, 1);

			}
		}

		System.out.println(htable.toString());

		if (length % 2 == 0)
		{
			count = 0;
		}
		else
			count = 1;

		for (int v : htable.values())
		{
			if (v % 2 != 0)
			{
				count--;
			}
			if (count < 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args)
	{
		String a = "ba ba";
		System.out.println(palinPerm(a));

	}
}