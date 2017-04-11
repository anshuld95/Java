import java.util.Arrays;

class myStack{
	private int[] myArr;
	private int size;

	public myStack(int maxSize)
	{
		myArr = new int[maxSize];
		size=0;
	}

	public void push(int data)
	{
		myArr[size] = data;
		size++;
	}

	public int peek()
	{
		return myArr[size-1];
		
	}

	public int pop()
	{
		int temp = myArr[size-1];
		size--;
		return temp;
	}

	public boolean isEmpty()
	{
		if(size==0)
		{
			return true;
		}
		else
			return false;

	}
	
	public void display()
	{
		System.out.print("[ ");
		for(int i=0; i<size; i++)
		{
			System.out.print(myArr[i] + " ");
		}
		System.out.println(" ]");
	}
	public static void main(String[] args)
	{
		myStack st = new myStack(10);
		st.push(9);
		st.push(8);
		st.push(10);
		st.push(11);
		st.push(6);
		st.push(2);
		System.out.println(st.pop());
		st.display();
		st.pop();
		st.pop();
		st.pop();
		st.display();
	}
}