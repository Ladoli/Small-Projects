import java.util.Arrays;

public class Quicksort {
	
	static int[] array = {32,82,43,11,99,56,25,61,78};
	static int arraySize = array.length;
	static int recursion = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	System.out.println(Arrays.toString(array));	 
	quickSorter(0, arraySize-1);  
	System.out.println(Arrays.toString(array));	
	System.out.println(recursion);	
	//Is... is this amount of recursion normal?!

		
		
		
		
				
	}

	
	public static void quickSorter(int left, int right)
	{
		recursion++;
		
		if (array == null || array.length == 0) 
		{
			return; 
		}

		
		if(right - left <= 0)
		{
			return;
		}
		
		else {
			int leftPartitioner = left;
			int rightPartitioner = right;
			int pivot = array[left+(right-left)];
			while(leftPartitioner <= rightPartitioner)
			{
				while(array[leftPartitioner] < pivot)
				{
					leftPartitioner++;
				}
				
				while(array[rightPartitioner] < pivot)
				{
					rightPartitioner++;
				}
				
				if(leftPartitioner <= rightPartitioner)
				{
					swap(leftPartitioner, rightPartitioner);
					leftPartitioner++;
					rightPartitioner--;
				}
				
				if(left<rightPartitioner)
				{
					System.out.println("Quick sorting " + array[left] + ", " + array[rightPartitioner]);
					quickSorter(left,rightPartitioner);
				}
				
				if(leftPartitioner<right)
				{
					System.out.println("Quick sorting " + array[leftPartitioner] + ", " + array[right]);
					quickSorter(leftPartitioner, right);
				}
			}
			
		}
	
		
		
		
	}
	
	 
	 public static void swap(int a, int b)
	 {
		 if(a==b)
		 {
			 
		 }
		 else
		 {
			 System.out.println("Swapping " + array[a] +" and " +array[b]);
			 int temp = array[a];
			 array[a] = array[b];
			 array[b] = temp;
			 System.out.println(Arrays.toString(array));	
		 }
	 }
	 
	 
}
