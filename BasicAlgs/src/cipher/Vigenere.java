package cipher;

public class Vigenere {
	
	public static String encrypt(String key, String value){
		key = key.toLowerCase();
		value = value.toLowerCase();
		StringBuilder result = new StringBuilder();
		for (int valIndex = 0; valIndex < value.length(); valIndex++){
			if (value.charAt(valIndex)==' ') {
				result=result.append(' ');
				continue;
			}
			int keyIndex = valIndex % key.length();
			int valChNum = value.codePointAt(valIndex) - 'a';
			int keyChNum = key.codePointAt(keyIndex) - 'a';
			int resId = (valChNum + keyChNum) % 26;
			result=result.append((char)(resId+'a'));
			System.out.print("\tVal + Key symbols: " + value.charAt(valIndex));
			System.out.println(" + " + key.charAt(keyIndex) + " = " + result.charAt(valIndex));
			
		}
		return result.toString();
	}

	public static String decrypt(String key, String value){
		key = key.toLowerCase();
		value = value.toLowerCase();
		StringBuilder result = new StringBuilder();
		for (int valIndex = 0; valIndex < value.length(); valIndex++){
			if (value.charAt(valIndex)==' ') {
				result=result.append(' ');
				continue;
			}
			int keyIndex = valIndex % key.length();
			int valChNum = value.codePointAt(valIndex);
			int keyChNum = key.codePointAt(keyIndex);
			int resId = (valChNum - keyChNum + 26) % 26;
			result=result.append((char)(resId+'a'));
			System.out.print("\tVal + Key symbols: " + value.charAt(valIndex));
			System.out.println(" + " + key.charAt(keyIndex) + " = " + result.charAt(valIndex));
			
		}
		return result.toString();
	}
}
