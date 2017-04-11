import java.lang.Math;
import java.util.Hashtable;

public class oneAway {
	public static Boolean oneAway(String a, String b)
	{
		if (b.length() < a.length()-1 || b.length() > a.length()+1)
			return false;

		if (a.equals(b))
			return true;

		Hashtable<Character, Integer> htable = new Hashtable<Character, Integer>();

		for (int i = 0; i < a.length(); i++)
		{
			char c = a.charAt(i);
			if(htable.containsKey(c))
			{
				htable.put(c, htable.get(c)+1);
			}
			else
				htable.put(c,1);
		}

		for (int j = 0; j< b.length(); j++)
		{
			char c = b.charAt(j);
			if(htable.containsKey(c))
			{
				htable.put(c, htable.get(c)-1);
			}
			else
				htable.put(c,1);
		}

		int sum = 0;
		for (int count : htable.values())
		{
			sum+=count;
		}

		if(sum >= -1 && sum <= 2)
			return true;
		else 
			return false;
	}

	public static void main(String[] args)
	{
		System.out.println(oneAway("pale", "ple"));
		System.out.println(oneAway("pales", "pale"));
		System.out.println(oneAway("pale", "bale"));
		System.out.println(oneAway("pale", "bake"));
	}
}