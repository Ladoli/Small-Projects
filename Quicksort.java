import java.util.Arrays;

public class Quicksort {
	
	static int[] array = {32,82,43,11,99,56,25,61,78};
	static int arraySize = array.length;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	System.out.println(Arrays.toString(array));	 
	quickSorter(0, arraySize-1); 
	System.out.println(Arrays.toString(array));	 
		
				
	}

	
	public static void quickSorter(int left, int right)
	{
		
		if(right - left <= 0)
		{
			return;
		}
		
		else {
			int pivot = array[right];
			int newPivotIndex = arrayPartition(left, right, pivot);
			quickSorter(left, newPivotIndex -1);
			quickSorter(right, newPivotIndex +1);
		}
	
		
		
		
	}
	
	 public static int arrayPartition(int left, int right, int pivot)
		{
			int leftPartitioner = left;
			int rightPartitioner = right;
			boolean needswork = true;
			
			while(needswork)
			{
				
				while(array[leftPartitioner] < pivot)
				{
					leftPartitioner++;
				}
				
				while(rightPartitioner > 0 && array[(--rightPartitioner)] > pivot)
				{
					rightPartitioner--;
					
				}
				
				if(leftPartitioner < rightPartitioner)
				{
					swap(leftPartitioner, rightPartitioner);
				}
				else 
				{
					needswork = false;
				}
				
			}
			
			swap(leftPartitioner, right);
			
			return leftPartitioner;
		}
	 
	 public static void swap(int a, int b)
	 {
		 int temp = array[a];
		 array[a] = array[b];
		 array[b] = temp;
	 }

}
