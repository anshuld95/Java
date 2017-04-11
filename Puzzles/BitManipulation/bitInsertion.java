import java.lang.Math;

public class bitInsertion {
	public static int bitInsert(int n, int m, int i, int j)
	{
		int mask = (1 << (i+j)) - 1;
		int mask2 = (-1 << i);
		mask = mask & mask2;
		n = ~mask & n;

		m <<= i;
		return m | n;


	}

	public static void main(String[] args)
	{
		int n = 0b10010010010;
		int m = 19;
		int i = 2;
		int j = 6;
		//System.out.println(Integer.toBinaryString(n));
		//System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(bitInsert(n,m,i,j)));
	}
}