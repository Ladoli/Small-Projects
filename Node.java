
public class Node<T extends Comparable<T>>  {
	private Comparable data;
	private Node<T> left = null, right=null, parent = null;

	
	public <T extends Comparable<T>> Node(T newData)
	{
		data = newData;
	}
	
	public Node(Node<T> node)
	{
		data = node.getData();
	}

	public Comparable<T> getData()
	{
		return data;
	}
	
	public Node<T> getLeft()
	{
		return left;
	}
	
	public Node<T> getRight()
	{
		return right;
	}
	
	public Node<T> getParent()
	{
		return parent;
	}
	
	public void setLeft(Node<T> newLeft)
	{
		left = newLeft;
		left.setParent(this);
	}
	
	public void setRight(Node<T> newRight)
	{
		right = newRight;
		right.setParent(this);
	}
	
	public void setParent(Node<T> newParent)
	{
		parent = newParent;
	}
	
	public void addLeft(Node<T> addThis)
	{
		if(left==null)
		{
			setLeft(addThis);
			addThis.setParent(this);	
		}
		else
			left.addChild(addThis);
	}
	
	public void addRight(Node<T> addThis)
	{
		if(right==null)
		{
			setRight(addThis);
			addThis.setParent(this);	
		}
		else
			right.addChild(addThis);
	}
	
	public void addChild(Node<T> addThis)
	{
		if(this.compareTo(addThis) > 0)
		{
			addLeft(addThis);
		}
		else
		{
			addRight(addThis);
		}
	}
	
	public void disconnect()
	{
		 left = right = parent= null;
	}
	
	public Node<T> getNext()
	{
		Node<T> next = null;
		if(this.right!=null)
		{
			next = right;
			while(next.getLeft() != null)
			{
				next = next.getLeft();
			}
		}
		else
		{
			next = parent;
			while(next.parent != null && next != next.getParent().getLeft())
			{
				next = next.parent;
			}
		}
			return next;
	}
	
	public void print()
	{
		Comparable leftData = "''", rightData = "''"; 
		if(left!=null)
			leftData = left.getData();
		if(right!=null)
			rightData = right.getData();
		System.out.println(leftData + ", " + getData() + ", " + rightData);
	}

	public int compareTo(Node<T> o) {
		return data.compareTo(o.getData());
	}

}
