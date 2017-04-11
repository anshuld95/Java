public class strRotate {
	public static Boolean strRotate(String a, String b)
	{
		for(int i = 0; i < a.length(); i++)
		{
			char c = a.charAt(i);
			if(b.charAt(0) == c)
			{
				int k = 0;
				int j = i;
				Boolean match = true;
				while(j < a.length())
				{
					if(b.charAt(k) != a.charAt(j))
					{
						match = false;
						break;
					}
					else
					{
						j++;
						k++;
					}
				}
				if (match == true)
				{
					if(b.substring(a.length()-i).equals(a.substring(0,i)) )
					{
						return true;
					}
					else
						return false;
				}
			}
		}
		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(strRotate("car", "arc"));
	}
}