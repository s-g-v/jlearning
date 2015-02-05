package cipher;

public class VigenereTest {

	public static void main (String[] args){
		String key = "key";
		String value = "value to test";
		Vigenere cipher = new Vigenere(key); 
		System.out.println("Encrypt...");
		String result = cipher.encrypt(value);
		System.out.println(value + " + " + key + " = " + result);
		System.out.println("Decrypt...");
		value = result;
		result = cipher.decrypt(value);
		System.out.println(value + " + " + key + " = " + result);
	}
}
