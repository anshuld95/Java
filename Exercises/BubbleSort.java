import java.util.Arrays;

class BubbleSort{
	private int[] myArr;
	private int size;

	public BubbleSort(int len){
		myArr = new int[len];
		size = 0;
	}

	public void insert(int data){
		myArr[size] = data;
		size++;
	}

	public void delete(int data){
		int i = 0;
		while (i < size)
		{
			if (myArr[i] == data)
			{
				for (int j = i; j<size;j++)
				{
					myArr[j] = myArr[j+1]; 
				}
				break;
			}
			i++;
		}
		size--;
	}

	public void sortBubble()
	{
		for (int i =0; i<size-1;i++)
		{
			for (int j=0;j<size-1-i;j++)
			{
				if (myArr[j] > myArr[j+1])
				{
					int temp = myArr[j];
					myArr[j] = myArr[j+1];
					myArr[j+1] = temp;
				}
			}
		}
	}

	public void sortSelection()
	{
		int min;
		int idx = 0;
		while(idx < size)
		{
			min = idx;
			for(int i = idx+1; i < size; i++)
			{
				if (myArr[i] < myArr[min])
				{
					min = i;
				}
			}
			if (min != idx)
			{
				int temp = myArr[idx];
				myArr[idx] = myArr[min];
				myArr[min] = temp;
			}
			idx++;
		}

	}

	public void sortInsertion()
	{
		int marker = 1;
		int mData;
		while (marker < size)
		{
			mData = myArr[marker];
			for(int i=0; i < marker;i++)
			{
				if(myArr[i]>mData)
				{
					for(int j = marker; j>i;j--)
					{
						myArr[j] = myArr[j-1];
					}
					myArr[i] = mData;
					break;
				}
			}
			display();
			marker++;
		}
	}
	
	public void display()
	{
		System.out.println(Arrays.toString(myArr));
	}

	public static void main(String[] args)
	{
		BubbleSort bs = new BubbleSort(10);
		bs.insert(9);
		bs.insert(7);
		bs.insert(4);
		bs.insert(5);
		bs.insert(2);
		bs.insert(3);
		bs.insert(1);
		System.out.println("Before Sorting....");
		bs.display();
		bs.sortInsertion();
		System.out.println("After Sorting....");
		bs.display();
	}
}