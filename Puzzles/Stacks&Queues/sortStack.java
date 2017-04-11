import java.util.Arrays;

public class sortStack {
	private int[] myArr;
	private int stackPtr;
	public static final int MAX_CAPACITY = 10;

	public sortStack()
	{
		myArr = new int[MAX_CAPACITY];
		stackPtr = -1;
	}

	public Boolean isEmpty()
	{
		if (stackPtr < 0)
		{
			return true;
		}
		else
			return false;
	}
	public void push(int d)
	{
		myArr[++stackPtr] = d;
	}

	public int peek()
	{
		return myArr[stackPtr];
	}

	public int pop()
	{
		return myArr[stackPtr--];
	}

	public void sortStack()
	{
		sortStack s2 = new sortStack();
		while(!this.isEmpty())
		{
			int tmp = this.pop();
			if(s2.isEmpty() || tmp >= s2.peek())
			{
				s2.push(tmp);
			}
			else 
			{
				int numPopped = 0;
				while(!s2.isEmpty() && s2.peek() > tmp)
				{
					this.push(s2.pop());
					numPopped++;
				}
				s2.push(tmp);
				while(numPopped > 0)
				{
					s2.push(this.pop());
					numPopped--;				
				}
			}
		}

		//this.display();
		//s2.display();
		while(!s2.isEmpty())
		{
			this.push(s2.pop());
		}


	}

	public void display()
	{
		StringBuilder str = new StringBuilder();
		str.append("{ ");
		for (int i = 0; i <= stackPtr; i++)
		{
			str.append(myArr[i] + " ");
		}
		str.append("}");
		System.out.println(str.toString());
	}

	public static void main(String[] args)
	{
		sortStack s1 = new sortStack();
		s1.push(8);
		s1.push(9);
		s1.push(7);
		s1.push(4);
		s1.push(5);
		s1.push(1);
		s1.push(3);
		s1.display();
		s1.sortStack();
		s1.display();
	}
}