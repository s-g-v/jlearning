package cipher;

public enum Alphabet {
	EN ((int)'a', 26),
	RU ((int)'а', 32);
	
	private int offset;
	private int numOfChars;
	
	private Alphabet(int start, int length){
		offset = start;
		numOfChars = length;
	}
	
	public final int offset() {
		return offset;
	}
	
	public final int numberOfChars() {
		return numOfChars;
	}
	
	@Override
	public String toString(){
		StringBuilder a = new StringBuilder();
		for (int i = offset; i < offset + numOfChars; i++){
			a.append((char)i);
		}
		return a.toString();
	}
	
}
