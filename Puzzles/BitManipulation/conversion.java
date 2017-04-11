public class conversion {
	public static int conversion(int m, int n)
	{
		int count = 0;
		int xor = m ^ n;
		for (int i = 0; i < 32; i++)
		{
			if((xor & (1 << i)) != 0)
			{
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args)
	{
		int m = 29;
		int n = 15;
		System.out.println(conversion(m,n));
	}
}