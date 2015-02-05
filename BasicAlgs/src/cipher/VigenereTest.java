package cipher;

public class VigenereTest {

	public static void main (String[] args){
		String key = "zkeya";
		String value = "A value to test Z";
		Vigenere cipher = new Vigenere(); 
		
		System.out.println("Encrypt...");
		String result = cipher.encrypt(key, value);
		System.out.println(value + " + " + key + " = " + result);
		
		System.out.println("Decrypt...");
		value = result;
		result = cipher.decrypt(key, value);
		System.out.println(value + " + " + key + " = " + result);
	}
}
