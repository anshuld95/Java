import java.util.Arrays;

public class sortedMerge {
	public static int[] sortedmerge(int[] a, int[] b, int aLen)
	{
		int aPtr = aLen - 1;
		int bPtr = b.length - 1;
		int insertIdx = a.length - 1;

		while((bPtr >= 0 && aPtr >= 0) && insertIdx >= 0)
		{
			if(b[bPtr] >= a[aPtr])
			{
				a[insertIdx--] = b[bPtr--];
			}
			else
				a[insertIdx--] = a[aPtr--];
		}

		while(bPtr >= 0)
		{
			a[insertIdx--] = b[bPtr--];
		}

		return a;
	}

	public static void main(String[] args)
	{
		int[] a = new int[11];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 5;
		a[4] = 9;
		int[] b = new int[] {4,6,8,10,12,14};

		System.out.println(Arrays.toString(sortedmerge(a,b,5)));
	}
}