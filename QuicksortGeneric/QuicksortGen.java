import java.util.ArrayList;

public class QuicksortGen{
	
	static String[] array = {"32","82","43","11","99","56","25","61","78"};
	static int[] intarray = {32,82,43,11,99,56,25,61,78};
	//static ArrayList<Data> list = new ArrayList<>();
	static ArrayList<StringData> list = new ArrayList<>();

	//static int recursion = 0;
	//To check recursion efficiency
	public static void main(String[] args) {
		
		/*Data temp;
		
		for (Integer i : intarray) {
			temp = new Data();
			temp.n = i;
			list.add(temp);
		}
		*/
		StringData stringtemp;
		
		for (String s : array) {
			stringtemp = new StringData();
			stringtemp.n = s;
			list.add(stringtemp);
		}

	printList(list);	 
	quickSorter(0, list.size(), list);
	printList(list);
	//System.out.println(recursion);		
	}

	
	public static <T extends Comparable<T>> void quickSorter(int left, int right, ArrayList<T> list)
	{
		
		if (list == null || left >= right-1 || left == right ) 
		{
			return; 
		}

		
	     //recursion++;
		 System.out.println("New recursion with element " +left + " and " + right);	
	     int front = left - 1;
	     int last = right - 1;
	     T pivot = list.get(last);
	     boolean needsWork = true;
	     while (needsWork)
	     {
	         while (list.get(++front).compareTo(pivot) < 0);
	         while (list.get(--last).compareTo(pivot) > 0  && last > left);
	         if (front < last)
	         {
	             swap(front,last, list);
	         }
	         else if(front != (right-1))
	         {
	        	 swap(front,right-1, list);
	             needsWork = false;   
	         }
	         else
	         {
	        	 needsWork = false;
	         }
	     }
	     
	     quickSorter(left, front, list);
	     quickSorter(front + 1, right, list);
	}
	
	 
	 public static <T extends Comparable<T>> void swap(int a, int b, ArrayList<T> list)
	 {
			 System.out.println("Swapping " + list.get(a)+" and " +list.get(b));
			 T temp = list.get(a);
			 list.set(a, list.get(b));
			 list.set(b, temp);
			 printList(list);

	 }
	 
	 
	 
	 public static <T extends Comparable<T>> void printList(ArrayList<T> list)
	 {
		 for (T d : list)
			 System.out.print(d + " ");	 
		 System.out.print("\r\n");
	 }
	 
	 
}
