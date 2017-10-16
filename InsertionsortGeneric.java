import java.util.ArrayList;
import java.util.Arrays;
public class InsertionsortGeneric {

	public static void main(String[] args) {		
		 //int[] array = {32,82,43,11,99,56,25,61,78};
		 //Comparable[] array = {"32","82","43","11","99","56","25","61","78"};
		 Comparable[] array = {32,82,43,11,99,56,25,61,78};
		 //ArrayList<Integer> initialList = new ArrayList<Integer>();
		 ArrayList<Comparable> initialList = new ArrayList<Comparable>();

		 for (Comparable d : array)
		 {
			 initialList.add(d);
		 }
		 System.out.println(Arrays.toString(array));	 
		 ArrayList<Comparable> list = InsertionSort(initialList);
		 printList(list);
	}
	
	public static <T extends Comparable<T>> ArrayList <T> InsertionSort(ArrayList <T> initialList)
	{
		ArrayList <T> list = new ArrayList<T>();
		int listsize = 0;
		for(T i: initialList)
		{
			if(listsize == 0)
			{
				list.add(i);
			}
			else
			{
				int insertIndex = listsize;
				while(i.compareTo(list.get(insertIndex-1)) < 0 && insertIndex > 1)
				{
					insertIndex--;
				}
				if(i.compareTo(list.get(0)) < 0)
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
	
	public static <T extends Comparable<T>> int compareTo(T a, T b)
	 {
		 return a.compareTo(b);
	 }

}
