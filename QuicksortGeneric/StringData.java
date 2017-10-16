class StringData implements Comparable<StringData> {
	String n;
		
	
	public int compareTo(StringData d) {
		return n.compareTo(d.n);
	}

	public String toString()
	{
		return n;
	}
}