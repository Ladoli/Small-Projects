
public class Tree {
	
	
	private Node root;
	private int count = 0;
	public int getCount() {return count;}
	
	public Tree(Node base)
	{
		root = new Node(base);
		count++;
	}
	
	public <T extends Comparable<T>> Tree(T data)
	{
		root = new Node(data);
		count++;
	}
	
	public boolean remove(Node delete)
	{
		count--;
		return true;
	}
	
		
	public void add(Node addThis)
	{
		addThis.disconnect();
		root.addChild(addThis);
		count++;
	}
	
	public Node getRoot()
	{
		return root;
	}
	
	public Node getMin() {
		Node min = root;
		while(min.getLeft() != null)
		{
			min = min.getLeft();
		}
		return min;
	}
	
	public Node getMax() {
		Node max = root;
		while(max.getRight() != null)
		{
			max = max.getRight();
		}
		return max;
	}
	
	public void print()
	{
		Node min = getMin();
		while(min != null)
		{
			min.print();
			if(min != getMax())
			{
				min = min.getNext();
			}
			else
			{
				min = null;
			}	
		}
	}
}
