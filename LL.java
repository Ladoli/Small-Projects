import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class LL
{

    
    private class Node implements Comparable
    {
    	int id;
        String name;   
        Node next;      
        

        
        Node(String val, Node n)
        {
        	String[] data = val.split(",");
            id = Integer.parseInt(data[0]);
        	name = data[1];
            next = n;
        } 
        
        
        Node(String val)
        {
           this(val, null);            
        }
        
        public String toString()
        {
        	if(name == null)
        	{
        		return null;
        	}
        	else
			return id + "\t" + name + "\n";
        	
        }

		@Override
		public int compareTo(Object o) {
			Node b = (Node) o;
			return name.compareTo(b.name);
		}
        
        
    }	
	 
    private Node first;  
    private Node last;  
	     
    public LL()
    {
        first = null;
        last = null;        
    }
    
    
    public void InsertionSort(String insertThis)
	{
			if(size() == 0)
			{
				first = new Node(insertThis);
		        last = first;
			}
			else
			{
				Node insertNode = new Node(insertThis);
				Node compareThis = first;
				if(compareThis.next != null && insertNode.compareTo(compareThis) < 0)
				{
					first = insertNode;
				}
				else
				{
					while(compareThis.next != null && insertNode.compareTo(compareThis.next) > 0 )
					{
						compareThis = compareThis.next;
					}
				compareThis.next = new Node(insertThis, compareThis.next);
				}
			}
	}
    

	public boolean isEmpty()
    {        
        return first == null;       
    }
    
    /**
       The size method returns the length of the list.
       @return The number of elements in the list.
    */
    
    
    
    
    
    public int size()
    {
       int count = 0;
       Node p = first;     
       while (p != null)
       {
           count ++;
           p = p.next;
       }
       return count;
    }
    

    public void add(String e)
    {
      if (isEmpty()) 
      {
          first = new Node(e);
          last = first;
      }
      else
      {
    	  InsertionSort(e);
      }      
    }
    
   
    public String toString()
    {
      StringBuilder strBuilder = new StringBuilder();
      
      // Use p to walk down the linked list
      Node p = first;
      while (p != null)
      {
         strBuilder.append(p.id + "\t" + p.name + "\n"); 
         p = p.next;
      }      
      return strBuilder.toString(); 
    }
    
    public String remove(int index)
    {
       if (index < 0 || index >= size())
       {  
           String message = String.valueOf(index);
           throw new IndexOutOfBoundsException(message);
       }
       
       String element;  // The element to return     
       if (index == 0)
       {
          // Removal of first item in the list
          element = first.toString();    
          first = first.next;
          if (first == null)
              last = null;             
       }
       else
       {
          // To remove an element other than the first,
          // find the predecessor of the element to
          // be removed.
          Node pred = first;
          
          // Move pred forward index - 1 times
          for (int k = 1; k <= index -1; k++)
              pred = pred.next;
          
          // Store the value to return
          element = pred.next.toString();
          
          // Route link around the node to be removed
          pred.next = pred.next.next;  
          
          // Check if pred is now last
          if (pred.next == null)
              last = pred;              
       }
       return element;        
    }  
    
    public boolean remove(String element)
    {
       if (isEmpty()) 
           return false;      
      
       if (element.equals(first.toString()))
       {
          // Removal of first item in the list
          first = first.next;
          if (first == null)
              last = null;       
          return true;
       }
      
      // Find the predecessor of the element to remove
      Node pred = first;
      while (pred.next != null && 
             !pred.next.toString().equals(element))
      {
          pred = pred.next;
      }

      // pred.next == null OR pred.next.value is element
      if (pred.next == null)
          return false;
      
      // pred.next.value  is element
      pred.next = pred.next.next;    
      
      // Check if pred is now last
      if (pred.next == null)
          last = pred;
      
      return true;       
    }
    
    public static void main(String [] args)
    {
        LL ll = new LL();
        importdata(ll);
        printLL(ll);


    }
    
    public static void printLL(LL ll)
    {
    	 System.out.println("The members of the list are:");
         System.out.print(ll);
    }
    
    public static void importdata(LL ll)
	{
		File file;
		BufferedReader bR = null;
		String str;
		try
		{
		file = new File("MockData.txt");
		bR = new BufferedReader(new FileReader(file));
		String entry = bR.readLine();
		while(entry != null)
		{
			ll.add(entry);
			entry = bR.readLine();
		}
		}
		catch(IOException e)
		{
			str = "Can not find file";
			System.out.println(str);
		}
		finally
		{
			if(bR != null)
			{
				try 
				{
					bR.close();
				} 
				catch (IOException e) 
				{
					str = "Error on file close";
					System.out.println(str);
				}
			}
		}
	}


}