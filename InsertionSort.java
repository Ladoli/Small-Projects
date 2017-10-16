import java.util.ArrayList;
import java.util.Arrays;
public class InsertionSort {

	public static void main(String[] args) {		
		 int[] array = {32,82,43,11,99,56,25,61,78};
		 System.out.println(Arrays.toString(array));	 
		 ArrayList<Integer> list = InsertionSort(array);
		 printList(list);
	}
	
	public static ArrayList <Integer> InsertionSort(int[] array)
	{
		ArrayList <Integer> list = new ArrayList<Integer>();
		int listsize = 0;
		for(int i: array)
		{
			if(listsize == 0)
			{
				list.add(i);
			}
			else
			{
				int insertIndex = listsize;
				while(i<list.get(insertIndex-1) && insertIndex > 1)
				{
					insertIndex--;
				}
				if(i<list.get(0))
				{
					insertIndex = 0;
				}
				list.add(insertIndex ,i);
			}
			listsize++;
		}
		return list;
	}
	
	public static <T extends Comparable<T>> void printList(ArrayList<T> list)
	 {
		 for (T d : list)
			 System.out.print(d + " ");	 
		 System.out.print("\r\n");
	 }

}
