package cipher;

public class Vigenere {
	
	private int offset;
	private int numberOfChars;
	private boolean encrypt = true;
	private boolean decrypt = false;
	
	public Vigenere(){
		offset = (int)'a';
		numberOfChars = 26;
	}

	public String encrypt(String key, String value){
		return cipher(encrypt, key, value);
	}
	
	public String decrypt(String key, String value){
		return cipher(decrypt, key, value);
	}

	private String cipher (boolean direction, String key, String value) {
		key = key.toLowerCase();
		checkKey(key);
		int keyIndex = 0;
		StringBuilder result = new StringBuilder();
		value = value.toLowerCase();
		for (char valSymb : value.toCharArray()){
			if (!isLetter(valSymb)) {
				result.append(valSymb);
				continue;
			}				
			char keySymb = key.charAt(keyIndex % key.length());
			char newSymbol = cipher(direction, valSymb, keySymb);
			result.append(newSymbol);
			keyIndex++;
			System.out.println("\tVal + Key symbols: " + valSymb + " + " + keySymb + " = " + newSymbol);
		}
		return result.toString();		
	}
	
	private char cipher (boolean direction, char value, char key){
		int resId;
		if (direction)
			resId = ((int)key + (int)value - 2*offset) % numberOfChars;
		else 
			resId = ((int)value - (int)key + numberOfChars) % numberOfChars;
		return (char) (resId + offset);
	}
	
	private void checkKey(String key){
		for (char sym:key.toCharArray()){
			if (!isLetter(sym)) {
				throw new IllegalArgumentException("Keyword should contain only letters a-z.");
			}
		}
	}
	
	private boolean isLetter(char ch){
		return (ch >= offset && ch < offset + numberOfChars);
	}
}
