import java.util.Arrays;

public class Merge_Sort {
	public static void main(String[] args){
		int[] myArr = new int[] {9,8,7,6,5,4,3,2,1};

		System.out.println("Before Sorting: " + Arrays.toString(myArr));

		recMergeSort(myArr, new int[myArr.length], 0, myArr.length-1);

		System.out.println("After Sorting: " + Arrays.toString(myArr));

	}

	public static void recMergeSort(int[] myArr, int[] temp, int low, int high)
	{
		if(low >= high)
		{
			return;
		}

		int mid = (low+high)/2;
		recMergeSort(myArr, temp, low, mid);
		recMergeSort(myArr, temp, mid+1, high);
		mergeHalves(myArr, temp, low, high);
	}

	public static void mergeHalves(int[] myArr, int[] temp, int low, int high)
	{
		int lowStart = low;
		int lowEnd = (high+low)/2;
		int highStart = lowEnd + 1;
		int idxTemp = 0;
		

		//System.out.println("Full Array: " + Arrays.toString(myArr));

		System.out.println("Merging " + low + " To " + lowEnd + " with " + highStart + " to " + high);

		while(lowStart <= lowEnd && highStart <= high)
		{
			if(myArr[lowStart] <= myArr[highStart])
			{
				temp[idxTemp++] = myArr[lowStart++];
			}
			else
				temp[idxTemp++] = myArr[highStart++];
		}

		while(lowStart <= lowEnd)
		{
			temp[idxTemp++] = myArr[lowStart++];
		}

		while(highStart <= high)
		{
			temp[idxTemp++] = myArr[highStart++];
		}

		System.out.println("temp Array: " + Arrays.toString(temp));

		for (int j=0; j<=high-low; j++)
		{
			myArr[low+j] = temp[j];
		}
		System.out.println("Full Array: " + Arrays.toString(myArr));

	}
}