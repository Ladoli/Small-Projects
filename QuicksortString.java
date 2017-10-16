import java.util.Arrays;

public class QuicksortString {
	
	static String[] array = {"32","82","43","11","99","56","25","61","78"};
	static int arraySize = array.length;
	//static int recursion = 0;
	//To check recursion efficiency
	public static void main(String[] args) {

	System.out.println(Arrays.toString(array));	 
	quickSorter(0, arraySize);
	System.out.println(Arrays.toString(array));	
	//System.out.println(recursion);		
	}

	
	public static void quickSorter(int left, int right)
	{
		
		if (array == null || array.length == 0 || left >= right-1 || left == right ) 
		{
			return; 
		}
	     //recursion++;
		 //System.out.println("New recursion with element " +left + " and " + right);	
	     int front = left - 1, last = right - 1;
	     String pivot = array[last];
	     boolean needsWork = true;
	     while (needsWork)
	     {
	         while (array[++front].compareTo(pivot) < 0);
	         while (array[--last].compareTo(pivot) > 0  && last > left);
	         if (front < last)
	         {
	             swap(front,last);
	         }
	         else if(front != (right-1))
	         {
	        	swap(front, right-1);	
	             needsWork = false;   
	         }
	         else
	         {
	        	 needsWork = false;
	         }
	     }
	     quickSorter(left, front);
	     quickSorter(front + 1, right);
	}
	
	 
	 public static void swap(int a, int b)
	 {
			 System.out.println("Swapping " + array[a] +" and " +array[b]);
			 String temp = array[a];
			 array[a] = array[b];
			 array[b] = temp;
			 System.out.println(Arrays.toString(array));	

	 }
	 
	 
}
