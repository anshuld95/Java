public class parens {
	public static String parens(int num)
	{
		if (num == 1)
		{
			return "()";
		}

		StringBuilder str = new StringBuilder();
		for(int i = 0; i < num; i++)
		{
			str.append(parens(num-1));
		}
		return str.toString();

	}

	public static void main(String[] args)
	{
		System.out.println(parens(2));
	}
}