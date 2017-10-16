import java.util.ArrayList;
import java.util.Arrays;

public class BinarysearchGeneric {
	
	public static void main(String[] args) {		
		 Comparable[] array = {11, 25, 32, 43, 56, 61, 78, 82, 99};
		 Comparable search = 11;
		 int index = BinarySearch(array, search,0,array.length-1);
		 System.out.println(index);
		
	}
	
	public static <T extends Comparable<T>> int BinarySearch(T[] array, T searchItem, int first, int last)
	{
		if(first == last && searchItem.compareTo(array[first]) == 0)
		{
			return first;
		}
		int pos = -1;
		int mid = (first + last)/2;
		int diff = searchItem.compareTo(array[mid]);
		if(diff == 0)
		{
			pos = mid;
		}
		else if(diff > 0)
		{
			System.out.println(searchItem + " is greater than " + array[mid]);
			pos = BinarySearch(array, searchItem,mid+1,last);
		}
		else
		{
			pos = BinarySearch(array, searchItem,first,mid-1);
		}

			return pos;
	}

}
