package cipher;

/**
 * Example of Vigenere cipher algorithm
 * @author G.S.
 *
 */
public class Vigenere {
	
	private int offset;
	private int numberOfChars;
	private boolean encrypt = true;
	private boolean decrypt = false;
	
	public Vigenere(){
		offset = (int)'a';
		numberOfChars = 26;
	}
	
	/**
	 * Encrypts text with using keyword. Only letters can be encrypted, 
	 * other symbols will be skipped.
	 * @param key - keyword. Can be any word, without spec.symbols
	 * @param value - any text to cipher.
	 * @return encrypted text
	 */
	public String encrypt(String key, String value){
		return cipher(encrypt, key, value);
	}

	/**
	 * Decrypts text with using keyword. Only letters can be decrypted, 
	 * other symbols will be skipped.
	 * @param key - keyword. Can be any word, without spec.symbols
	 * @param value - any text to cipher.
	 * @return Decrypted text
	 */
	public String decrypt(String key, String value){
		return cipher(decrypt, key, value);
	}

	/**
	 * Main cipher algorithm. It parses strings to chars and process each char separately.
	 * All non-letter chars will be skipped. 
	 * @param direction - boolean flag: "true" - encrypt, "false" - decrypt
	 * @param key - keyword
	 * @param value - text for cipher
	 * @return encrypted/decrypted text
	 */
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
			char newSymbol = cipher(direction, keySymb, valSymb);
			result.append(newSymbol);
			keyIndex++;
			System.out.println("\tVal + Key symbols: " + valSymb + " + " + keySymb + " = " + newSymbol);
		}
		return result.toString();		
	}
	
	/**
	 * Main formula to calculate encrypted/decrypted symbol
	 * according to Vigenere algorithm
	 * @param direction - true/false for encrypt/decrypt
	 * @param value - symbol from text
	 * @param key - symbol from keyword
	 * @return encrypted/decrypted symbol
	 */
	private char cipher (boolean direction, char key, char value){
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
