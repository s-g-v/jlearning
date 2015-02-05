package cipher;

public class Vigenere {
	
	private int offset = (int)'a';
	private int numberOfChars = 26;
	private boolean encrypt = true;
	private boolean decrypt = false;
	private String key;
	
	public Vigenere(String key){
		key = key.toLowerCase();
		checkKey(key);
		this.key = key;
	}

	public String encrypt(String value){
		return cipher(encrypt, value);
	}
	
	public String decrypt(String value){
		return cipher(decrypt, value);
	}

	private void checkKey(String key){
		for (char sym:key.toCharArray()){
			if (sym < offset && sym > offset + numberOfChars) {
				throw new IllegalArgumentException("Keyword should contain only letters a-z.");
			}
		}
	}
	
	private String cipher (boolean direction, String value) {
		value = value.toLowerCase();
		StringBuilder result = new StringBuilder();
		int keyIndex = 0;
		for (char valSymb : value.toCharArray()){
			if (valSymb < offset || valSymb > offset + numberOfChars) {
				result.append(valSymb);
				continue;
			}				
			char keySymb = key.charAt(keyIndex % key.length());
			char newSymbol = cryptSymbol(direction, valSymb, keySymb);
			result.append(newSymbol);
			keyIndex++;
			System.out.println("\tVal + Key symbols: " + valSymb + " + " + keySymb + " = " + newSymbol);
		}
		return result.toString();		
	}
	
	private char cryptSymbol (boolean crypt, char value, char key){
		int resId;
		if (crypt)
			resId = ((int)key + (int)value - 2*offset) % numberOfChars;
		else 
			resId = ((int)value - (int)key + numberOfChars) % numberOfChars;
		return (char) (resId + offset);
	}
}
