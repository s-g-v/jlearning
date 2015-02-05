package cipher;

public class Vigenere {
	
	private static int offset = (int)'a';
	private static int numberOfChars = 26;
	
	public static String encrypt(String key, String value){
		key = key.toLowerCase();
		value = value.toLowerCase();
		StringBuilder result = new StringBuilder();
		for (int valIndex = 0; valIndex < value.length(); valIndex++){
			int keyIndex = valIndex % key.length();
			char newSymbol = encrypt(key.charAt(keyIndex), value.charAt(valIndex));
			result=result.append(newSymbol);
			System.out.print("\tVal + Key symbols: " + value.charAt(valIndex));
			System.out.println(" + " + key.charAt(keyIndex) + " = " + result.charAt(valIndex));
			
		}
		return result.toString();
	}

	public static char encrypt (char key, char value){
		char result = value;
		if (key < offset && key > offset + numberOfChars) {
			throw new IllegalArgumentException("Keyword should contain only letters a-z.");
		}
		if (value >= offset && value < offset + numberOfChars) {
			int resId = ((int)key + (int)value - 2*offset) % numberOfChars;
			result = (char) (resId + offset); 
		}
		return result;
	}
	
	public static String decrypt(String key, String value){
		key = key.toLowerCase();
		value = value.toLowerCase();
		StringBuilder result = new StringBuilder();
		for (int valIndex = 0; valIndex < value.length(); valIndex++){
			int keyIndex = valIndex % key.length();
			char newSymbol = decrypt(key.charAt(keyIndex), value.charAt(valIndex));
			result=result.append(newSymbol);
			System.out.print("\tVal - Key symbols: " + value.charAt(valIndex));
			System.out.println(" - " + key.charAt(keyIndex) + " = " + result.charAt(valIndex));
			
		}
		return result.toString();
	}
	
	public static char decrypt (char key, char value){
		char result = value;
		if (key < offset && key > offset + numberOfChars) {
			throw new IllegalArgumentException("Keyword should contain only letters a-z.");
		}
		if (value >= offset && value < offset + numberOfChars) {
			int resId = ((int)value - (int)key + numberOfChars) % numberOfChars;
			result = (char) (resId + offset); 
		}
		return result;
	}
}
