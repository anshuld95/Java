import java.util.Arrays;
import java.util.Random;

public class advSorting{
	public static void main(String[] args)
	{
		int[] myArr = new int[] {1,3,5,6,7,4,9,3,2,33,2,5,3,5,3,2,5,6,7,4,6,7,8,7,8,9};
		System.out.println("Before Sorting: " + Arrays.toString(myArr));
		recQuickSort(myArr, myArr.length-1, 0, myArr.length-2);
		System.out.println("After Sorting: " + Arrays.toString(myArr));

	}

	public static void shellSort(int[] myArr)
	{
		int h = 1;
		while (h < myArr.length / 3)
		{
			h = 3*h +1;
		}

		int idxIn;
		int idxOut;
		int temp;
		while(h>0)
		{
			if (h==1)
			{
				System.out.println("Pre h=1: " + Arrays.toString(myArr));
			}
			for (idxOut = h; idxOut<myArr.length; idxOut++)
			{
				temp = myArr[idxOut];
				idxIn = idxOut;
				while(idxIn	> h-1 && myArr[idxIn-h] > temp)
				{
					myArr[idxIn] = myArr[idxIn-h];
					idxIn -= h;
					myArr[idxIn] = temp;
				}
			}
			h = (h-1) / 3;
		}
	}

	public static void recQuickSort(int[] myArr, int pivot, int left, int right)
	{
		if(left>right)
		{
			return;
		}

		System.out.println("Before partitioning: " + Arrays.toString(myArr));
		System.out.println("Pivot is: " + pivot);
		System.out.println("left is: " + left);
		System.out.println("right is: " + right);
		int newpivot = partition(myArr, pivot, left, right);
		System.out.println("After partitioning: " + Arrays.toString(myArr));
		System.out.println("New Pivot is: " + newpivot);
		recQuickSort(myArr, newpivot-1, left, newpivot-2);
		recQuickSort(myArr, right+1, newpivot+1, right);
	}


	public static int partition(int[] myArr, int pivot, int left, int right)
	{
		while(true)
		{
			while(myArr[left] < myArr[pivot] && left < pivot)
			{
				left++;
				continue;
			}
			//System.out.println("left is: " + left);

			while(myArr[right] > myArr[pivot] && right>0)
			{
				right--;
				continue;
			}
			if(left>right)
			{
				break;
			}
			if(myArr[left] == myArr[right])
			{
				left++;
				right--;
			}
			else
				swap(myArr, left, right);
		}
		swap(myArr, left, pivot);
		return left;
	}

	public static void swap(int[] myArr, int a, int b)
	{
		int temp = myArr[a];
		myArr[a] = myArr[b];
		myArr[b] = temp;
	}

}