public class checkPerm {
	public static Boolean checkPerm(String a, String b)
	{
		if (a.length() != b.length())
		{
			return false;
		}

		int[] myArr = new int[128];

		for(int i = 0; i < a.length(); i++)
		{
			myArr[a.charAt(i)]++;
		}

		for(int j = 0; j < b.length(); j++)
		{
			if (myArr[b.charAt(j)] - 1 < 0)
			{
				return false;
			} 
			myArr[b.charAt(j)]--;
		}
		return true;
	}

	public static void main(String[] args)
	{
		String a = "abccccaaabbb";
		String b = "cabaaabbbccc";
		System.out.println(checkPerm(a,b));

		String a2 = "abcccssscs";
		String b2 = "cabbbaaabc";
		System.out.println(checkPerm(a2,b2 ));
	}
}