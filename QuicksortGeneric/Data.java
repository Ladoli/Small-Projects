class Data implements Comparable<Data> {
	int n;
		
	
	public int compareTo(Data d) {
		return n- d.n;
	}
	

	public String toString()
	{
		return Integer.toString(n);
	}
}