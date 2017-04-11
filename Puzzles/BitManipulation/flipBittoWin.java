public class flipBittoWin {
	public static int flipBittoWin(int n)
	{
		int count = 1;
		int totalseq = 0;
		int midseq = 0;
		int maxseq = 0;
		Boolean metZero = false;
		for (int i = 0; i<32; i++)
		{
			if ((n & (1 << i)) != 0) 
			{
				totalseq++;
				if(metZero == true)
				{
					midseq++;
				}
			}
			else
			{
				if (metZero == false)
				{
					metZero = true;
					totalseq++;
				}
				else
				{
					if (totalseq > maxseq)
					{
						maxseq = totalseq;
					}
					totalseq = midseq;
					midseq = 0;
					metZero = false;
				}
			}
		}
		return maxseq;
	}
	public static void main(String[] args)
	{
		int n = 0b11011101111;
		System.out.println(flipBittoWin(n));

	}
}