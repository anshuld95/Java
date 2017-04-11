import java.util.Arrays;

public class powerSet {
	public static void powerSet(int[] set, int windowSize)
	{
		int n = set.length;
		if (windowSize == 0)
		{
			System.out.println("{}");
			return;
		}

		if (n == windowSize)
		{
			System.out.println(windowSize + ": " + Arrays.toString(set));
			powerSet(set, windowSize-1);
			return;
		}  

		StringBuilder str = new StringBuilder();
		str.append(windowSize + ": ");
		int numAppended = 0;

		for (int i = 0; i<=n-windowSize; i++)
		{
			for(int j = i+1; j < n; j++)
			{
				str.append("{");
				str.append(set[i]);
				numAppended++;
				if (numAppended == windowSize)
				{
					str.append("}");
					numAppended=0;
					if(windowSize==1)
					{
						break;
					}
				}
				else
				{
					str.append(","+set[j]);
					numAppended++;	
					if (numAppended == windowSize)
					{
						str.append("}");
						numAppended=0;
					}
				}
			}
		}
		if(windowSize==1)
		{
			str.append("{" + set[n-1] + "}");
		}
		System.out.println(str.toString());
		powerSet(set, windowSize-1);
	}

	public static void main(String[] args)
	{
		int[] set = new int[] {1,2,3};
		powerSet(set, 3);

	}
}